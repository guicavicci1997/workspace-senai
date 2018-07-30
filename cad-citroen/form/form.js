function validaForm(){
    nome = document.getElementsByName("nome")

    if (nome != null) {
        return true;
    }
    else {
        alert("O nome não pode estár em branco");

    }

}