function usuarioController($scope, $window, $http) {

	init = function() {
		var urlArray = $window.window.location.pathname.split("/");
		var extractUrlId = urlArray[urlArray.length - 1];

		if (!(extractUrlId == "usuario")) {
			$http.get('http://localhost:8080/ufc/usuario' + extractUrlId)
					.success(function(data) {
						$scope.usuario = data;
					});
		}

	}();

	$scope.salvaPaciente = function() {
		var url = "/ufc/usuarios";

		$http.post(url, { "usuario" : $scope.usuario }).success(function(data) {
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