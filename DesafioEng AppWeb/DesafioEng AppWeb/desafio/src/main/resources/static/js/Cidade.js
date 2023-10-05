class Cidade {
    constructor() {
        this.id = document.getElementById("id").value
        this.estado = document.getElementById("estado").value
        this.nome = document.getElementById("nome").value
    }
}

async function confirmar() {
    var objeto = new Cidade();

    if (objeto.id == "") // novo
        var url = `http://localhost:8080/Cidade/insert`;
    else // atualizar
        var url = `http://localhost:8080/Cidade/update`;

    var novo = JSON.stringify(objeto);

    fetch(url, {method: "post", body: novo, headers: {"content-type": "application/json"}})
        .then(response => response.json())
        .finally(() => carregarTabela());

    carregarTabela();
}

function cancelar() {
    document.forms[0].reset();
}

async function apagar(id) {
    if (confirm("Apagar a cidade " + id + " ?")) {
        let url = `http://localhost:8080/Cidade/delete?id=${id}`;
        try {
            await fetch(url);
            carregarTabela();
        } catch (Exception) {
            alert("Erro ao apagar" + error);
        }
    }
}

async function alterar(id) {
    let url = `http://localhost:8080/Cidade/cidade?id=${id}`;
    let cidade = await fetch(url).then(res => res.json());
    try {
        await fetch(url);
        document.getElementById("id").value = cidade.id;
        document.getElementById("estado").value = cidade.estado.id;
        document.getElementById("nome").value = cidade.nome;
    } catch (Exception) {
        alert("Erro ao recuperar dados: " + error);
    }
}

function carregarTabela() {
    let url = `http://localhost:8080/Cidade/cidades?filtro=`;
    fetch(url).then(response => response.json())
        .then(data => {
            let html = "";
            for (cidade of data) {
                html += `
                        <tr><td>${cidade.id}</td><td>(${cidade.estado.sigla}) ${cidade.estado.nome}</td><td>${cidade.nome}</td>
                        <td><i class="material-icons" onclick="alterar(${cidade.id})"> &#xe3c9;</i> </td>
                        <td><i class="material-icons" onclick="apagar(${cidade.id})">&#xe92b;</i></td>
                        </tr>
                         `
            }
            document.getElementById("tb").innerHTML = html;

        })
    document.forms[0].reset();
}


function carregarTipo() {
    const url = `http://localhost:8080/Cidade/estados?filtro=`;
    fetch(url).then(response => response.json())
        .then(data => {
            let op = "<option selected disabled>Selecione uma opção</option>";

            for (estado of data) {
                op += `<option value="${estado.id}">${estado.nome}</option>`;
            }
            document.getElementById("estado").innerHTML = op;

        })
}