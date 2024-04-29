document.querySelectorAll('.delete-btn').forEach(button => {
    button.addEventListener('click', () => {
        const userId = button.getAttribute('data-id');
        deleteUser(userId);
    });
});


function deleteUser(userId) {

    console.log("funciona2");

    if (confirm("Tem certeza de que deseja excluir este usuário?")) {
        fetch('/users/' + userId, {
            method: 'DELETE'
        }).then(response => {
            if (response.ok) {
                window.location.reload(); // Atualizar a página após a exclusão
            } else {
                alert('Falha ao excluir o usuário.');
            }
        }).catch(error => {
            console.error('Erro ao excluir o usuário:', error);
            alert('Erro ao excluir o usuário. Por favor, tente novamente mais tarde.');
        });
    }
}