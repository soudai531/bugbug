"use strict";

import { removeHeaderNavBtn } from "./module/header";
import { setHeaderScroll} from "./module/page/index/pageTop";
import { setRecipeSearchForm } from "./module/recipeSearchForm";
import { setConfirmDialog } from "./module/confirm";
import { setRecipeHref } from "./module/recipeHref";
import { setRecipeHeartBtn } from "./module/recipeHeartBtn";
import { setRecipeImageFilterBtn } from "./module/recipeImageFilterBtn";
import { setRegisterRecipeImage, setRegisterRecipeTag, setRegisterRecipeMaterial, setRegisterRecipeHowto } from "./module/page/RegisterRecipe/pageRegisterRecipe";

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

/* PAGE : registerRecipe */
if (["/recipes/register/form"].includes(location.pathname)) {
  // SET -> レシピ登録[画像]処理
  setRegisterRecipeImage();
  // SET -> レシピ登録[タグ]処理
  setRegisterRecipeTag();
  // SET -> レシピ登録[材料]処理
  setRegisterRecipeMaterial();
  // SET -> レシピ登録[作り方]処理
  setRegisterRecipeHowto();
  // SET -> 登録時確認ダイアログ処理
  setConfirmDialog(".registerRecipe__submitBtn", "この内容で登録しますか");
}