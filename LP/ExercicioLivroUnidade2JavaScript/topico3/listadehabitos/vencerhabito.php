<?php
$servidor = "localhost";
$usuario = "root";
$senha = "";
$bancodedados = "listadehabito";

// Cria a conexão
$conn = new mysqli(
    $servidor,
    $usuario,
    $senha,
    $bancodedados
);
// Verifica se conectou com sucesso
if ($conn->connect_error) {
    die("Falha na conexão: " . $conn->connect_error);
}
// Atualiza o status de A - ativo para V - vencido
$id = $_GET["id"];
$sqlvencer = " UPDATE habito " . " SET status = 'V' " . " WHERE id = " . $id;
// Verifica se o comando foi executado com sucesso
if (!($conn->query($sqlvencer) === TRUE)) {
    $conn->close();
    die("Erro ao atualizar: " . $conn->error);
}
// Fecha a conexão
$conn->close();
// Redireciona para index
header("Location: alterarhabito.php");
?>