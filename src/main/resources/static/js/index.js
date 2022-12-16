"use strict";

import { removeHeaderNavBtn } from "./module/header";
import { setHeaderScroll} from "./module/page/index/pageTop";
import { setRecipeSearchForm } from "./module/recipeSearchForm";
import { setConfirmDialog } from "./module/confirm";
import { setRecipeHref } from "./module/recipeHref";
import { setRecipeHeartBtn } from "./module/recipeHeartBtn";
import { setRecipeImageFilterBtn } from "./module/recipeImageFilterBtn";

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

/* PAGE : login */
if (["/login/form", "/login"].includes(location.pathname)) {
  // RUN -> ヘッダーナビボタン非表示
  removeHeaderNavBtn();
}

/* PAGE : signup */
if (["/signup/form", "/signup"].includes(location.pathname)) {
  // RUN -> ヘッダーナビボタン非表示
  removeHeaderNavBtn();
  // SET -> 登録時確認ダイアログ処理
  setConfirmDialog(".signup__form__btn", "この内容で登録しますか");
}