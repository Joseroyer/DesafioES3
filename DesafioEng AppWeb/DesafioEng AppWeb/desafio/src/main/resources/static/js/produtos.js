$(document).ready(function () {
    carregarTabelaProduto();
});
let subTotalP = 0;

class Produto {
    constructor() {
        this.id = document.getElementById("id").value
        this.nome = document.getElementById("nome").value
        this.preco = document.getElementById("preco").value
    }
}

class Frete {
    constructor() {
        this.peso = document.getElementById("pesoProduto").value;
        this.distancia = document.getElementById("distancia").value;
    }
}

function calcularFrete() {
    var objeto = new Frete();
    var url = `http://localhost:8080/Venda/calcularFrete`;
    var novo = JSON.stringify(objeto);
    var dataValor = 0;

    fetch(url, {method: "post", body: novo, headers: {"content-type": "application/json"}})
        .then(response => response.json())
        .then(data => {
            console.log(data);
            document.getElementById("valorEntrega").innerHTML = `R$ ${data.valor.toFixed(2)}`;
            calculoTotal(data.valor);
            document.getElementById("forma").innerHTML = `${data.forma}`;
            document.getElementById("prazo").innerHTML = `${data.prazo} Dias`;
        })
    $("#tr_formaEntrega").show();
    $("#tr_prazo").show();
    // carregarSubTotalAndTotal(subTotalP, true);


}

function calculoTotal(valorFrete) {
    let frete = parseFloat(valorFrete);
    console.log(valorFrete);
    /// Obtenha o elemento <td> com o ID "subTotal"
    var tdSubTotal = document.getElementById('subTotal');
// Obtenha o texto dentro do <td>
    var textoSubTotal = tdSubTotal.textContent;
// Remova qualquer caractere não numérico, exceto pontos e vírgulas (para números decimais)
    var valorNumerico = textoSubTotal.replace(/[^\d.,]/g, '');
// Substitua vírgulas por pontos (para formatos de números com vírgula como separador decimal)
    valorNumerico = valorNumerico.replace(',', '.');
// Converta o valor em um número
    var subtotal = parseFloat(valorNumerico);

    var total = valorFrete + subtotal;

    console.log(subtotal); // Agora você tem o valor numérico 19.50
    console.log("Total" + total); // Agora você tem o valor numérico 19.50
    document.getElementById("valorTotal").innerHTML = `R$ ${total.toFixed(2)}`;


}

function carregarSubTotalAndTotal(subTotal, flag) {
    let subtotal = subTotal.toLocaleString('pt-BR', {style: 'currency', currency: 'BRL'});
    let frete;
    let total = subtotal;
    let display = flag == true ? "" : "none";
    let html = `
        <tr class="total-data">
            <td><strong>Subtotal: </strong></td>
            <td id="subTotal">${subtotal}</td>
        </tr> 
        <tr class="total-data">
            <td><strong>Valor da Entrega: </strong></td>
            <td id="valorEntrega"></td>
        </tr>
        <tr id="tr_formaEntrega" class="total-data" style="display: ${display}">
            <td><strong>Forma da entrega: </strong></td>
            <td id="forma"></td>
        </tr>
        <tr id="tr_prazo" class="total-data" style="display: ${display}">
        <td><strong>Prazo: </strong></td>
            <td id="prazo"></td>
        </tr>
        <tr class="total-data">
            <td><strong>Total: </strong></td>
            <td id="valorTotal">${total}</td>
        </tr>
    `;

    document.getElementById("tbody_total_data").innerHTML = html;
}

function carregarTabelaProduto() {
    let url = `http://localhost:8080/Venda/produtos?filtro=`;
    let subTotal = 0;
    fetch(url).then(response => response.json())
        .then(data => {
            let html = "";
            for (produto of data) {
                html += `
                        <tr class="table-body-row">
                            <td id="id" class="product-remove">${produto.id}</td>
                            <td id="nome" class="product-name">${produto.nome}</td>
                            <td id="preco" class="product-price">R$ ${produto.preco.toFixed(2)
                }</td>
                            <td id="quantidade" class="product-quantity"><input type="number" value="1" min="1"></td>
                            <td id="total" class="product-total">R$ ${produto.preco.toFixed(2)
                }</td>
                            </tr>
                         `;
                subTotal += produto.preco;
            }
            document.getElementById("tbody_Produtos").innerHTML = html;
            var quantidadeInputs = document.querySelectorAll("#quantidade input");
            quantidadeInputs.forEach(function (quantidadeInput) {
                quantidadeInput.addEventListener("input", atualizarQuantidade);
            });
            subTotalP = subTotal;
            carregarSubTotalAndTotal(subTotal, true);

        })
}

function atualizarQuantidade() {
    var quantidadeInput = this;
    var precoSpan = quantidadeInput.parentNode.previousElementSibling;
    var totalSpan = quantidadeInput.parentNode.nextElementSibling;

    var quantidade = parseFloat(quantidadeInput.value);
    var preco = parseFloat(precoSpan.textContent.replace("R$", "").replace(",", ".")); // Converte para float

    var total = quantidade * preco;

    // Formata o total como um valor em reais (BRL)
    totalSpan.textContent = "R$ " + total.toFixed(2);

    // Atualiza o subtotal e o total
    atualizarSubTotalETotal();
}

function atualizarSubTotalETotal() {
    var subTotal = 0;
    var totalInputs = document.querySelectorAll(".product-quantity input");
    totalInputs.forEach(function (quantidadeInput) {
        var quantidade = parseFloat(quantidadeInput.value);
        var precoSpan = quantidadeInput.parentNode.previousElementSibling;
        var preco = parseFloat(precoSpan.textContent.replace("R$", "").replace(",", "."));
        subTotal += quantidade * preco;
    });
    carregarSubTotalAndTotal(subTotal,true);

}

