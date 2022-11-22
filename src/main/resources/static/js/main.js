"use strict";

/* ヘッダーHTMLElemtnt取得 */
const header = document.querySelector(".header");
const siteExpl = document.querySelector(".siteExpl");
const logo = document.querySelector(".logo");
const insectFilterBtn = document.querySelector(".insectFilterBtn");
const navBtns = document.querySelector(".navBtns");
const navBtns__btn = document.querySelectorAll(".navBtns__btn");
const navBtns__btn__text = document.querySelectorAll(".navBtns__btn__text");
const main = document.querySelector(".main");

const array = [header, siteExpl, logo, insectFilterBtn, navBtns, ...navBtns__btn, ...navBtns__btn__text, main];

/* スクロール時ヘッダー処理 */
const scrollHeaderHandle = () => {
  if (set_position > document.documentElement.scrollTop) {
    for (let el of array) {
      el.classList.remove("js-headerScrollOn");
    }
  } else {
    if (!header.classList.contains("js-headerScrollOn")) {
      for (let el of array) {
        el.classList.add("js-headerScrollOn");
      }
    }
  }
};
let set_position = 50;
window.addEventListener("scroll", scrollHeaderHandle);

/* ナビボタン遷移先設定 */
const nav_insectBook = document.querySelector(".navBtns__btn--insectBook");
const nav_registerAcount = document.querySelector(".navBtns__btn--registerAcount");
const nav_login = document.querySelector(".navBtns__btn--login");
const navArray = [nav_insectBook, nav_registerAcount, nav_login];
const locationArray = ["insectBook.html", "registerAcount.html", "login.html"];
for (let i = 0, size = navArray.length; i < size; i++) {
  navArray[i].addEventListener("click", () => {
    location.href = locationArray[i];
  });
}

/* 質問解答ボタン遷移先設定 */
const question__btns = document.querySelectorAll(".question__btn");
for (let i = 0, size = question__btns.length; i < size; i++) {
  question__btns[i].addEventListener("click", () => {
    location.href = "./index.html";
  });
}

/* 虫フィルターボタンクリック処理 */
const insectFilter = document.querySelector(".insectFilterBtn__input");
const recipeImgArray = document.querySelectorAll(".recomRecipe__list__item__img");
let recipeImgArrayLength = recipeImgArray.length;
if(recipeImgArrayLength > 0) {
  for (let i = 0 ; i < recipeImgArrayLength ; i++) {
    recipeImgArray[i].originImg = recipeImgArray[i].firstElementChild.src;
  }
}

let filterStarte = false;
insectFilter.addEventListener("click", () => {
  filterStarte = !filterStarte;
  for (let i = 0, size = recipeImgArray.length; i < size; i++) {
    if (filterStarte) {
      recipeImgArray[i].firstElementChild.src = "./img/filter.png";
    } else {
      recipeImgArray[i].firstElementChild.src = recipeImgArray[i].originImg;
    }
  }
});

/* お気に入りボタンクリック処理 */
const hearts = document.querySelectorAll(".recomRecipe__list__item__heartBtn");
for (let el of hearts) {
  el.addEventListener("click", () => {
    const ionicon = el.firstElementChild;
    const heartNum = el.lastElementChild;
    if (ionicon.name === "heart") {
      ionicon.name = "heart-outline";
      heartNum.textContent--;
    } else {
      ionicon.name = "heart";
      heartNum.textContent++;
    }
  });
}

const loading = document.querySelector(".loading");
window.addEventListener("DOMContentLoaded", () => {
  loading.classList.add("ok");
});

/* 検索フォームJS処理 */
const searchFormCover = document.querySelector(".search__form__cover");
const searchFormClose = document.querySelector(".search__form__close");
const searchForm = document.querySelector(".search__form");
const nav_searchRecipe = document.querySelector(".navBtns__btn--searchRecipe");

nav_searchRecipe.addEventListener("click", () => {
  searchFormCover.classList.remove("hidden");
  searchForm.classList.remove("hidden");
});

searchFormCover.addEventListener("click", () => {
  searchFormCover.classList.add("hidden");
  searchForm.classList.add("hidden");
});

searchFormClose.addEventListener("click", () => {
  searchFormCover.classList.add("hidden");
  searchForm.classList.add("hidden");
});
