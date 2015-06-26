waveApp.controller('dashboardController', function ($scope) {
    loadUser($scope);

    $scope.active_nav = function (module) {
        active_nav(module);
    }
});


