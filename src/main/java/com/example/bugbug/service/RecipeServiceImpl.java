package com.example.bugbug.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.bugbug.config.AppConfig;
import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeMaterial;
import com.example.bugbug.entity.RecipeProcedure;
import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;
import com.example.bugbug.repository.MaterialRepository;
import com.example.bugbug.repository.ProcedureRepository;
import com.example.bugbug.repository.RecipeRepository;
import com.example.bugbug.repository.RecipeTagRepository;
import com.example.bugbug.service.dto.RecipeDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeTagRepository recipeTagRepository;
    private final MaterialRepository materialRepository;
    private final ProcedureRepository procedureRepository;

    private final TagService tagService;
    private final AccountService accountService;
    
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
            // Todo　ユーザー情報を格納する
            User user = accountService.findUserId(recipe.getUserId());
            recipeDto.ofUser(user);
            // Todo お気に入り数を格納する

            return recipeDto;
    }
    
    //レシピ登録
    public Recipe saveRecipe(Recipe recipe) {
    	return recipeRepository.save(recipe);
    }
    
    
    
    /**
     * レシピ画像の登録
     * @param recipe_id 登録するレシピのID
     * @return 画像ファイル名
     */
    public String saveRecipeImage(MultipartFile file, int recipe_id){
        // IDのフォーマット(0埋め)
        String RecipeImageFormat = String.format("%010d", recipe_id);
        // ファイル名の作成
        String fileName = "RecipeImage_" + RecipeImageFormat +".jpg";
        // URIの作成
        File dest = new File(appConfig.getDirMap().get("recipe-image"),fileName);
        try {
            //ファイルをパス(dest)に転送する
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }
        // DBにファイル名を保存する
        recipeRepository.updateRecipeImage(fileName,recipe_id);
        return fileName;
    }
    
    //レシピタグの登録
   public void saveTag(int recipe_id,List<String> tags) {
	   //タグリストの要素がある間
    	tags.forEach(tag -> {
    		//IDの取得
    		int tagId = tagService.getId(tag);
    		//登録
    		recipeTagRepository.save(new RecipeTag(null,recipe_id,tagId,0));
    	});
    }
   
   //材料の登録
   public void saveMaterial(int recipe_id,List<String> materials,List<String> amounts) {
	   //材料リストの要素がある間
	   for(int i=0;i < materials.size();i++) {
		   //名前と数量がどちらも入力されている時
		   if(!materials.get(i).equals("") && !amounts.get(i).equals("")) {
			   //登録
			   materialRepository.save(new RecipeMaterial(null,recipe_id,materials.get(i),amounts.get(i)));
			  
		   }
	   }
   }
   
   //手順の登録
   public void saveProcedure(int recipe_id,List<MultipartFile> images,List<String> contexts) {
	   //imageリストに要素がある間
	   for(int i=0;i<images.size();i++) {
		    String image = uploadProcedureImage(images.get(i),recipe_id);
		    if(!contexts.get(i).equals("")) {
		    	procedureRepository.save(new RecipeProcedure(null,recipe_id,image,contexts.get(i),0));
		    }
	   }
   }
   
   /**
    * レシピ画像の登録
    * @param recipe_id 登録するレシピのID
    * @return 画像ファイル名
    */
   public String uploadProcedureImage(MultipartFile file, int recipe_id){
       // IDのフォーマット(0埋め)
       String ProcedureImageFormat = String.format("%010d", recipe_id);
       // ファイル名の作成
       String fileName = "recipe-procedure-images_" + ProcedureImageFormat +".jpg";
       // URIの作成
       File dest = new File(appConfig.getDirMap().get("recipe-procedure-images"),fileName);
       try {
           //ファイルをパス(dest)に転送する
           file.transferTo(dest);
       } catch (IllegalStateException e) {
           // TODO 自動生成された catch ブロック
           e.printStackTrace();
       } catch (IOException e) {
           // TODO 自動生成された catch ブロック
           e.printStackTrace();
       }
       return fileName;
   }
}
