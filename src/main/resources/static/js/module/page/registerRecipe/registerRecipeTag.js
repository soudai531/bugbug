"use strict";

const tagList = document.querySelector(".registerRecipe__tags");
const tagSelectList = document.querySelector(".tag__select__list");
const tagInput = document.querySelector(".tag__input");

let tagNumber = 1;

const setTagNumber = () => {
  tagNumber++;
};

const getTagNumber = () => {
  return tagNumber;
};

const getTagInputValue = () => {
  return tagInput.value;
};

const resetTagInputValue = () => {
  tagInput.value = "";
};

const getRegisterRecipeSelectTagElement = (element) => {
  return `
    <span class="registerRecipe__tag" id="tagId_${getTagNumber()}">
      <input class="registerRecipe__tag__value" type="hidden" name="tags" value="${element.textContent}" />
      <span class="registerRecipe__tag__name"><span>#</span>${element.textContent}</span>
      <button class="registerRecipe__tag__deleteBtn" type="button" data-tag-id="tagId_${getTagNumber()}">
        <ion-icon name="trash-outline"></ion-icon>
      </button>
    </span>
  `;
};

const getRegisterRecipeNewTagElement = () => {
  return `
    <span class="registerRecipe__tag" id="tagId_${getTagNumber()}">
      <input class="registerRecipe__tag__value" type="hidden" name="tags" value="${getTagInputValue()}" />
      <span class="registerRecipe__tag__name"><span>#</span>${getTagInputValue()}</span>
      <button class="registerRecipe__tag__deleteBtn" type="button" data-tag-id="tagId_${getTagNumber()}">
        <ion-icon name="trash-outline"></ion-icon>
      </button>
    </span>
  `;
};

const OpenAndCloseTagList = (tagSelectBtn) => {
  tagSelectList.classList.toggle("hidden");
  tagSelectBtn.classList.toggle("open");
  if (tagSelectBtn.classList.contains("open")) {
    tagSelectBtn.textContent = "閉じる";
  } else {
    tagSelectBtn.textContent = "一覧から選ぶ";
  }
};

const selectNewTag = (element) => {
  tagList.insertAdjacentHTML("beforeend", getRegisterRecipeSelectTagElement(element));

  const tagDeleteBtn = tagList.querySelector(`button[data-tag-id="tagId_${getTagNumber()}"]`);
  tagDeleteBtn.addEventListener("click", () => {
    tagDeleteBtn.parentNode.remove();
  });

  setTagNumber();
}

const createNewTag = () => {
  tagList.insertAdjacentHTML("beforeend", getRegisterRecipeNewTagElement());

  const tagDeleteBtn = tagList.querySelector(`button[data-tag-id="tagId_${getTagNumber()}"]`);
  tagDeleteBtn.addEventListener("click", () => {
    tagDeleteBtn.parentNode.remove();
  });

  resetTagInputValue();
  setTagNumber();
};

const setRegisterRecipeTag = () => {
  // タグ一覧 表示・非表示
  const tagSelectBtn = document.querySelector(".tag__select__btn");
  tagSelectBtn.addEventListener("click", () => {
    OpenAndCloseTagList(tagSelectBtn);
  });

  // 一覧からタグ追加
  const tagSelectListelements = tagSelectList.firstElementChild.children;
  for(let element of tagSelectListelements) {
    element.addEventListener("click", () => {
      selectNewTag(element);
      OpenAndCloseTagList(tagSelectBtn);
    })
  }

  // テキストボックスから追加
  const tagAddBtn = document.querySelector(".tag__addBtn");
  tagAddBtn.addEventListener("click", () => {
    createNewTag();
  });
};

export { setRegisterRecipeTag };
