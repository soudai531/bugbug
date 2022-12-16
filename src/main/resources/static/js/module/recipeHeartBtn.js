"use strict";

const setRecipeHeartBtn = () => {
  const heartBtns = document.querySelectorAll(".heartBtn");
  for(let heartBtn of heartBtns) {
    heartBtn.addEventListener("click", () => {
      const heartBtnIonicon = heartBtn.firstElementChild;
      const heartBtnNum = heartBtn.lastElementChild;
      if(heartBtnIonicon.name == "heart-outline") {
        heartBtnIonicon.name = "heart";
        heartBtnNum.textContent = +heartBtnNum.textContent + 1;
      } else {
        heartBtnIonicon.name = "heart-outline";
        heartBtnNum.textContent = +heartBtnNum.textContent - 1;
      }
    })
  }
}

export { setRecipeHeartBtn };