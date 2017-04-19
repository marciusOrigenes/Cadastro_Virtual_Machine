(function () {
    'use strict';
    angular.module('mwa').controller('MaquinaConsultaCtrl', MaquinaConsultaCtrl);

    MaquinaConsultaCtrl.$inject = ['$rootScope', '$http'];

    function MaquinaConsultaCtrl($rootScope, $http) {
        var vm = this;
        vm.produtos = [];

        activate();

        function activate() {
            listarMaquinas();
        }

        function listarMaquinas() {
        	
        	$http.get('http://localhost:8080/CadastroVM/rest/produto/listar')
        	.then(function(response) {
        		vm.produtos = response.data;
        		$rootScope.produtos = vm.produtos;
        	});
        }
    };
})();