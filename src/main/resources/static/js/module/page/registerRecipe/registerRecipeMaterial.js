"use strict";

const materialList = document.querySelector(".registerRecipe__materials__list");

let materialNumber = 1;

const getMaterialNumber = () => {
  return materialNumber;
};

const setMaterialNumber = () => {
  materialNumber++;
};

const getRegisterRecipeNewMaterialElement = () => {
  return `
    <li class="material" id="matarialId_${getMaterialNumber()}">
      <input class="material__name" type="text" name="materials" placeholder="材料名" />
      <input class="material__amount" type="text" name="amounts" placeholder="数量" />
      <button class="material__deleteBtn" type="button" data-material-id="materialId_${getMaterialNumber()}">
        <ion-icon name="trash-outline"></ion-icon>
      </button>
    </li>
  `;
};

const createNewMaterial = () => {
  materialList.insertAdjacentHTML("beforeend", getRegisterRecipeNewMaterialElement());

  const materialDeleteBtn = materialList.querySelector(`button[data-material-id="materialId_${getMaterialNumber()}"]`);
  materialDeleteBtn.addEventListener("click", () => {
    if(materialList.children.length <= 1) return;
    materialDeleteBtn.parentNode.remove();
  });

  setMaterialNumber();
};

const createNewThreeMaterials = () => {
  for (let i = 0; i < 3; i++) {
    createNewMaterial();
  }
};

const setRegisterRecipeMaterial = () => {
  // 初期材料３つ
  createNewThreeMaterials();

  // 材料追加
  const materialAddBtn = document.querySelector(".material__addBtn");
  materialAddBtn.addEventListener("click", () => {
    createNewMaterial();
  });
};

export { setRegisterRecipeMaterial };
