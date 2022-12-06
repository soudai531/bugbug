package com.example.bugbug.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeMaterial;
import com.example.bugbug.entity.RecipeProcedure;
import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;
import com.example.bugbug.repository.FavoriteRepository;
import com.example.bugbug.repository.MaterialRepository;
import com.example.bugbug.repository.ProcedureRepository;
import com.example.bugbug.repository.RecipeRepository;
import com.example.bugbug.repository.RecipeTagRepository;
import com.example.bugbug.service.dto.RecipeDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private RecipeRepository recipeRepository;
    private RecipeTagRepository recipeTagRepository;
    private FavoriteRepository favoriteRepository;
    private ProcedureRepository procedureRepository;
    private MaterialRepository materialRepository;

    private TagService tagService;
    private AccountService accountService;

    /**
     *レシピをすべて取得
     */
    @Override
    public List<RecipeDto> getAllRecipe(){
        //レシピの全件取得
        List<Recipe> recipes = recipeRepository.findAll();
        // レシピDTOのリストを作成
        List<RecipeDto> recipeDtoList = new ArrayList<>();
        //　レシピをDTOに詰め替える
        for(Recipe recipe :recipes) {
            recipeDtoList.add(repackDto(recipe));
        }
        
        return recipeDtoList;
    }

    /**
     * おすすめのレシピを取得する
     */
    @Override
    public List<RecipeDto> getRecommendRecipe(int page){
        return new ArrayList<RecipeDto>();
    }


    /**
     * レシピ情報からレシピDTOを作成する
     */
    public RecipeDto repackDto(Recipe recipe){
            RecipeDto recipeDto = new RecipeDto(recipe);
            // Todo レシピ画像URLを格納する

            // レシピについているタグIDを取得
            List<RecipeTag> recipeTags = recipeTagRepository.getRecipeTagsId(recipe.getRecipeId());
            //　レシピについているタグのタグ情報をまとめて取得
            List<Tag> tags = tagService.getTags(recipeTags);
            // DTOにタグ情報を格納
            recipeDto.ofTag(tags);
            User user = accountService.findUserId(recipe.getUserId());
            recipeDto.ofUser(user);
            int favoriteNum = favoriteRepository.countFavorite(recipe.getUserId());
            recipeDto.ofFavorite(favoriteNum);
            return recipeDto;
    }
    
    //レシピ一件取得
    public Optional<Recipe> getRecipe(int recipeId) {
    	return recipeRepository.findById(recipeId);
    }
    
    //レシピのタグを表示
    public List<Tag> getRecipeTag(int recipeId){
    	return recipeTagRepository.getRecipeTagsName(recipeId);
    }
    
    //レシピ手順の取得
    public List<RecipeProcedure> getProcedure(int recipeId){
    	return procedureRepository.getProceduresByID(recipeId);
    }
    
  //レシピ材料の取得
    public List<RecipeMaterial> getMaterial(int recipeId){
    	return materialRepository.getMaterialsByID(recipeId);
    }
    
    //ビュー数の増加
    public void addBrow(int recipeId) {
    	recipeRepository.BroweCounta(recipeId);
    }
}
