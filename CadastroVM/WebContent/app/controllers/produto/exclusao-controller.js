(function () {
    'use strict';
    angular.module('mwa').controller('MaquinaExclusaoCtrl', MaquinaExclusaoCtrl);

    MaquinaExclusaoCtrl.$inject = ['$rootScope','$http', '$routeParams', '$location', 'SETTINGS'];

    function MaquinaExclusaoCtrl($rootScope,$http, $routeParams, $location, SETTINGS) {
        var vm = this;
        var id = $routeParams.id;

        activate();

        function activate() {
            excluirMaquina();
        }

        function excluirMaquina() {
        	$http['delete']('http://localhost:8080/CadastroVM/rest/produto/deletar/' +id)
        	.then(function(response) {
        		 angular.forEach($rootScope.produtos, function (value, key) {
                     if (value.id == id) {
                    	 $rootScope.produtos.splice(key, 1);
                    	 vm.produtos = $rootScope.produtos;
                     }
                 });
        	});
        	
            $location.path('/produtos');

        }
    };
})();