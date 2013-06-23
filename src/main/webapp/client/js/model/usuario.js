function usuarioFormController($scope, $window, $http, $routeParams) {

	init = function() {

		var userId = $routeParams.usuarioId;

		if (userId != undefined) {
			var url = "usuarios/" + userId;

			$http.get(url).success(function(data) {
				$scope.usuario = data;
			});
		}
	}();

	$scope.salvaUsuario = function() {
		var url = "usuarios";

		$http({
			method : getMethod($scope.usuario.id),
			url : url,
			data : {
				"usuario" : $scope.usuario
			}
		}).success(function(data) {
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

function usuarioPerfilController($scope, $window, $http) {

	initPerfil = function() {
		$http.get('perfil').success(function(data) {
			$scope.usuario = data;
		});
	}();

}


function usuarioLoginController($scope, $window, $http) {

	$scope.logar = function() {
		console.log("caiu");
		$http.post('logar', {"usuario" : $scope.usuario}).success(function(data) {
			window.location = "http://localhost:8080/ufc/#/perfil"; 
		});
	};

}