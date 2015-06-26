function loadUser($scope) {
    $.ajax({
        type: 'GET',
        url: '/user',
        success: function (data) {
            var ret = eval(data);
            if (ret.c == 0) {
                $scope.userId = ret.d.userId;
                $scope.modules = ret.d.modules;
            } else {
                alert(ret.m);
            }
        },
        error: function (data) {
            window.location.href = '/signin';
        },
        complete: function (data) {
        },
        dataType: 'json'
    });
}

function active_nav(module) {
    if (module == null || module == '') {
        module = window.location.href.split("#")[1];
        if (module.contains("/")) {
            module = module.split("/")[1];
        }
    }
    $('#nav-li > li').each(function (i, l) {
        var li = $(l);
        if (li.attr('id').indexOf(module) > 0) {
            li.removeClass().addClass("active");
        } else {
            li.removeAttr('class');
        }
    })
}


var waveApp = angular.module('waveApp', ['ngRoute']);

// configure our routes
waveApp.config(function ($routeProvider) {
    $routeProvider
        .when('/dashboard', {
            templateUrl: 'pages/dashboard.html',
            controller: 'dashboardController'
        })
        .when('/config', {
            templateUrl: 'pages/config.html',
            controller: 'configController'
        });
});