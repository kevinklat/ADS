<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <title>Lista de hábitos</title>
</head>

<body>
    <div class="center">
        <h1>Lista de hábitos</h1>
        <p>Cadastre aqui os hábitos que você tem que vencer para melhorar sua vida!</p>
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
        $sqlselectativo = " SELECT id " . " , nome " . ",  CASE WHEN STATUS = 'A' THEN 'Ativo' WHEN STATUS = 'V' THEN 'Vencido' END AS status" . " FROM habito where status = 'A' order by status asc";
        $sqlselectvencido = " SELECT id " . " , nome " . ",  CASE WHEN STATUS = 'A' THEN 'Ativo' WHEN STATUS = 'V' THEN 'Vencido' END AS status" . " FROM habito where status = 'V' order by status asc";
        
        $resultado = $conexao->query($sqlselect);
        $resultadoativo = $conexao->query($sqlselectativo);
        $resultadovencido = $conexao->query($sqlselectvencido);

        // Verifica se a query retornou registros
        if (($resultadoativo)->num_rows > 0 || $resultadovencido->num_rows > 0) {
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
                        </tr>

                        <?php
                    } // fim do looping
                    ?>
                </tbody>
            </table>
            <p>Continue mudando sua vida!</p>
            <p>Cadastre mais hábitos!</p>
            <a href="novohabito.php">Cadastrar Hábito</a> <br />
            <a href="alterarhabito.php">Alterar Hábito</a>
            <?php
        } else {
            ?>
            <p>Você não possui hábitos ativos!</p>
            <p>Começe já a mudar sua vida!</p>
            <a href="novohabito.php">Cadastrar Hábito</a> <br />
            <?php
        } // fim do if
// Fecha a conexão com o MySQL
        $conexao->close();
        ?>



    </div>
</body>

</html>