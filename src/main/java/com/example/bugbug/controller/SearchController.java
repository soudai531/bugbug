package com.example.bugbug.controller;

import com.example.bugbug.entity.Tag;
import com.example.bugbug.service.SearchService;
import com.example.bugbug.service.TagService;
import com.example.bugbug.service.dto.RecipeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class SearchController {

    private final SearchService searchService;
    private final TagService tagService;

    /**
     * キーワードからレシピを検索する
     * @param keyword 検索に使うキーワード
     * @param model
     */
    @GetMapping("search/keyword")
    public String searchKeyword(@RequestParam("q") String keyword, Model model) {
        List<RecipeDto> resultList = searchService.searchKeyword(keyword);
        model.addAttribute("recipes" ,resultList);
        if(resultList.isEmpty()){
            System.out.println(keyword + "の検索に一致する商品はありませんでした。");
            model.addAttribute("error", keyword + "の検索に一致する商品はありませんでした。");
        }
        model.addAttribute("keyword", keyword);
        return "search";
    }

    /**
     *
     * @param tagId 検索に使うタグId
     * @param model
     */
    @GetMapping("search/tag")
    public String searchTag(@RequestParam("tag") String tagId, Model model){
        try{
            List<RecipeDto> resultList = searchService.searchTagId(tagId);
            model.addAttribute("recipes" ,resultList);
            Tag tagEntity = tagService.getTagById(Integer.parseInt(tagId));
            if(resultList.isEmpty()){
                System.out.println(tagEntity.getName() + "の検索に一致する商品はありませんでした。");
                model.addAttribute("error", "タグ：「" + tagEntity.getName() + "」の検索に一致する商品はありませんでした。");
            }
            model.addAttribute("keyword", tagEntity.getName());
        } catch (NullPointerException e) {
            model.addAttribute("error","タグが見つかりませんでした。");

        }


        return "search";
    }
}
