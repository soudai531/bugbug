package com.example.bugbug.repository;

import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.example.bugbug.entity.RecipeProcedure;



public interface ProcedureRepository extends CrudRepository<RecipeProcedure, Integer> {
	//手順画像の更新
 	@Modifying
 	@Query("UPDATE recipe_procedures SET image = :fileName WHERE procedure_id = :procedureId")
 	void updateProcedureImage(@Param("fileName") String fileName, @Param("procedureId") int procedureId);


 	/**
     * レシピに紐づいている手順をリストで返す
     * @param recipeId レシピid
     * @return レシピに紐づいている手順
     */
    @Query("SELECT * FROM recipe_procedures WHERE recipe_id = :recipeId")
	List<RecipeProcedure> getProceduresByID(@Param("recipeId")int recipeId);
}
