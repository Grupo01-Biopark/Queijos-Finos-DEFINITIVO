const openFormButton = document.getElementById("buttonAdd");
const closeFormButton = document.getElementById("buttonCancel");

openFormButton.addEventListener("click", () => {
    const sectionForm = document.getElementById("sectionForm");
    const formAction = sectionForm.querySelector("form");

    formAction.setAttribute("method", "post");
    formAction.setAttribute("action", "/users/register");
    sectionForm.querySelector(".titleForm").textContent = "Novo usuário";
    sectionForm.style.display = "block";
    openFormButton.style.display = "none";
});

closeFormButton.addEventListener("click", () => {
    const sectionForm = document.getElementById("sectionForm");
    const alertPopupForm = document.getElementById("popupAlertForm");
    const sectionPopup = document.querySelector(".sectionPopup");

    sectionPopup.style.display = "block";
    alertPopupForm.style.display = "block";

    const exitButton = document.getElementById("buttonPopupAlertExit").addEventListener("click", () => {
        sectionForm.style.display = "none";
        openFormButton.style.display = "block";
        alertPopupForm.style.display = "none";
        clearFormFields();
    });
});

function clearFormFields() {
    const formInputs = document.querySelectorAll("#sectionForm input");

    formInputs.forEach(input => {
        input.value = "";
    });
}
