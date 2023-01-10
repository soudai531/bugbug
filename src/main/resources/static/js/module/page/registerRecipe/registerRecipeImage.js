"use strict";

import { imageInputHandle } from "../../imagePreview";

const setRegisterRecipeImage = () => {
  const recipeImageInput = document.querySelector(".registerRecipe__image__input");
  const recipeImagePreview = document.querySelector(".registerRecipe__image__preview");

  recipeImageInput.addEventListener("change", () => {
    imageInputHandle(event, recipeImagePreview);
  });
};

export { setRegisterRecipeImage };
