"use strict";

const header = document.querySelector(".header");
const logo = document.querySelector(".logo");
const siteExpl = document.querySelector(".siteExpl");
const insectFilterBtn = document.querySelector(".insectFilterBtn");
const navBtns = document.querySelector(".navBtns");
const navBtnList = document.querySelectorAll(".navBtns__btn");
const navBtnTextList = document.querySelectorAll(".navBtns__btn__text");

const getHeaderHtmlElements = () => {
  return [header, logo, siteExpl, insectFilterBtn, navBtns, ...navBtnList, ...navBtnTextList];
};

const removeHeaderNavBtn = () => {
  navBtns.remove();
  insectFilterBtn.remove();
};

export { getHeaderHtmlElements, removeHeaderNavBtn };
