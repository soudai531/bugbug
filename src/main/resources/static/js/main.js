/* --- header --- */

// HTMLElements
const header = document.querySelector('.header');
const siteExpl = document.querySelector('.siteExpl');
const logo = document.querySelector('.logo');
const insectFilterBtn = document.querySelector('.insectFilterBtn');
const navBtns = document.querySelector('.navBtns');
const navBtns__btn = document.querySelectorAll('.navBtns__btn');
const navBtns__btn__text = document.querySelectorAll('.navBtns__btn__text');
const main = document.querySelector('.main');

// HTMLElemnts配列化
const array = [header, siteExpl, logo, insectFilterBtn, navBtns, ...navBtns__btn, ...navBtns__btn__text, main];


let set_position = 50;
window.addEventListener('scroll', () => {
  if(set_position > document.documentElement.scrollTop) {
    for(let el of array) {
      el.classList.remove('js-headerScrollOn');
    }
  } else {
    for(let el of array) {
      el.classList.add('js-headerScrollOn');
    }
  }
});

/* --- index --- */
// 虫フィルター
const insectFilter = document.querySelector('.insectFilterBtn__input');
const recipeImgArray = document.querySelectorAll('.recomRecipe__item__img');
insectFilter.addEventListener('click', () => {
  for(let i = 1 ; i <= recipeImgArray.length ; i++) {
    recipeImgArray[i - 1].classList.toggle('js-filter');
  }
});

// ハートボタン

