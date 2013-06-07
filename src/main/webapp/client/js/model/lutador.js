function lutadorFormController($scope, $window, $http, $routeParams) {

	init = function() {
		var url = "lutadores/" + $routeParams.lutadorId;
		$http.get(url).success(function(data) {
			$scope.lutador = data;
		});
	}();

	$scope.salvaPaciente = function() {
		var url = "lutadores";

		$http({
			method : getMethod($scope.lutador.id),
			url : url,
			data : {
				"lutador" : $scope.lutador
			}
		}).success(function(data) {
			$scope.lutadores = data;
			$window.window.location.href = "/#perfil";
		});
	};

	function getMethod(value) {
		return value == null ? "post" : "put";
	}
}