const buttonAdd = document.getElementById("buttonAdd");
const sectionForm = document.getElementById("sectionForm");
const buttonCancel = document.getElementById("buttonCancel");

buttonAdd.addEventListener("click", () => {
    sectionForm.style.display = "block";
    buttonAdd.style.display = "none";
})

buttonCancel.addEventListener("click", () => {
    
    const alertpopup = document.getElementById("sectionPopupSave");
    alertpopup.style.display= "block";

    document.getElementById("buttonPopupAlertExit").addEventListener("click", ()=>{
        sectionForm.style.display = "none";
        buttonAdd.style.display = "block";
        alertpopup.style.display = "none";
        clearFormFields();
    })
    

    // Função para limpar os campos do formulário
    function clearFormFields() {

        const formInputs = sectionForm.querySelectorAll("input");

        formInputs.forEach(input => {
            input.value = "";
        });
    }
});