// Declaramos o módulo, que é ligado à página Web através da diretiva ng-app 
// ngRoute na linha abaixo é uma injeção de dependência, é um módulo que está contido do arquivo angular-route.js
var app = angular.module("app", ["ngRoute"]);

// Declaramos o controller para a página api-test-get.html
app.controller("apitestgetcontroller", ["$scope", "$http", function ($scope, $http) {
    $scope.result = "";
    $scope.id = "";
    $scope.listaDeHabitosApiGet = function () {
        if ($scope.id == "") {
            console.log("ID nulo", $scope.id);
            $http.get("http://localhost/LP/ExercicioLivroUnidade3/topico01/listadehabitos-rest-api/habito.php")
                .then(function (response) {
                    console.log("Response: ", response.data);
                    var output = JSON.stringify(response.data);
                    $scope.result = output;
                }).catch(function (error) {
                console.error("Erro na requisição:", error);
            });
        } else {
            console.log("ID enviado:", $scope.id);
            $http.get("http://localhost/LP/ExercicioLivroUnidade3/topico01/listadehabitos-rest-api/habito.php", {
                params: { id: $scope.id }
            }).then(function (response) {
                console.log("Response: ", response.data);
                var output = JSON.stringify(response.data);
                $scope.result = output;
            }).catch(function (error) {
                console.error("Erro na requisição:", error);
            });
        }
    }

}]);

// Declaramos o controller para a página api-test-post.html
app.controller("apitestpostcontroller", ["$scope",
    "$http", function ($scope, $http) {
        $scope.result = "";
        $scope.nome = "";
        // Criar
        $scope.listaDeHabitosApiPost = function () {
            console.log("Nome enviado:", $scope.nome);
            $http.post("http://localhost/LP/ExercicioLivroUnidade3/topico01/listadehabitos-rest-api/habito.php", {
                nome: $scope.nome
            }).then(function (response) {
                console.log("Response: ", response.data);
                var output = JSON.stringify(response.data);
                $scope.result = output;
            }).catch(function (error) {
                console.error("Erro na requisição:", error);
            });
        };
    }]);

// Declaramos o controller para a página api-test-put.html
app.controller("apitestputcontroller", ["$scope",
    "$http", function ($scope, $http) {
        $scope.result = "";
        $scope.id = "";
        $scope.nome = "";
        $scope.status = "";
        // Atualizar
        $scope.listaDeHabitosApiPut = (function () {
            console.log("ID: ", $scope.id,", Nome: ",$scope.nome,", Status: ",$scope.status);
            $http.put("http://localhost/LP/ExercicioLivroUnidade3/topico01/listadehabitos-rest-api/habito.php", {
                id: $scope.id,
                nome: $scope.nome,
                status: $scope.status
            }).then(function (response) {
                console.log("Resposta da API:", response.data);
                var output = JSON.stringify(response.data);
                $scope.result = output;
            }).catch(function (error) {
                console.error("Erro na requisição:", error);
            });
        });
    }]);

// Declaramos o controller para a página api-test-get.html
app.controller("apitestdeletecontroller", ["$scope",
    "$http", function ($scope, $http) {
        $scope.result = "";
        $scope.id = "";
        // Deletar
        $scope.listaDeHabitosApiDel = (function () {
            console.log("ID: ", $scope.id);
            $http.delete("http://localhost/LP/ExercicioLivroUnidade3/topico01/listadehabitos-rest-api/habito.php", {
                params: { id: $scope.id }
            }).then(function (response) {
                console.log("Resposta da API:", response.data);
                var output = JSON.stringify(response.data);
                $scope.result = output;
            }).catch(function (error) {
                console.error("Erro na requisição:", error);
            });
        });
    }]);

// Declaramos o controller para a página
// welcome.html
app.controller("welcomecontroller", ["$scope",
    function ($scope) {
    }]);

// Aqui definimos a dinâmica de navegação da
// página. Para cada URL que a página possui
// define-se qual controller será usado
// e qual arquivo .html será exibido
app.config(function ($routeProvider) {
    $routeProvider.when("/api-test-get", {
        controller: "apitestgetcontroller",
        templateUrl: "arq/api-test-get.html"
    }).when("/api-test-post", {
        controller: "apitestpostcontroller",
        templateUrl: "arq/api-test-post.html"
    }).when("/api-test-put", {
        controller: "apitestputcontroller",
        templateUrl: "arq/api-test-put.html"
    }).when("/api-test-delete", {
        controller: "apitestdeletecontroller",
        templateUrl: "arq/api-test-delete.html"
    }).otherwise({
        controller: "welcomecontroller",
        templateUrl: "arq/welcome.html"
    });
});