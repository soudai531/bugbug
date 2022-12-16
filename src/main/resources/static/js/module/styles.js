"use strict";

const addClassNameHidden = (element) => {
  element.classList.add("hidden");
};

const removeClassNameHidden = (element) => {
  element.classList.remove("hidden");
};

const addClassNameActive = (element) => {
  element.classList.add("active");
};

const removeClassNameActive = (element) => {
  element.classList.remove("active");
};

export { addClassNameHidden, removeClassNameHidden, addClassNameActive, removeClassNameActive };
