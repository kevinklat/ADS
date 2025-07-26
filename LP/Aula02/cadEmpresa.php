<?php
$host = "localhost";
$user = "root";
$senha = "";
$db = "cadastro";
 
// Conexão
$conn = new mysqli($host, $user, $senha, $db);
 
// Verifica conexão
if ($conn->connect_error) {
    die("Falha na conexão: " . $conn->connect_error);
}
 
// Recebe dados
$nome_empresa = $_POST['nome'];
$cnpj = $_POST['cnpj'];
$telefone = $_POST['telefone'];
$email = $_POST['email'];
 
// Prepara e executa
$sql = "INSERT INTO fornecedor (nome, cnpj, telefone, email) VALUES (?, ?, ?, ?)";
$stmt = $conn->prepare($sql);
$stmt->bind_param("ssss", $nome_empresa, $cnpj, $telefone, $email);
 
if ($stmt->execute()) {
    echo "Empresa cadastrado com sucesso!";
} else {
    echo "Erro: " . $stmt->error;
}
 
$conn->close();
?>