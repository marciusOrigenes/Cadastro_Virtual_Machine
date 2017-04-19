(function () {
    'use strict';

    angular.module('mwa').config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                controller: 'HomeCtrl',
                controllerAs: 'vm',
                templateUrl: 'public/paginas/home/home.html'
            })
            .when('/produtos', {
                controller: 'MaquinaConsultaCtrl',
                controllerAs: 'vm',
                templateUrl: 'public/paginas/produto/consulta.html'
            })
            .when('/produtos/inclusao', {
                controller: 'MaquinaInclusaoCtrl',
                controllerAs: 'vm',
                templateUrl: 'public/paginas/produto/inclusao.html'
            })
            .when('/produtos/alteracao/:id', {
                controller: 'MaquinaAlteracaoCtrl',
                controllerAs: 'vm',
                templateUrl: 'public/paginas/produto/alteracao.html'
            })
            .when('/produtos/exclusao/:id', {
                controller: 'MaquinaExclusaoCtrl',
                controllerAs: 'vm',
                templateUrl: 'public/paginas/produto/alteracao.html'
            });
    });
})();