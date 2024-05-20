const openFormButton = document.getElementById("buttonAdd");
const closeFormButton = document.getElementById("buttonCancel");
const sectionForm = document.getElementById("sectionForm");

const formValues = {
    technology: {
        action: "/tecnologias/cadastrar",
        method: "post",
        title: "Nova tecnologia"
    },
    transfer: {
        action: "/transfer/register",
        method: "post",
        title: "Transferencia"
    },
    user: {
        action: "/users/register",
        method: "post",
        title: "Novo usuário"
    },
    
    Document: {
        action: "/Documentos/cadastrar",
        method: "post",
        title: "Novo Documento"
    }
};


openFormButton.addEventListener("click", () => {  
    const page = openFormButton.getAttribute("data-page");
    const formValue = formValues[page] || formValues.user;
    opemForm(formValue);
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

function opemForm(formValues){
    const formAction = sectionForm.querySelector("form");

    formAction.setAttribute("method", formValues.method);
    formAction.setAttribute("action", formValues.action);
    sectionForm.querySelector(".titleForm").textContent = formValues.title;

    sectionForm.style.display = "block";
    openFormButton.style.display = "none";
}

function clearFormFields() {
    const formInputs = document.querySelectorAll("#sectionForm input");

    formInputs.forEach(input => {
        input.value = "";
    });
}