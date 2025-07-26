<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="utf-8">
    <title>Lista de compras</title>
</head>

<body>
    <h1>Lista de compras</h1>

    <?php
    // declaração do array de itens
    $listaCompras = [
        ["nome" => "Arroz", "quantidade" => 1, "categoria" => "Grãos"],
        ["nome" => "Leite", "quantidade" => 2, "categoria" => "Laticínios"],
        ["nome" => "Pão", "quantidade" => 5, "categoria" => "Padaria"],
        ["nome" => "Maçã", "quantidade" => 6, "categoria" => "Frutas"]
    ];

    // verificação da existência de um item específico:
    function existeItem($listaCompras, $nomeItem)
    {
        foreach ($listaCompras as $item) {
            if ($item["nome"] === $nomeItem) {
                return $item;
            }
        }
        return null;
    }
    // exibição das informações desse item
    $itemEncontrado = existeItem($listaCompras, "Arroz");

    if ($itemEncontrado) {
        echo "Item encontrado: <br>";
        echo "Nome: " . $itemEncontrado["nome"] . "<br>";
        echo "Quantidade: " . $itemEncontrado["quantidade"] . "<br>";
        echo "Categoria: " . $itemEncontrado["categoria"] . "<br><br>";
    } else {
        echo "Item não existe.";
    }
    ?>

</body>

</html>