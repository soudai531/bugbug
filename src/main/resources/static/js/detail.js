

const detailFormCover = document.querySelector(".detail_form_cover");
const detailFormClose = document.querySelector(".detail_form_close");
const detailForm = document.querySelector(".detail_form");
const insect_list_item_img = document.querySelector("insect_list_item_img");

insect_list_item_img.addEventListener("click", () => {
  detailFormCover.classList.remove("hidden");
  detailForm.classList.remove("hidden");
});

detailFormCover.addEventListener("click", () => {
  detailFormCover.classList.add("hidden");
  detailForm.classList.add("hidden");
});

detailFormClose.addEventListener("click", () => {
  detailFormCover.classList.add("hidden");
  detailForm.classList.add("hidden");
});