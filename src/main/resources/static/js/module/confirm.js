"use strict";

const confirmDialogElement = (confirmText) => {
  return `
    <div class="confirm">
      <span class="confirm__message">${confirmText}</span>
      <div class="confirm__btns">
        <button class="confirm__btns__btn confirm__btns__btn--yes" type="submit">はい</button>
        <button class="confirm__btns__btn confirm__btns__btn--cancel" type="button">キャンセル</button>
      </div>
    </div>
  `;
};

const confirmDialogCoverElement = () => {
  return `
    <div class="confirmDialog__cover"></div>
  `;
};

const createConfirmDialogHtmlElement = (formBtnclassName, confirmText) => {
  document.querySelector("header").insertAdjacentHTML("afterend", confirmDialogCoverElement());
  document.querySelector(formBtnclassName).insertAdjacentHTML("afterend", confirmDialogElement(confirmText));

  const confirmCancelBtn = document.querySelector(".confirm__btns__btn--cancel");
  const confirmDialogCover = document.querySelector(".confirmDialog__cover");

  confirmCancelBtn.addEventListener("click", () => {
    const confirm = document.querySelector(formBtnclassName).nextElementSibling;
    confirm.remove();
    confirmDialogCover.remove();
  });

  confirmDialogCover.addEventListener("click", () => {
    const confirm = document.querySelector(formBtnclassName).nextElementSibling;
    confirm.remove();
    confirmDialogCover.remove();
  });
};

const setConfirmDialog = (formBtnclassName, confirmText) => {
  const formBtns = document.querySelectorAll(formBtnclassName);
  for (let formBtn of formBtns) {
    formBtn.addEventListener("click", () => createConfirmDialogHtmlElement(formBtnclassName, confirmText));
  }
};

export { setConfirmDialog };
