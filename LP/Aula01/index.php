<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <title>Aula 01 - PHP</title>
        <link rel="stylesheet" href="style.css">
    </head>
    <body>
    <h1>Exemplo de PHP</h1>
    <p>
        <?php
            echo "Olá, Mundo!" . "<br>";
            echo "Hoje é " . date("d/m/Y") . "<br>";
        ?>
    </p>
    <p>
        <?php
            $nome = "Kevin";
            echo "Seu nome é " . $nome . "<br>";
        ?>
    </p>  
    <p>
        <?php
            $n1 = 5;
            $n2 = 6;
            if ($n1 > $n2) {
                echo "O maior é: ".$n1;
            } else {
                echo "O maior é: ".$n2;
            }

        ?>
    </p>  
        <script src="" async defer></script>
    </body>
</html>