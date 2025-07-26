<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aula02</title>
</head>
<body>
<?php
//comentarios em PHP
# comentarios em PHP
/* comentarios em PHP
   mais de uma linha */

#criação de variaveis
$nome = "Kevin";
$idade = 34;
$cpf = "000.000.000-00";

echo "Seu nome é ".$nome . "<br>";
echo "Sua idade é ".$idade . "<br>";
echo "Seu CPF é ".$cpf . "<br>";
echo "<br>";

#extruturas de controle
if ($idade >= 33) {
    echo "Sua idade é maior que 33. Voce é velho."."<br>";}
else if ($idade <= 33) {
        echo "Sua idade é nenor que 33. Voce ainda não é velho."."<br>";
} else {
    echo "Voce é quase velho! <br>";
}
echo "<hr><br>";

#extrutura de repetição
for ($i = 0; $i <= 25; $i++) {
    echo "Voce tem ".$i." anos <br>";
}
echo "<br>";
?>
</body>
</html>