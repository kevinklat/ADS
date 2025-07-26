<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="styles.css">
    <title>Lista de hábitos</title>
</head>

<body>
    <div class="center">
        <h1>Novo Hábito</h1>
        <!-- 
        Formulário para cadastro de pessoas
        Note a utilização do atributo name, que faz o link entre os elementos do DOM e o JavaScript
        -->
        <form id="formulario" action="inserthabito.php">
            <p><label>Nome: <input type="text" id="nome" name="nome" autofocus required /></label></p>
            <p><input type="submit" value="Criar"></p>
        </form>
    </div>
    
</body>

</html>