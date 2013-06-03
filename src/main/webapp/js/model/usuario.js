function usuarioController($scope, $window, $http) {

	$scope.salvaPaciente = function() {
		var url = "/ufc/usuarios";

		$http.post(url, {
			"usuario" : $scope.usuario
		}).success(function(data) {
			$scope.usuarios = data;
			$window.window.location.href = "http://localhost:8080/ufc/perfil";
		});
	};
}

function usuarioRankingController($scope, $window, $http) {

	lista = function() {
		$http.get('http://localhost:8080/ufc/ranking').success(function(data) {
			$scope.usuarios = data;
		});
	}();

}