function confrontoFormController($scope, $window, $http) {

	init = function() {
		var confrontoId = $routeParams.confrontoId;

		if (confrontoId != undefined) {
			var url = "confronto/" + confrontoId;

			$http.get(url).success(function(data) {
				$scope.confronto = data;
			});
		}
	}();

	$scope.salvaConfronto = function() {
		var url = "confrontos";

		$http({
			method : getMethod($scope.confronto.id),
			url : url,
			data : {
				"confronto" : $scope.confronto
			}
		}).success(function() {
			$window.window.location.href = "/#abertos";
		});
	};

	function getMethod(value) {
		return value == null ? "post" : "put";
	}
}

function confrontoAbertosController($scope, $window, $http) {
	lista = function() {
		$http.get('confrontos/abertos').success(function(data) {
			$scope.confrontos = data;
		});
	}();
}

function confrontoController($scope, $window, $http, $routeParams) {
	buscaLutadores = function() {
		var url = "confrontos/" + $routeParams.confrontoId;
		$http.get(url).success(function(data) {
			$scope.confronto = data;
		});
	}();
}