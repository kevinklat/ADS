var helloWorldApp = angular.module("helloworld", []);
helloWorldApp.controller("helloworldcontroller",
    ["$scope", function ($scope) {
        $scope.msg = "Hello World!";
    }]);