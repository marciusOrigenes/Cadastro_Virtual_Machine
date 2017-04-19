(function() {
	'use strict';
	angular.module('mwa')
			.controller('MaquinaInclusaoCtrl', MaquinaInclusaoCtrl);

	MaquinaInclusaoCtrl.$inject = [ '$rootScope', '$http', '$location', 'SETTINGS' ];

	function MaquinaInclusaoCtrl($rootScope, $http, $location, SETTINGS) {
		var vm = this;
		var proximoId = 1;

		if ($rootScope.produtos.length > 0) {
			proximoId = $rootScope.produtos[$rootScope.produtos.length - 1].id + 1;
		}

		vm.produto = {
//			id : proximoId,
			nome : '',
			memoria : 0,
			sistemaOperacional : '',
			quantidade : 0
		};
		vm.salvar = salvar;

		activate();

		function activate() {

		}

		function salvar() {
			$http.post(
					'http://localhost:8080/CadastroVM/rest/produto/novo',
					vm.produto).then(
					function(response) {
						toastr.success('Produto <strong>' + vm.produto.nome
								+ '</strong> cadastrado com sucesso',
								'Produto Cadastrado');
						$rootScope.produtos.push(vm.produto);
						
						$location.path('/produtos');
					}, function(response) {
						toastr.error("Não foi possível criar a máquina virtual");
					})
		}
	}
	;
})();