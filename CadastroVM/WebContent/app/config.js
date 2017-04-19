﻿(function () {
    'use strict';

    angular.module('mwa').constant('SETTINGS', {
        "PRODUTOS": "produtos"
    });

    angular.module('mwa').run(function ($rootScope, SETTINGS) {
        var produtos = localStorage.getItem(SETTINGS.PRODUTOS);

        $rootScope.produtos = [];
        
        if (produtos) {
            var items = angular.fromJson(produtos);
            angular.forEach(items, function (value) {
                $rootScope.produtos.push(value);
            });
        }

    });

})();