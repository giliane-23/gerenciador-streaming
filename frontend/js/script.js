// Seleciona o formulário
const formulario = document.querySelector("#formCliente");

// Evento ao enviar o formulário
formulario.addEventListener("submit", function (event) {
    event.preventDefault(); // Impede recarregar a página

    // Pega os valores dos campos
    const nome = document.getElementById("nome").value;
    const telefone = document.getElementById("telefone").value;
    const painel = document.getElementById("painel").value;
    const telas = document.getElementById("telas").value;
    const valor_do_plano = document.getElementById("valorplano").value;
    const vencimento = document.getElementById("vencimento").value;
    const status = document.getElementById("status").value;

    // Cria o objeto cliente
    const cliente = {
        nome: nome,
        telefone: telefone,
        painel: painel,
        telas: telas,
        valor_do_plano: valor_do_plano,
        vencimento: vencimento,
        status: status
    };

    // Envia para o backend Spring Boot
    fetch("http://localhost:8080/clientes", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(cliente)
    })
        .then(res => res.json())
        .then(data => {
            alert(`Cliente ${data.nome} cadastrado com sucesso!`);
            formulario.reset(); // Limpa o formulário
        })
        .catch(err => {
            console.error("Erro ao cadastrar cliente:", err);
            alert("Erro ao cadastrar cliente, veja o console.");
        });
});

// ----------------------------
// Formata Valor do Plano automaticamente
// ----------------------------
const inputValorPlano = document.getElementById('valorplano');

inputValorPlano.addEventListener('input', (e) => {
    let value = e.target.value.replace(/\D/g, ""); // Remove tudo que não for número
    if (value === "") {
        e.target.value = "";
        return;
    }
    // Formata como moeda R$
    const options = { style: 'currency', currency: 'BRL' };
    e.target.value = new Intl.NumberFormat('pt-BR', options).format(parseFloat(value) / 100);
});

// ----------------------------
// Formata Telefone automaticamente
// ----------------------------
const inputTelefone = document.getElementById('telefone');

inputTelefone.addEventListener('input', (e) => {
    let value = e.target.value.replace(/\D/g, ""); // Remove tudo que não for número
    value = value.substring(0, 11); // Limita a 11 dígitos

    if (value.length > 0) value = "(" + value;
    if (value.length > 3) value = value.slice(0, 3) + ") " + value.slice(3);
    if (value.length > 10) value = value.slice(0, 10) + "-" + value.slice(10);
    else if (value.length > 9) value = value.slice(0, 9) + "-" + value.slice(9);

    e.target.value = value;
});