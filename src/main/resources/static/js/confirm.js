/* 登録時確認ダイアログ */
const confirmCover = document.querySelector(".confirm__cover");
const confirmClose = document.querySelector(".confirm__btns__btn--no");
const confirmDiv = document.querySelector(".confirm");
const confirmOpen = document.querySelector(".confirm__open");

confirmOpen.addEventListener("click", () => {
  removeClassHidden(confirmCover);
  removeClassHidden(confirmDiv);
});
confirmClose.addEventListener("click", () => {
  addClassHidden(confirmCover);
  addClassHidden(confirmDiv);
});