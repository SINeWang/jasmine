waveApp.controller('systemController', function ($scope) {
    $scope.$on('modules', function (d, modules) {
        modules.forEach(function (module) {
            if (module.moduleId = 'system') {
                $scope.actions = module.actions;
                return;
            }
        })
    });
});


