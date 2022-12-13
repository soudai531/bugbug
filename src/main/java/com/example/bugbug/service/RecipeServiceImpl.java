package com.example.bugbug.service;

import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;

import com.example.bugbug.form.RecipeRegisterForm;
import com.example.bugbug.repository.MaterialRepository;
import com.example.bugbug.repository.ProcedureRepository;

import com.example.bugbug.repository.FavoriteRepository;
import com.example.bugbug.repository.RecipeTagRepository;

import com.example.bugbug.repository.RecipeRepository;
import com.example.bugbug.service.dto.RecipeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {


    private final MaterialRepository materialRepository;
    private final ProcedureRepository procedureRepository;

    private RecipeRepository recipeRepository;
    private RecipeTagRepository recipeTagRepository;
    private FavoriteRepository favoriteRepository;


    private final TagService tagService;
    private final AccountService accountService;
    private final DateComponent dateComponent;
    
    @Autowired
    private HttpSession session;
    
    // 画像の保存場所を保持しているBean
    private final AppConfig appConfig;

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
        System.out.println(recipeDtoList);
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
}
