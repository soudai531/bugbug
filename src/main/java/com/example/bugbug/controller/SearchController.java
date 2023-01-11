package com.example.bugbug.controller;

import com.example.bugbug.service.SearchService;
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
     * @param page ページ数
     * @param model
     */
    @GetMapping("serch/tag")
    public String searchTag(@RequestParam("tag") String tagId, @RequestParam("page") int page, Model model){

        return "search";
    }
}
