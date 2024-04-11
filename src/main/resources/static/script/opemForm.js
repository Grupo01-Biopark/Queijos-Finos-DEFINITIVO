const buttonAdd = document.getElementById("buttonAdd");
const sectionForm = document.getElementById("sectionForm");
const buttonCancel = document.getElementById("buttonCancel");

buttonAdd.addEventListener("click", () => {
    sectionForm.style.display = "block";
    buttonAdd.style.display = "none";
})

buttonCancel.addEventListener("click", () => {
    
    if (confirm("Tem certeza que deseja cancelar o preenchimento do formulário?")) {
        sectionForm.style.display = "none";
        buttonAdd.style.display = "block";
        clearFormFields();
    }

    // Função para limpar os campos do formulário
    function clearFormFields() {

        const formInputs = sectionForm.querySelectorAll("input");

        formInputs.forEach(input => {
            input.value = "";
        });
    }
});