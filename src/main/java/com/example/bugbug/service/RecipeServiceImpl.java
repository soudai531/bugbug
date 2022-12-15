package com.example.bugbug.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.io.File;
import java.io.IOException;
import java.sql.Date;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import lombok.AllArgsConstructor;

import com.example.bugbug.common.DateComponent;
import com.example.bugbug.config.AppConfig;
import com.example.bugbug.entity.Recipe;
import com.example.bugbug.entity.RecipeMaterial;
import com.example.bugbug.entity.RecipeProcedure;
import com.example.bugbug.entity.RecipeTag;
import com.example.bugbug.entity.Tag;
import com.example.bugbug.entity.User;
import com.example.bugbug.form.RecipeRegisterForm;

import com.example.bugbug.repository.MaterialRepository;
import com.example.bugbug.repository.ProcedureRepository;
import com.example.bugbug.repository.FavoriteRepository;
import com.example.bugbug.repository.RecipeRepository;
import com.example.bugbug.repository.RecipeTagRepository;
import com.example.bugbug.service.dto.RecipeDto;



@AllArgsConstructor
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeTagRepository recipeTagRepository;
    private final MaterialRepository materialRepository;
    private final ProcedureRepository procedureRepository;
    private final FavoriteRepository favoriteRepository;
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
            int favoriteNum = favoriteRepository.countFavorite(recipe.getRecipeId());
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

    //レシピ登録
    public Recipe saveRecipe(Recipe recipe) {
    	return recipeRepository.save(recipe);
    }
    
    //登録用エンティティ作成
    @Override
    public Recipe createRecipe(RecipeRegisterForm form) {
    	int image_blurred=0;
        //日付の取得
        Date date = dateComponent.getDate();
        //画像表示フラグの設定
        if(form.getImage_blurred()!=null) {
        	image_blurred = 1;
        }
        //登録するエンティティの作成
        Recipe recipe = new Recipe(null,(Integer) session.getAttribute("user_id"),form.getName()
        					,null,form.getExplanation(),form.getPoint(),image_blurred,0,date,0);
    	return saveRecipe(recipe);
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
        String fileName = "recipe-image_" + RecipeImageFormat +".jpg";
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
   public void saveRecipeTag(int recipe_id,List<String> tags) {
	   //タグリストの要素がある間
    	tags.forEach(tag -> {
    		//タグの登録
    		tagService.saveTag(tag);
    		//IDの取得
    		int tagId = tagService.getTag(tag).getTagId();
    		//登録
    		recipeTagRepository.save(new RecipeTag(null,recipe_id,tagId,0));
    	});
    }
   
   //材料の登録
   public void saveMaterial(int recipe_id,List<String> materials,List<String> amounts) {
	   //材料リストの要素がある間
	   for(int i=0;i < materials.size();i++) {
           // Todo バリデータークラスで相関入力チェックを行う
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
		    
		    if(!contexts.get(i).equals("")) {
		    	RecipeProcedure saved = procedureRepository.save(new RecipeProcedure(null,recipe_id,null,contexts.get(i),0));
		    	String image = saveProcedureImage(images.get(i),saved.getProcedureId());
		    }
	   }
   }
   
   /**
    * 手順画像の登録
    */
   public String saveProcedureImage(MultipartFile file, int ProcedureId){
       // IDのフォーマット(0埋め)
       String ProcedureImageFormat = String.format("%010d", ProcedureId);
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
       // DBにファイル名を保存する
       procedureRepository.updateProcedureImage(fileName,ProcedureId);
       return fileName;
   }
}
