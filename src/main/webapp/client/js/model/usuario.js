function usuarioForm($scope, $window, $http) {

	$scope.salvaPaciente = function() {
		var url = "/#usuarios";

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
}

function getMethod(value) {
	return value == null ? "post" : "put";
}

function usuarioRankingController($scope, $window, $http) {

	lista = function() {
		$http.get('http://localhost:8080/ufc/ranking').success(function(data) {
			$scope.usuarios = data;
		});
	}();

}