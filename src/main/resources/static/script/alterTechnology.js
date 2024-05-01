const buttonEdit = document.querySelectorAll("#buttonEdit");

buttonEdit.forEach((button) => {

    button.addEventListener("click", () => {
        const tableRowWithButton = button.closest("tr");
        const technologyId = document.getElementById("technologyId").value;
        const technologyData = {
            id: technologyId,
            name: tableRowWithButton.querySelector("td:nth-child(1)").textContent,

        };

        fillFormWithTechnologyData(technologyData);
        openForm(technologyData);
    })
});

function fillFormWithTechnologyData(technologyData) {
    const formInputs = sectionForm.querySelectorAll("input");


    formInputs.forEach(field => {
        const fieldName = field.name;
        if (technologyData.hasOwnProperty(fieldName)) {
            field.value = technologyData[fieldName];
        }
    });


}

function openForm(technologyData) {
    const sectionForm = document.getElementById("sectionForm");
    const titleForm = document.querySelector(".titleForm");

    titleForm.textContent = "Atualizar Tecnologia: " + technologyData.name;

    const formElement = sectionForm.querySelector("form");
    formElement.setAttribute("action", "/tecnologias/alterar");
    formElement.setAttribute("method", "put");

    sectionForm.style.display = "block";
    buttonAdd.style.display = "none";
}


