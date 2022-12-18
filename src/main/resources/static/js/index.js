"use strict";

import { setHeaderScroll } from "./module/page/index/pageTop";
import { setRecipeSearchForm } from "./module/recipeSearchForm";
import { setRecipeHref } from "./module/recipeHref";
import { setRecipeHeartBtn } from "./module/recipeHeartBtn";
import { setRecipeImageFilterBtn } from "./module/recipeImageFilterBtn";

setRecipeSearchForm();

/* PAGE : index */
if (["/bugbug/", "/bugbug/index.html"].includes(location.pathname)) {
  // SET -> ヘッダースクロール処理
  setHeaderScroll();
  // SET -> レシピクリック時遷移処理
  setRecipeHref();
  // SET -> レシピハートボタンクリック処理
  setRecipeHeartBtn();
  // SET -> レシピ画像フィルターボタンクリック処理
  setRecipeImageFilterBtn();
}