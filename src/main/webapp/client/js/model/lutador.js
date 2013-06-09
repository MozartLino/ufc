function lutadorFormController($scope, $window, $http, $routeParams) {

	init = function() {

		var lutadorId = $routeParams.lutadorId;

		if (lutadorId != undefined) {
			var url = "lutadores/" + lutadorId;

			$http.get(url).success(function(data) {
				$scope.lutador = data;
			});
		}
	}();

	$scope.salvaLutador = function() {
		var url = "lutadores";

		$http({
			method : getMethod($scope.lutador.id),
			url : url,
			data : {
				"lutador" : $scope.lutador
			}
		}).success(function(data) {
			console.log("Sucesso");
		});
	};

	function getMethod(value) {
		return value == null ? "post" : "put";
	}
}


