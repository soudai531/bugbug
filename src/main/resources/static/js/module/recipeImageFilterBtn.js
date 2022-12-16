"use strict";

const setRecipeImageFilterBtn = () => {
  const insectFilterBtn = document.querySelector(".insectFilterBtn__label");
  const recipeImages = document.querySelectorAll(".recipeImage");
  insectFilterBtn.addEventListener("click", () => {
    for(let recipeImage of recipeImages) {
      recipeImage.classList.toggle("filter");
    }
  })
}

export { setRecipeImageFilterBtn };