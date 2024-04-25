document.addEventListener('DOMContentLoaded', () => {
    
    const scriptElement = document.getElementById('nome');

    if (scriptElement) {
    
        const mensagem = scriptElement.getAttribute('data-mensage');

        if (mensagem) {
            alert(mensagem);
        }
    }
});
