package com.example.bugbug.controller;

import com.example.bugbug.service.SerchService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class SerchController {

    private final SerchService serchService;

    @GetMapping("serch/keyword")
    public String serchkeyword(@RequestParam("q") String keyword, @RequestParam("page") int page, Model model) {
        serchService.serchKeyword;
        return "serch";
    }

    @GetMapping("serch/tag")
    public String serchTag(@RequestParam("tag") String tagId, @RequestParam("page") int page, Model model){

        return "serch";
    }
}
