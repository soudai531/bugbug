"use strict";
window.addEventListener("load", () => {
  console.log("jsが読み込まれました");
  const header = document.querySelector(".header");
  const siteExpl = document.querySelector(".siteExpl");
  const logo = document.querySelector(".logo");
  const insectFilterBtn = document.querySelector(".insectFilterBtn");
  const navBtns = document.querySelector(".navBtns");
  const navBtns__btn = document.querySelectorAll(".navBtns__btn");
  const navBtns__btn__text = document.querySelectorAll(".navBtns__btn__text");
  const main = document.querySelector(".main");
  const headerElemnts = [header, siteExpl, logo, insectFilterBtn, navBtns, ...navBtns__btn, ...navBtns__btn__text, main];


  /* 昆虫食図鑑ポップアップ */

  /*蟻 */
  const antDetailCover = document.querySelector(".ant_detail_form_cover"); 
  const antDetailClose =document.querySelector(".ant_detail_form_close");
  const antDetailForm = document.querySelector(".ant_detail_form");
  const antOpen = document.querySelector(".insect_ant");

  antOpen.addEventListener("click", () => {
    antDetailCover.classList.remove("hidden");
    antDetailForm.classList.remove("hidden");
  });

  antDetailCover.addEventListener("click", () => {
    antDetailCover.classList.add("hidden");
    antDetailForm.classList.add("hidden");
  });
  antDetailClose.addEventListener("click", () => {
    antDetailCover.classList.add("hidden");
    antDetailForm.classList.add("hidden");
  });

  /*蝉 */
  const semiDetailCover = document.querySelector(".semi_detail_form_cover"); 
  const semiDetailClose =document.querySelector(".semi_detail_form_close");
  const semiDetailForm = document.querySelector(".semi_detail_form");
  const semiOpen = document.querySelector(".insect_semi");

  semiOpen.addEventListener("click", () => {
    semiDetailCover.classList.remove("hidden");
    semiDetailForm.classList.remove("hidden");
  });

  semiDetailCover.addEventListener("click", () => {
    semiDetailCover.classList.add("hidden");
    semiDetailForm.classList.add("hidden");
  });
  semiDetailClose.addEventListener("click", () => {
    semiDetailCover.classList.add("hidden");
    semiDetailForm.classList.add("hidden");
  });

  /*蜘蛛 */
  const kumoDetailCover = document.querySelector(".kumo_detail_form_cover"); 
  const kumoDetailClose =document.querySelector(".kumo_detail_form_close");
  const kumoDetailForm = document.querySelector(".kumo_detail_form");
  const kumoOpen = document.querySelector(".insect_kumo");

  kumoOpen.addEventListener("click", () => {
    kumoDetailCover.classList.remove("hidden");
    kumoDetailForm.classList.remove("hidden");
  });

  kumoDetailCover.addEventListener("click", () => {
    kumoDetailCover.classList.add("hidden");
    kumoDetailForm.classList.add("hidden");
  });
  kumoDetailClose.addEventListener("click", () => {
    kumoDetailCover.classList.add("hidden");
    kumoDetailForm.classList.add("hidden");
  });
  /*百足*/
  const mukadeDetailCover = document.querySelector(".mukade_detail_form_cover"); 
  const mukadeDetailClose =document.querySelector(".mukade_detail_form_close");
  const mukadeDetailForm = document.querySelector(".mukade_detail_form");
  const mukadeOpen = document.querySelector(".insect_mukade");

  mukadeOpen.addEventListener("click", () => {
    mukadeDetailCover.classList.remove("hidden");
    mukadeDetailForm.classList.remove("hidden");
  });

  mukadeDetailCover.addEventListener("click", () => {
    mukadeDetailCover.classList.add("hidden");
    mukadeDetailForm.classList.add("hidden");
  });
  mukadeDetailClose.addEventListener("click", () => {
    mukadeDetailCover.classList.add("hidden");
    mukadeDetailForm.classList.add("hidden");
  });
  /*コオロギ*/
  const koorogiDetailCover = document.querySelector(".koorogi_detail_form_cover"); 
  const koorogiDetailClose =document.querySelector(".koorogi_detail_form_close");
  const koorogiDetailForm = document.querySelector(".koorogi_detail_form");
  const koorogiOpen = document.querySelector(".insect_koorogi");

  koorogiOpen.addEventListener("click", () => {
    koorogiDetailCover.classList.remove("hidden");
    koorogiDetailForm.classList.remove("hidden");
  });

  koorogiDetailCover.addEventListener("click", () => {
    koorogiDetailCover.classList.add("hidden");
    koorogiDetailForm.classList.add("hidden");
  });
  koorogiDetailClose.addEventListener("click", () => {
    koorogiDetailCover.classList.add("hidden");
    koorogiDetailForm.classList.add("hidden");
  });
  /*甲虫*/
  const koutyuuDetailCover = document.querySelector(".koutyuu_detail_form_cover"); 
  const koutyuuDetailClose =document.querySelector(".koutyuu_detail_form_close");
  const koutyuuDetailForm = document.querySelector(".koutyuu_detail_form");
  const koutyuuOpen = document.querySelector(".insect_koutyuu");

  koutyuuOpen.addEventListener("click", () => {
    koutyuuDetailCover.classList.remove("hidden");
    koutyuuDetailForm.classList.remove("hidden");
  });

  koutyuuDetailCover.addEventListener("click", () => {
    koutyuuDetailCover.classList.add("hidden");
    koutyuuDetailForm.classList.add("hidden");
  });
  koutyuuDetailClose.addEventListener("click", () => {
    koutyuuDetailCover.classList.add("hidden");
    koutyuuDetailForm.classList.add("hidden");
  });
  /*ワーム*/
  const warmDetailCover = document.querySelector(".warm_detail_form_cover"); 
  const warmDetailClose =document.querySelector(".warm_detail_form_close");
  const warmDetailForm = document.querySelector(".warm_detail_form");
  const warmOpen = document.querySelector(".insect_warm");

  warmOpen.addEventListener("click", () => {
    warmDetailCover.classList.remove("hidden");
    warmDetailForm.classList.remove("hidden");
  });

  warmDetailCover.addEventListener("click", () => {
    warmDetailCover.classList.add("hidden");
    warmDetailForm.classList.add("hidden");
  });
  warmDetailClose.addEventListener("click", () => {
    warmDetailCover.classList.add("hidden");
    warmDetailForm.classList.add("hidden");
  });
  /*バッタ*/
  const battaDetailCover = document.querySelector(".batta_detail_form_cover"); 
  const battaDetailClose =document.querySelector(".batta_detail_form_close");
  const battaDetailForm = document.querySelector(".batta_detail_form");
  const battaOpen = document.querySelector(".insect_batta");

  battaOpen.addEventListener("click", () => {
    battaDetailCover.classList.remove("hidden");
    battaDetailForm.classList.remove("hidden");
  });

  battaDetailCover.addEventListener("click", () => {
    battaDetailCover.classList.add("hidden");
    battaDetailForm.classList.add("hidden");
  });
  battaDetailClose.addEventListener("click", () => {
    battaDetailCover.classList.add("hidden");
    battaDetailForm.classList.add("hidden");
  });
});
