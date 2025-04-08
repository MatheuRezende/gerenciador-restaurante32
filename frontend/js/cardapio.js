
document.addEventListener("DOMContentLoaded", async () => {
  const cardapioDiv = document.getElementById("cardapio");

  const pratos = [
    {
      nome: "Feijoada",
      preco: 29.90,
      imagem: "imagens/feijoada.jpg"
    },
    {
      nome: "Strogonoff de Frango",
      preco: 24.90,
      imagem: "imagens/strogonoff.jpg"
    },
    {
      nome: "Lasanha",
      preco: 27.50,
      imagem: "imagens/lasanha.jpg"
    }
  ];

  pratos.forEach(prato => {
    const card = `
      <div class="card">
        <img src="${prato.imagem}" alt="${prato.nome}">
        <h3>${prato.nome}</h3>
        <p>R$ ${prato.preco.toFixed(2)}</p>
        <button>Pedir</button>
      </div>
    `;
    cardapioDiv.innerHTML += card;
  });
});
