function usuarioFormController($scope, $window, $http, $routeParams) {

	init = function() {
		var url = "usuarios/" + $routeParams.usuarioId;
		$http.get(url).success(function(data) {
			$scope.usuario = data;
		});

	}();

	$scope.salvaPaciente = function() {
		var url = "usuarios";

		$http({
			method : getMethod($scope.usuario.id),
			url : url,
			data : {
				"usuario" : $scope.usuario
			}
		}).success(function(data) {
			$scope.usuarios = data;
			$window.window.location.href = "/#perfil";
		});
	};
	
	function getMethod(value) {
		return value == null ? "post" : "put";
	}
}

function usuarioRankingController($scope, $window, $http) {

	lista = function() {
		$http.get('ranking').success(function(data) {
			$scope.usuarios = data;
		});
	}();

}