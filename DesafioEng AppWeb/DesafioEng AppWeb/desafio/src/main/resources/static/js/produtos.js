$(document).ready(function () {
    carregarTabelaProduto();
});

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

async function calcularFrete() {
    var objeto = new Frete();
    var url = `http://localhost:8080/Venda/calcularFrete`;
    var novo = JSON.stringify(objeto);

    fetch(url, {method: "post", body: novo, headers: {"content-type": "application/json"}})
        .then(response => response.json())
        .then(data =>{
            console.log(data);
        })
        .finally(() =>
            document.getElementById("ModalFrete").style.display = "display"
        );
    // console.log(response);

    //metodo de mudar o valor do frete

}

function carregarSubTotalAndTotal(subTotal) {
    let subtotal = subTotal.toLocaleString('pt-BR', {style: 'currency', currency: 'BRL'});
    let frete;
    let total = subtotal;
    let html = `
        <tr class="total-data">
            <td><strong>Subtotal: </strong></td>
            <td id="subTotal">${subtotal}</td>
        </tr> 
        <tr class="total-data">
            <td><strong>Valor da Entrega: </strong></td>
            <td id="valorEntrega">R$ 0</td>
        </tr>
        <tr class="total-data">
            <td><strong>Total: </strong></td>
            <td id="valorTotal">${total}</td>
        </tr>
    `;

    document.getElementById("tbody_total_data").innerHTML = html;
}

function carregarTabelaProduto() {
    let url = `http://localhost:8080/Produto/produtos?filtro=`;
    let subTotal = 0;
    fetch(url).then(response => response.json())
        .then(data => {
            let html = "";
            for (produto of data) {
                html += `
                        <tr class="table-body-row">
                            <td id="id" class="product-remove">${produto.id}</td>
                            <td id="nome" class="product-name">${produto.nome}</td>
                            <td id="preco" class="product-price">${produto.preco.toLocaleString('pt-BR', {
                    style: 'currency',
                    currency: 'BRL'
                })}</td>
                            <td id="quantidade" class="product-quantity"><input type="number" value="1" min="1"></td>
                            <td id="total" class="product-total">${produto.preco.toLocaleString('pt-BR', {
                    style: 'currency',
                    currency: 'BRL'
                })}</td>
                            </tr>
                         `;
                subTotal += produto.preco;
            }
            document.getElementById("tbody_Produtos").innerHTML = html;
            var quantidadeInputs = document.querySelectorAll("#quantidade input");
            quantidadeInputs.forEach(function (quantidadeInput) {
                quantidadeInput.addEventListener("input", atualizarQuantidade);
            });
            carregarSubTotalAndTotal(subTotal);

        })
    // document.forms[0].reset();
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
    carregarSubTotalAndTotal(subTotal);

}

