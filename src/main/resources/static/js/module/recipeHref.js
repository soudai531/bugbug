"use strict";

const setRecipeHref = () => {
  const recipeSections = document.querySelectorAll(".recipeSection");
  for (let element of recipeSections) {
    element.children[0].addEventListener("click", () => {
      location.href = element.dataset.recipeHref;
    });
    element.children[1].addEventListener("click", () => {
      location.href = element.dataset.recipeHref;
    });
    element.children[2].addEventListener("click", () => {
      location.href = element.dataset.recipeHref;
    });
  }
};

export { setRecipeHref };
