"use strict";

window.addEventListener('load', () => {
  const header = document.querySelector(".header");
  const siteExpl = document.querySelector(".siteExpl");
  const logo = document.querySelector(".logo");
  const insectFilterBtn = document.querySelector(".insectFilterBtn");
  const navBtns = document.querySelector(".navBtns");
  const navBtns__btn = document.querySelectorAll(".navBtns__btn");
  const navBtns__btn__text = document.querySelectorAll(".navBtns__btn__text");
  const main = document.querySelector(".main");
  const headerElemnts = [header, siteExpl, logo, insectFilterBtn, navBtns, ...navBtns__btn, ...navBtns__btn__text, main];

  // トップページでのみスクロール処理用クラスを操作
  const paths = ['', '/', '/index', '/index.html'];
  if(paths.includes(location.pathname)) {
    for (let el of headerElemnts) {
      el.classList.remove("js-headerScrollOn");
    }
  }
  
  /* スクロール時ヘッダー処理 */
  const scrollHeaderHandle = () => {
    // トップページでのみスクロール処理
    if(!paths.includes(location.pathname)) return;
    if (set_position > document.documentElement.scrollTop) {
      for (let el of headerElemnts) {
        el.classList.remove("js-headerScrollOn");
      }
    } else {
      if (!header.classList.contains("js-headerScrollOn")) {
        for (let el of headerElemnts) {
          el.classList.add("js-headerScrollOn");
        }
      }
    }
  };
  
  let set_position = 10;
  window.addEventListener("scroll", scrollHeaderHandle);
  
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
  
  /* 検索フォームJS処理 */
  const searchFormCover = document.querySelector(".search__form__cover");
  const searchFormClose = document.querySelector(".search__form__close");
  const searchForm = document.querySelector(".search__form");
  const nav_searchRecipe = document.querySelector(".navBtns__btn--searchRecipe");
  
  nav_searchRecipe.addEventListener("click", () => {
    removeClassHidden(searchFormCover);
    removeClassHidden(searchForm);
  });
  searchFormCover.addEventListener("click", () => {
    addClassHidden(searchFormCover);
    addClassHidden(searchForm);
  });
  searchFormClose.addEventListener("click", () => {
    addClassHidden(searchFormCover);
    addClassHidden(searchForm);
  });
  
  /* ダイアログメソッド */
  const addClassHidden = el => {
    el.classList.add('hidden');
  }
  const removeClassHidden = el => {
    el.classList.remove('hidden');
  }
  
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
});