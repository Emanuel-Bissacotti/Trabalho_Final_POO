# ATIVIDADE FINAL

## Este trabalho final está dividido em duas partes:

    1 - Manipulação de arquivos, persistência de dados em arquivos e recuperação de dados de arquivos

    2 - Comunicação cliente x servidor utilizando sockets


### Parte 1:

Utilizando Java, Manipulação de aquivos e orientação a objetos, crie um cadastro de produtos.
O sistema deverá ter **um menu (com laço infinito)** que ofereça as seguintes possibilidades:

    1 - Cadastrar produto
    2 - Alterar preço produto
    3 - Excluir produto
    4 - Sair do sistema


`A classe produtos deverá possuir os atributos privados: Código, descrição, preço de custo, preço de venda e estoque disponível. Todos os atributos devem possuir getters. Deve existir também um método de venda (redução de estoque). Os setters só devem existir para atributos que vão ser alterados após eles serem construídos.`

### Parte 2
Utilizando a base desenvolvida de cadastro de produtos, agora implemente uma aplicação cliente x servidor

- Crie um cliente que envie para o servidor o código do produto e quantidade.
- O servidor deverá receber a solicitação e fazer a venda do produto, ou seja, baixar o estoque deste produto.
- O servidor deverá verificar se o produto existe (procurar na lista de produtos).
- Caso não exista, deve retornar erro para o cliente.
- O servidor deverá verificar também se tem estoque disponível para venda do produto, caso não tenha estoque, deve informarão cliente e não efetuar a venda.

O cliente fará a venda e enviará para o servidor para validar e efetuar a venda.
- Faça no menu do cliente em um laço infinito a possibilidade de venda. O usuário deverá informar o código do produto e a quantidade. Estes dados devem ser enviados para o servidor para efetuar a venda.
- O cliente não terá arquivos nem dados, somente fará a leitura do código do produto e quantidade e mostrará o retorno do servidor.
O servidor ficará o arquivo e a lista de produtos.
- O servidor fará a manipulação no arquivo, ou seja, reduzir do estoque (chamar o método de venda) e retornará a resposta(se foi efetuada a operação ou não) para o cliente.
- Se o produto existe e possui estoque, a venda deve ser feita e o servidor deverá reduzir do estoque, armazenar na lista e no arquivo.