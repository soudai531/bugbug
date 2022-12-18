"use strict";

import { getHeaderHtmlElements } from "../../header";

const headerHtmlElements = getHeaderHtmlElements();

const scrollHeaderHandle = () => {
  const set_position = 10;
  const mainHtmlElement = document.querySelector(".main");
  if (set_position > document.documentElement.scrollTop) {
    for (let element of Object.values(headerHtmlElements)) {
      element.classList.remove("js-headerScrollOn");
      mainHtmlElement.classList.remove("js-headerScrollOn");
    }
  } else {
    if (!headerHtmlElements[0].classList.contains("js-headerScrollOn")) {
      for (let element of Object.values(headerHtmlElements)) {
        element.classList.add("js-headerScrollOn");
        mainHtmlElement.classList.add("js-headerScrollOn");
      }
    }
  }
};

const setHeaderScroll = () => {
  for (let element of Object.values(headerHtmlElements)) {
    element.classList.remove("js-headerScrollOn");
  }

  window.addEventListener("scroll", scrollHeaderHandle);
};

export { setHeaderScroll };