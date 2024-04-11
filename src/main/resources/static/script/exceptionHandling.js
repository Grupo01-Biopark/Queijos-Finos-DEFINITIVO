// pesquisar uma outra forma de excultar a funcao para exibir as execoes
document.addEventListener('DOMContentLoaded', ()=> {
           
    // Obtem a mensagem passada do controlador
    const mensagem = document.getElementById("nome").innerText;

    // Se houver uma mensagem, exibir o popup
    if (mensagem) {
        alert(mensagem);
    }
});