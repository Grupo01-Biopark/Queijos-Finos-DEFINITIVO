document.addEventListener('DOMContentLoaded', function() {
    const form = document.querySelector('form');
    form.addEventListener('submit', function(event) {
        event.preventDefault();  

        const nome = document.getElementById('name').value;
        const dataDeUpload = document.getElementById('Datadeupload').value;
        const tipoDeDocumento = document.getElementById('TipoDocumento').value;
        const dataDeVencimento = document.getElementById('Data de Vencimento').value;
        const arquivoCarregado = document.getElementById('fileUpload').files[0];

        if (!nome || !dataDeUpload || !tipoDeDocumento || !dataDeVencimento || !arquivoCarregado) {
            alert('Por favor, preencha todos os campos e adicione um documento.');
            return;
        }

        console.log('Nome:', nome);
        console.log('Data de Upload:', dataDeUpload);
        console.log('Tipo de Documento:', tipoDeDocumento);
        console.log('Data de Vencimento:', dataDeVencimento);
        console.log('Documento:', arquivoCarregado.name);
    });

    const buttonAdd = document.getElementById('buttonAdd');
    if (buttonAdd) {
        buttonAdd.addEventListener('click', function(event) {
            handleAddButtonClick(event);
        });
    }
});

function handleAddButtonClick(event) {
    event.preventDefault(); 

    console.log('Botão Adicionar foi clicado');

    window.location.href = 'popups/AddDocument.html';
}
