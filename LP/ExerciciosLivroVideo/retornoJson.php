<?php
$servidor = "localhost";
$usuario = "root";
$senha = "";
$bancodedados = "PRODUCAO";

$conexao = new mysqli($servidor, $usuario, $senha, $bancodedados);
if ($conexao->connect_error) {
    die("A conexão falhou: " . $conexao->connect_error);
}

// pegar último código gravado
$sql = "SELECT CODIGO, NOME, MENSAGEM FROM CONTATO";
$resultado = $conexao->query($sql);

if ($resultado->num_rows > 0) {
    $registro = $resultado->fetch_assoc();
    // para formar um objeto json
    $jsonHabitoArray = array();
    $contador = 0;

    while ($registro = $resultado->fetch_assoc()) {
        // monta um objeto Json através do array
        $jsonHabito = array();
        $jsonHabito["CODIGO"] = $registro["CODIGO"];
        $jsonHabito["NOME"] = $registro["NOME"];
        $jsonHabito["MENSAGEM"] = $registro["MENSAGEM"];
        $jsonHabitoArray[$contador++] = $jsonHabito;
    }

    // transformação do array em um objeto array
    echo json_encode($jsonHabitoArray);
} else {
    echo "Nenhum registro encontrado";
}
?>