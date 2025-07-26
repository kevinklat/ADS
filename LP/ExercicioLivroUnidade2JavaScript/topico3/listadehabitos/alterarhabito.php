<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <title>Alterar hábitos</title>
</head>

<body>
    <div class="center">
        <h1>Lista de hábitos</h1>
        <p>Altere habitos que ja passaram pela sua vida.</p>
        <?php
        // Obtém a lista de hábitos do banco de dados MySQL
        $servidor = "localhost";
        $usuario = "root";
        $senha = "";
        $bancodedados = "listadehabito";
        // Cria uma conexão com o banco de dados
        $conexao = new mysqli(
            $servidor,
            $usuario,
            $senha,
            $bancodedados
        );

        // Verifica a conexão
        if ($conexao->connect_error) {
            die("Falha na conexão: " .
                $conexao->connect_error);
        }
        // Executa a query da variável $sql
        $sqlselect = " SELECT id " . " , nome " . ",  CASE WHEN STATUS = 'A' THEN 'Ativo' WHEN STATUS = 'V' THEN 'Vencido' END AS status" . " FROM habito order by status asc";
        $resultado = $conexao->query($sqlselect);
        // Verifica se a query retornou registros
        if ($resultado->num_rows > 0) {
            ?>
            <br />
            <table class="center">
                <tbody>
                    <?php
                    // Looping pelos registros retornados
                    while ($registro = $resultado->fetch_assoc()) {
                        ?>
                        <tr>
                            <td><?php echo $registro["nome"]; ?></td>
                            <td><?php echo $registro["status"]; ?></td>
                            <td><a href="vencerhabito.php?id=<?php
                            echo $registro["id"]; ?>">Vencer</a></td>
                            <td><a href="ativarhabito.php?id=<?php
                            echo $registro["id"]; ?>">Ativar</a></td>
                            <td><a href="desistirhabito.php?id=<?php
                            echo $registro["id"]; ?>">Deletar</a></td>
                        </tr>

                        <?php
                    } // fim do looping
                    ?>
                </tbody>
            </table>
            <p>Continue mudando sua vida!</p>
            <p>Cadastre mais hábitos!</p>
            <?php
        } else {
            ?>
            <p>Você não possui hábitos cadastrados!</p>
            <p>Começe já a mudar sua vida!</p>
            <?php
        } // fim do if
// Fecha a conexão com o MySQL
        $conexao->close();
        ?>

        <a href="novohabito.php">Cadastrar Hábito</a><br />
        <a href="index.php">Lista de hábitos</a>
    </div>

</body>

</html>