"use strict";

import { addClassNameHidden, removeClassNameHidden } from "./styles";

const searchRecipeFormCover = document.querySelector(".search__form__cover");
const searchRecipeFormClose = document.querySelector(".search__form__close");
const searchRecipeForm = document.querySelector(".search__form");
const toSearchRecipeBtn = document.querySelector(".navBtns__btn--searchRecipe");

const setRecipeSearchForm = () => {
  // click <toSearchRecipeBtn> -> opqn <searchRecipeForm>
  toSearchRecipeBtn.addEventListener("click", () => {
    removeClassNameHidden(searchRecipeFormCover);
    removeClassNameHidden(searchRecipeForm);
  });

  // click <toSearchRecipeFormCover> -> close <searchRecipeForm>
  searchRecipeFormCover.addEventListener("click", () => {
    addClassNameHidden(searchRecipeFormCover);
    addClassNameHidden(searchRecipeForm);
  });

  // click <toSearchRecipeFormClose> -> close <searchRecipeForm>
  searchRecipeFormClose.addEventListener("click", () => {
    addClassNameHidden(searchRecipeFormCover);
    addClassNameHidden(searchRecipeForm);
  });
}


export { setRecipeSearchForm };
