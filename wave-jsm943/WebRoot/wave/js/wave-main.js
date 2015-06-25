function loadUser() {
    beforeAction("Loading...");
    $.ajax({
        type: 'GET',
        url: '/user',
        success: function (data) {
            var ret = eval(data);
            if (ret.c == 0) {
                var v = ret.d + "@sinewang.com";
                $("#navbar-brand").html(v);
            } else {
                alert(ret.m);
            }
        },
        error: function (data) {
            window.location.href = '/signin';
        },
        complete: function (data) {
            afterAction();
        },
        dataType: 'json'
    });
}

var waveApp = angular.module('waveApp', ['ngRoute']);

// configure our routes
waveApp.config(function ($routeProvider, $locationProvider) {
    $routeProvider
        .when('/', {
            templateUrl: 'pages/main.html',
            controller: 'mainController'
        })
        .when('/order', {
            templateUrl: 'pages/order.html',
            controller: 'mainController'
        });
    $locationProvider.html5Mode(false);
});


waveApp.controller('mainController', function ($scope) {

    $scope.message = 'Everyone come and see how good I look!';
});