<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>Dados do Formulario</title>
    <style>
        table.bordasimples {
            border-collapse: collapse;
        }

        table.bordasimples tr td {
            border: 1px solid #ff0000;
        }

        td:hover {
            background-color: #f0f0f0;
            text-decoration: underline;
        }
    </style>
</head>

<body>
    <table class="bordasimples">
        <tr class="even">
            <td>Nome</td>
            <td>Sexo</td>
            <td>E-mail</td>
            <td>Mensagem</td>
            <td>Compra com meu salario</td>
        </tr>

        <?php
        $contador = 0;
        for ($contador = 1; $contador <= 4; $contador++) { ?>
            <tr class="even">
                <td><?php echo $_POST["nome"]; ?></td>
                <td>
                    <?php
                    if ($_POST["sexo"] == "masculino") {
                        echo "<img src='homem.jpg' height='100px'/>";
                    } else {
                        echo "<img src='mulher.jpg' height='100px'/>";
                    }
                    ?>
                </td>
                <td><?php echo $_POST["email"]; ?></td>
                <td><?php echo $_POST["mensagem"]; ?></td>
                <td>
                    <?php
                    $mensagemDeErro = "";
                    switch ($_POST["salario"]) {
                        case 0:
                            $mensagemDeErro = "Você não pode comprar nada com seu salário!";
                            break;
                        case 1000:
                            $mensagemDeErro = "Você pode comprar um celular!";
                            break;
                        default:
                            $mensagemDeErro = "Você pode comprar um carro!";
                            break;
                    }
                    echo $mensagemDeErro;
                    ?>
                </td>
            </tr>
        <?php } ?>
    </table>
</body>