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
		}).success(function(data) {
			$scope.confrontos = data;
			$window.window.location.href = "/#abertos";
		});
	};

	function getMethod(value) {
		return value == null ? "post" : "put";
	}

}

lista = function() {
	var confrontos = [];

	$http.get('confrontos/abertos').success(function(data) {
		$.each(data, function() {
			confrontos.push(this);
		});
		$scope.confrontos = confrontos;
	});

}();