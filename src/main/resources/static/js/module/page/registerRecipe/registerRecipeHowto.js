"use strict";

import { imageInputHandle } from "../../imagePreview";
import { addClassNameHidden, removeClassNameHidden } from "../../styles";

const howtoList = document.querySelector(".registerRecipe__howto__list");

let howtoNumber = 1;

const getHowtoNumber = () => {
  return howtoNumber;
};

const setHowtoNumber = () => {
  howtoNumber++;
};

const resetHowtoIndex = () => {
  for (let [index, element] of Object.entries(howtoList.children)) {
    const howtoNum = element.querySelector(".howto__num");
    howtoNum.textContent = +index + 1;
  }
};

const getRegisterRecipeNewHowtoElement = () => {
  return `
    <div class="howto" id="howtoId_${getHowtoNumber()}">
      <div class="howto__action">
        <span class="howto__num">${howtoList.children.length + 1}</span>
        <button class="howto__deleteBtn" type="button" data-howto-id="howtoId_${getHowtoNumber()}">
          <ion-icon name="trash-outline"></ion-icon>
        </button>
      </div>
      <div class="howto__item">
        <label class="howto__image__input__label">
          <span class="howto__image__input__label__text">画像を選択</span>
          <input class="howto__image__input" type="file" name="procedureImages" accept="image/jpeg,image/png" />
        </label>
        <div class="howto__image" style="height: 40px">
          <img class="howto__image__preview" />
          <button class="howto__image__deleteBtn hidden" type="button">
            <ion-icon name="trash-outline"></ion-icon>
          </button>
        </div>
        <textarea class="howto__text" name="contexts" placeholder="作り方を入力"></textarea>
      </div>
    </div>
  `;
};

const createNewHowto = () => {
  howtoList.insertAdjacentHTML("beforeend", getRegisterRecipeNewHowtoElement());

  const howto = howtoList.querySelector(`#howtoId_${getHowtoNumber()}`);

  const howtoDeleteBtn = howto.querySelector(".howto__deleteBtn");
  howtoDeleteBtn.addEventListener("click", () => {
    if (howtoList.children.length <= 1) return;
    howto.remove();
    resetHowtoIndex();
  });

  const howtoImage = howto.querySelector(".howto__image");
  const howtoImageInput = howto.querySelector(".howto__image__input");
  const howtoImagePreview = howtoImage.firstElementChild;
  const howtoImageDeleteBtn = howtoImage.lastElementChild;

  howtoImageInput.addEventListener("change", () => {
    howtoImage.style.height = "100px";
    imageInputHandle(event, howtoImagePreview);
    removeClassNameHidden(howtoImageDeleteBtn);
  });

  howtoImageDeleteBtn.addEventListener("click", () => {
    howtoImage.style.height = "40px";
    howtoImagePreview.src = "";
    howtoImageInput.value = "";
    addClassNameHidden(howtoImageDeleteBtn);
  });

  setHowtoNumber();
};

const createNewTwoHowtos = () => {
  for (let i = 0; i < 2; i++) {
    createNewHowto();
  }
};

const setRegisterRecipeHowto = () => {
  // 初期作り方2つ
  createNewTwoHowtos();

  // 作り方追加
  const howtoAddBtn = document.querySelector(".howto__addBtn");
  howtoAddBtn.addEventListener("click", () => {
    createNewHowto();
  });
};

export { setRegisterRecipeHowto };
