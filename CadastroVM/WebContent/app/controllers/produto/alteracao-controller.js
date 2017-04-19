(function () {
    'use strict';
    angular.module('mwa').controller('MaquinaAlteracaoCtrl', MaquinaAlteracaoCtrl);

    MaquinaAlteracaoCtrl.$inject = ['$rootScope', '$http', '$routeParams', '$location', 'SETTINGS'];

    function MaquinaAlteracaoCtrl($rootScope,$http, $routeParams, $location, SETTINGS) {
        var vm = this;
        var id = $routeParams.id;

        vm.produto = {};

        vm.salvar = salvar;

        activate();

        function activate() {
            listarProduto();
        }

        //Função para listar todos os produtos
        function listarProduto() {
            angular.forEach($rootScope.produtos, function (value, key) {
                if (value.id == id) 
                {
                    vm.produto = value;
                }
            });
        }

        //Função responsável por salvar todos os produtos
        function salvar() {
        	$http.put(
					'http://localhost:8080/CadastroVM/rest/produto/atualizar/' + vm.produto.id,
					vm.produto).then(
					function(response) {
						toastr.success('Produto <strong>' + vm.produto.nome
								+ '</strong> atualizado com sucesso',
								'Produto Atualizado');
						
						$location.path('/produtos');
					}, function(response) {
						toastr.error("Não foi possível atualizar a máquina virtual");
					})
        }
    };
})();