// Função para validar a entrada de números negativos
function validarEntradaNumerica(event) {
    var input = event.target;
    var valor = parseFloat(input.value);

    if (isNaN(valor) || valor < 0) {
        input.value = ''; // Limpa o valor inserido
        alert("Por favor, insira um valor válido e não negativo.");
    }
}

