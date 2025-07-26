// Aqui declaramos o módulo, que é ligado
// ao HTML através da diretiva ng-app
var app = angular.module("app", ["ngRoute"]);
// Declaramos um value dentro do módulo
// Em AngularJs values são valores que podem
// ser utilizados em diversas páginas.
app.value("habitos", { habitos: [] });
// Declaramos o controller para a página
// na qual o usuário acessa sua lista de hábitos
// Em AngularJS, os controllers são ligados ao código
// HTML através da diretiva ng-controller
// Mas no nosso caso, estamos utilizando a
// biblioteca angular-route na qual o controller
// é associado ao HTML no método config
// quando configuramos as rotas de navegação
app.controller("listadehabitos", ["$scope", "$http", "habitos", function ($scope, $http, habitos) {
    $scope.habitos = habitos.habitos;
    // Caso o array esteja vazio, busca
    // os valores da API
    if (habitos.habitos.length == 0) {
        $http.get('habito.php').success(function (data) {
            for (indice in data) {
                habitos.habitos[indice] =
                    data[indice];
            }
        });
    }
    $scope.mostraLista = $scope.habitos.length == 0;
    // Atualiza o status de um hábito para V
    $scope.vencerHabito = function (habito) {
        indice = $scope.habitos.indexOf(habito);
        habito.status = "V";
        $http.put('habito.php', habito).success(function (data) {
            $scope.habitos[indice] = data;
        });
    }
    // Atualiza o status de um hábito para A
    $scope.retomarHabito = function (habito) {
        indice = $scope.habitos.indexOf(habito);
        habito.status = "A";
        $http.put('hhabito.php', habito).
            success(function (data) {
                $scope.habitos[indice] = data;
            });
    }
    // Exclui um hábito
    $scope.desistirHabito = function (habito) {
        $http.delete('habito.php', {
            params: {
                id: habito.id
            }
        }).success(function (data) {
            indice = $scope.habitos.
                indexOf(habito);
            $scope.habitos.splice(indice, 1);
        });
    }
}]);
// Controller para a página na qual o usuário
// efetua a inclusão de hábitos
app.controller("novohabito", ["$scope", "$http",
    "habitos", function ($scope, $http, habitos) {
        $scope.habitos = habitos.habitos;
        $scope.nome = "";
        // Insere um novo hábito
        $scope.inserirHabito = function (nome) {
            if (nome == "")
                return;
            $http.post('habito.php', {
                nome: nome
            }).success(function (data) {
                $scope.habitos[$scope.habitos.length]
                    = data
                $scope.nome = "";
            });
        }
    }]);
// Configura as rotas de navegação
// da aplicação Web
app.config(["$routeProvider", function ($routeProvider) {
    $routeProvider.when("/listadehabitos", {
        controller: "listadehabitos",
        templateUrl: "partials/listadehabitos.html"
    }).when("/novohabito", {
        controller: "novohabito",
        templateUrl: "partials/novohabito.html"
    }).otherwise({
        controller: "listadehabitos",
        templateUrl: "partials/listadehabitos.html"
    });
}]);
