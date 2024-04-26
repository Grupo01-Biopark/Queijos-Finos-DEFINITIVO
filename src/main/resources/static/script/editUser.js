const editButtons = document.querySelectorAll(".editBotton");

editButtons.forEach((button) => {

    button.addEventListener("click", function () {

        const tableRowWithButton = button.closest("tr");

        const userData = {
            nameUser: tableRowWithButton.querySelector("td:nth-child(1)").textContent,
            email: tableRowWithButton.querySelector("td:nth-child(2)").textContent,
            tipoUserPermission: tableRowWithButton.querySelector("td:nth-child(3)").textContent,
            userId: tableRowWithButton.querySelector(".delete-btn").getAttribute("data-id")
        };


        fillFormWithUserData(userData);
        opemForm();

    });
});

function fillFormWithUserData(userData) {
    const formInputs = sectionForm.querySelectorAll("input");
    const selectInput = sectionForm.querySelector("#tipoUserPermission");

    formInputs.forEach(field => {
        const fieldName = field.name;
        if (userData.hasOwnProperty(fieldName)) {
            field.value = userData[fieldName];
        }
    });

    selectInput.value = userData.tipoUserPermission;
}

function opemForm() {
    const sectionForm = document.getElementById("sectionForm");
    const titleForm = document.querySelector(".titleForm");

    titleForm.textContent = "atuaizar usuario";

    sectionForm.style.display = "block";
    buttonAdd.style.display = "none";
}