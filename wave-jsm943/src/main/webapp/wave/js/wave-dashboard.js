waveApp.controller('mainController', function ($scope) {
    loadUser($scope);

    $scope.active_nav = function (module) {
        active_nav(module);
        build_menu(module, $scope);
    }

});


