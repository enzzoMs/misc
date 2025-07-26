let amigos = [];

function adicionarAmigo() {
    const inputAmigo = document.getElementById("amigo");
    if (inputAmigo.value.trim() === "") {
        alert("Por favor, insira um nome.");
        return;
    }

    const amigo = inputAmigo.value;
    amigos.push(amigo);

    inputAmigo.value = '';
    document.getElementById("resultado").innerHTML = "";

    atualizarAmigos();
}

function atualizarAmigos() {
    const lista = document.getElementById("listaAmigos");
    lista.innerHTML = "";

    for (const amigo of amigos) {
        const itemAmigo = document.createElement("li");
        itemAmigo.textContent = amigo;
        lista.appendChild(itemAmigo);
    }
}

function sortearAmigo() {
    if (amigos.length === 0) {
        alert("Por favor, insira um nome.");
        return;
    }

    const indexAleatorio = Math.floor(Math.random() * amigos.length);
    const amigoSorteado = amigos[indexAleatorio];

    const resultado = document.getElementById("resultado");
    resultado.innerHTML = `O amigo secreto sorteado é: ${amigoSorteado}`;

    amigos = [];
    atualizarAmigos();
}