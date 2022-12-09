"use strict";

window.addEventListener("load", () => {
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
  const indexPaths = ["", "/", "/index", "/index.html"];
  if (indexPaths.includes(location.pathname)) {
    for (let el of headerElemnts) {
      el.classList.remove("js-headerScrollOn");
    }
  }

  // ログイン・アカウント作成ページはナビボタンを非表示
  const headerHiddenPaths = ["/sinup/form", "/sinup", "/login/form", "/login"];
  if (headerHiddenPaths.includes(location.pathname)) {
    navBtns.style.display = "none";
    insectFilterBtn.style.display = "none";
  }

  /* スクロール時ヘッダー処理 */
  const scrollHeaderHandle = () => {
    // トップページでのみスクロール処理
    if (!indexPaths.includes(location.pathname)) return;
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
  if (recipeImgArrayLength > 0) {
    for (let i = 0; i < recipeImgArrayLength; i++) {
      recipeImgArray[i].originImg = recipeImgArray[i].firstElementChild.src;
    }
  }
  let filterStarte = false;
  insectFilter.addEventListener("click", () => {
    filterStarte = !filterStarte;
    for (let i = 0, size = recipeImgArray.length; i < size; i++) {
      if (filterStarte) {
        recipeImgArray[i].firstElementChild.src = "../img/filter.png";
      } else {
        recipeImgArray[i].firstElementChild.src = recipeImgArray[i].originImg;
      }
    }
  });

  /* ダイアログメソッド */
  const addClassHidden = (el) => {
    el.classList.add("hidden");
  };
  const removeClassHidden = (el) => {
    el.classList.remove("hidden");
  };

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

  /* 登録時確認ダイアログ */
  const confirmPaths = ["/sinup/form", "/sinup"];
  if (confirmPaths.includes(location.pathname)) {
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
  }

  /* お気に入りボタンクリック処理(仮) */
  const hearts = document.querySelectorAll(".heartBtn");
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

// レシピ登録 画像プレビュー
const inputImage = document.querySelector(".registerRecipe__image__input");
const inputLabelText = document.querySelector(".registerRecipe__image__input__label__text");
const inputImagePreview = document.querySelector(".registerRecipe__image__preview");

inputImage.addEventListener("change", () => {
  const [file] = event.target.files;

  if (file) {
    inputImagePreview.setAttribute("src", URL.createObjectURL(file));
    inputLabelText.textContent = "画像を変更";
  }
});

let materialdeleteBtns = document.querySelectorAll(".material__deleteBtn");

// レシピ登録 材料追加
const materialsList = document.querySelector(".registerRecipe__materials__list");
const materialAddBtn = document.querySelector(".material__addBtn");

materialAddBtn.addEventListener("click", () => {
  const el = document.createElement("li");
  const material__name = document.createElement("input");
  material__name.className = "material__name";
  material__name.type = "text";
  const material__amount = document.createElement("input");
  material__amount.className = "material__amount";
  material__name.type = "text";
  const material__deleteBtn = document.createElement("button");
  material__deleteBtn.className = "material__deleteBtn";
  material__deleteBtn.type = "button";
  const ionicon = document.createElement("ion-icon");
  ionicon.name = "trash-outline";
  material__deleteBtn.appendChild(ionicon);
  el.appendChild(material__name);
  el.appendChild(material__amount);
  el.appendChild(material__deleteBtn);
  materialAddBtn.before(el);

  materialdeleteBtns = document.querySelectorAll(".material__deleteBtn");
  // レシピ登録 材料削除
  for (let btn of materialdeleteBtns) {
    btn.addEventListener("click", () => {
      const el = btn.parentNode;
      if (materialdeleteBtns.length > 1) {
        el.remove();
        materialdeleteBtns = document.querySelectorAll(".material__deleteBtn");
      }
      console.log(materialdeleteBtns.length);
    });
  }
});

// 作り方 画像プレビュー
const howtoImage = document.querySelector(".howto__image");
const howtoImageInput = document.querySelector(".howto__image__input");
const hoetoImageInputLabelText = document.querySelector(".howto__image__input__label__text");
const howtoImagePreview = document.querySelector(".howto__image__preview");

const howtoImageDeleteBtn = document.createElement("button");
howtoImageDeleteBtn.className = "howto__image__deleteBtn";
howtoImageDeleteBtn.type = "button";
const howtoImageDeleteBtnIonicon = document.createElement("ion-icon");
howtoImageDeleteBtnIonicon.name = "trash-outline";
howtoImageDeleteBtn.appendChild(howtoImageDeleteBtnIonicon);

let howtoImageInputs = document.querySelectorAll(".howto__image__input");

for (let input of howtoImageInputs) {
  input.addEventListener("change", () => {
    const [file] = event.target.files;
    if (file) {
      howtoImagePreview.setAttribute("src", URL.createObjectURL(file));
      hoetoImageInputLabelText.textContent = "画像を変更";
      howtoImage.style.height = "120px";
      howtoImage.appendChild(howtoImageDeleteBtn);
      const howtoImageDeleteBtns = document.querySelectorAll(".howto__image__deleteBtn");
      for (let btn of howtoImageDeleteBtns) {
        btn.addEventListener("click", () => {
          const parent = btn.parentNode;
          parent.style.height = "40px";
          parent.firstElementChild.src = "";
          const inputLabel = parent.previousElementSibling;
          inputLabel.firstElementChild.textContent = "画像を選択";
          inputLabel.lastElementChild.value = "";
          btn.remove();
        });
      }
    }
  });
}

const howtoImageDeleteBtns = document.querySelectorAll(".howto__image__deleteBtn");
for (let btn of howtoImageDeleteBtns) {
  btn.addEventListener("click", () => {
    btn.parentNode.style.height = "40px";
    btn.remove();
  });
}

// レシピ登録 作り方追加
const howtoList = document.querySelector(".registerRecipe__howto__list");
const howtoAddBtn = document.querySelector(".howto__addBtn");

let howtoDeleteBtns = document.querySelectorAll(".howto__deleteBtn");

howtoAddBtn.addEventListener("click", () => {
  const howto = document.createElement("div");
  howto.className = "howto";

  const howtoAction = document.createElement("div");
  howtoAction.className = "howto__action";

  const howtoNum = document.createElement("span");
  howtoNum.className = "howto__num";
  howtoNum.textContent = 2;

  howtoAction.appendChild(howtoNum);

  const howtoDeleteBtn = document.createElement("button");
  howtoDeleteBtn.className = "howto__deleteBtn";
  howtoDeleteBtn.type = "button";

  const ionicon = document.createElement("ion-icon");
  ionicon.name = "trash-outline";

  howtoDeleteBtn.appendChild(ionicon);

  howtoAction.appendChild(howtoDeleteBtn);

  howto.appendChild(howtoAction);

  const howtoItem = document.createElement("div");
  howtoItem.className = "howto__item";

  const howtoImageInputLabel = document.createElement("label");
  howtoImageInputLabel.className = "howto__image__input__label";

  const howtoImageInputLabelText = document.createElement("span");
  howtoImageInputLabelText.className = "howto__image__input__label__text";
  howtoImageInputLabelText.textContent = "画像を選択";

  const howtoImageInput = document.createElement("input");
  howtoImageInput.className = "howto__image__input";
  howtoImageInput.type = "file";
  howtoImageInput.accept = "image/jpeg,image/png";

  howtoImageInputLabel.appendChild(howtoImageInputLabelText);
  howtoImageInputLabel.appendChild(howtoImageInput);

  howtoItem.appendChild(howtoImageInputLabel);

  const howtoImage = document.createElement("div");
  howtoImage.className = "howto__image";

  const howtoImagePreview = document.createElement("img");
  howtoImagePreview.className = "howto__image__preview";

  howtoImage.appendChild(howtoImagePreview);

  howtoItem.appendChild(howtoImage);

  const howtoText = document.createElement("div");
  howtoText.className = "howto__text";
  howtoText.textContent = "作り方テキストテキストテキストテキストテキストテキストテキストテキストテキストテキストテキストテキストテキスト";

  howtoItem.appendChild(howtoText);

  howto.appendChild(howtoItem);

  howtoList.appendChild(howto);

  howtoDeleteBtns = document.querySelectorAll(".howto__deleteBtn");
  // レシピ登録 材料削除
  for (let btn of howtoDeleteBtns) {
    btn.addEventListener("click", () => {
      const el = btn.parentNode.parentNode;
      if (howtoDeleteBtns.length > 1) {
        el.remove();
        howtoDeleteBtns = document.querySelectorAll(".howto__deleteBtn");
      }
      console.log(howtoDeleteBtns.length);
    });
  }
});
