function usuarioController($scope, $window, $http) {

	init = function() {
		var urlArray = $window.window.location.pathname.split("/");
		var extractUrlId = urlArray[urlArray.length - 1];

		if (!(extractUrlId == "usuario")) {
			$http.get('/makeyourbad_2.0/usuario/' + extractUrlId).success(
					function(data) {
						$scope.usuario = data;
					});
		}

	}();

	$scope.salvaPaciente = function() {

		var url = "/makeyourbad_2.0/usuarios";
		
		$http.post(url, {"usuario" : $scope.usuario}).success(function(data) {
			$scope.usuarios = data;
			$window.window.location.href = "/makeyourbad_2.0/js/model/perfil.jsp";
		});
	};
}

function usuarioRankingController($scope, $window, $http) {

	lista = function() {
		$http.get('/makeyourbad_2.0/ranking').success(function(data) {
			$scope.usuarios = data;
		});
	}();

}