<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Gravando dados</title>
</head>

<?php
$servidor = "localhost";
$usuario = "root";
$senha = "";
$bd = "PRODUCAO";

$conexao = new mysqli($servidor, $usuario, $senha, $bd);
if ($conexao->connect_error) {
    die("Falha na conexão: " + $conexao->connect_error); // Conexão falhou
}

$sql = "select max(codigo) as codigo from contato";
$resultado = $conexao->query($sql);
if ($resultado->num_rows > 0) {
    $registro = $resultado->fetch_assoc();
    $codigo = $registro["codigo"] + 1;
} else {
    $codigo = 1;
}

$nome = $_POST["nome"];
$sexo = $_POST["sexo"];
$email = $_POST["email"];
$msg = $_POST["mensagem"];

$sql = "insert into contato (codigo, nome, sexo, email, mensagem) values ('" . $codigo . "', '" . $nome . "', '" . $sexo . "', '" . $email . "', '" . $msg . "')";
if (!($conexao->query($sql) === TRUE)) {
    $conexao->close();
    die("Erro: " . $sql . "<br>" . $conexao->error); // Erro na inserção
}

$conexao->close();

echo "Dados gravados com sucesso!";

?>

</html>