function categoriaFormController($scope, $window, $http, $routeParams) {

	init = function() {

		var categoriaId = $routeParams.categoriaId;

		if (categoriaId != undefined) {
			var url = "categorias/" + categoriaId;

			$http.get(url).success(function(data) {
				$scope.categoria = data;
			});
		}
	}();

	$scope.salvaCategoria = function() {
		var url = "categorias";

		$http({
			method : getMethod($scope.categoria.id),
			url : url,
			data : {
				"categoria" : $scope.categoria
			}
		}).success(function(data) {
			console.log("Sucesso");
		});
	};

	function getMethod(value) {
		return value == null ? "post" : "put";
	}
}


