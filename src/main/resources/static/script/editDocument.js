const editButtons = document.querySelectorAll(".editButton");

editButtons.forEach((button) => {
    button.addEventListener("click", () => {
        const tableRowWithButton = button.closest("tr");
        const documentData = {
            id: tableRowWithButton.querySelector(".delete-btn").getAttribute("data-id"),
            title: tableRowWithButton.querySelector("td:nth-child(1)").textContent,
            category: tableRowWithButton.querySelector("td:nth-child(2)").textContent,
            dateSystem: tableRowWithButton.querySelector("td:nth-child(3)").textContent,
            date: tableRowWithButton.querySelector("td:nth-child(4)").textContent
        };

        fillFormWithDocumentData(documentData);
        openFormEdit();
    });
});

function fillFormWithDocumentData(documentData) {
    const sectionForm = document.getElementById("sectionForm");
    const formInputs = sectionForm.querySelectorAll("input, select");

    formInputs.forEach(field => {
        const fieldName = field.name;
        if (documentData.hasOwnProperty(fieldName)) {
            field.value = documentData[fieldName];
        }
    });
}

function openFormEdit() {
    const sectionForm = document.getElementById("sectionForm");
    const buttonAdd = document.getElementById("buttonAdd");
    const titleForm = document.querySelector(".titleForm");
    const formAction = sectionForm.querySelector("form");

    formAction.setAttribute("method", "post");
    formAction.setAttribute("action", "/documents/updateDocument");
    titleForm.textContent = "Atualizar Documento";

    sectionForm.style.display = "block";
    buttonAdd.style.display = "none";
}
