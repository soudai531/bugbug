"use strict";

import { setHeaderScroll } from "./module/page/index/pageTop";
import { setRecipeSearchForm } from "./module/recipeSearchForm";
import { setConfirmDialog } from "./module/confirm";
import { setRecipeHref } from "./module/recipeHref";
import { setRecipeHeartBtn } from "./module/recipeHeartBtn";
import { setRecipeImageFilterBtn } from "./module/recipeImageFilterBtn";
import { setRecipeHowtoImage } from "./module/page/recipe/pageRecipe";

setRecipeSearchForm();

/* PAGE : index */
if (["", "/", "/index", "/index.html"].includes(location.pathname)) {
  // SET -> ヘッダースクロール処理
  setHeaderScroll();
  // SET -> レシピクリック時遷移処理
  setRecipeHref();
  // SET -> レシピハートボタンクリック処理
  setRecipeHeartBtn();
  // SET -> レシピ画像フィルターボタンクリック処理
  setRecipeImageFilterBtn();
}

/* PAGE : recipe */
if (/^\/recipes\/[0-9]*/.test(location.pathname)) {
  // SET -> 作り方画像処理
  setRecipeHowtoImage();
  // SET - > レシピハートボタンクリック処理
  setRecipeHeartBtn();
  // SET -> レシピ画像フィルターボタンクリック処理
  setRecipeImageFilterBtn();
  // SET -> 削除時確認ダイアログ処理
  setConfirmDialog(".recipeDetail__recipeAction__btns__btn--delete", "削除しますか");
}