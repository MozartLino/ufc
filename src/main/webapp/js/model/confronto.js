function confrontosController($scope, $window, $http) {

	lista = function() {
		var confrontos = [];
		
		$http.get('/makeyourbad_2.0/confrontos/abertos').success(function(data) {
			$.each(data, function(){
				confrontos.push(this);
			});
			$scope.confrontos = confrontos;
		});
		
	}();
	
	$scope.remover = function(confronto) {
		
		var url = "/makeyourbad_2.0/confrontos/" + confronto.id;
		
		if(confirm("Deseja realmente exluir o confronto ?")) {
			$http.delete(url).success(function(data) {
				var index = $scope.confrontos.indexOf(confronto);
				$scope.confrontos.splice(index, 1);
				$("#success").html("Excluido com sucesso");
				$("#message-red").hide();
				$("#message-green").show();
			}).error(function(){
				$("#error").html("Nao foi possivel remover o confronto.");
				$("#message-red").show();
				$("#message-green").hide();
			});
		}
	};

	$scope.buscaPacientesComAtividadePeloDiaCadastrado = function() {
		var url = "/r24af/confrontos/representation/dia/" + $scope.dia;
		$http.get(url).success(function(data) {
			var confrontos = [];
			$.each(data, function(){
				confrontos.push($window.trataCasasDecimais(this));
			});
			$scope.confrontos = confrontos;
		});
	};

}

function formPacientesController($scope, $window, $http) {

	init = function() {
		var urlArray = $window.window.location.pathname.split("/");
		var extractUrl = urlArray[urlArray.length -1];
		if(!(extractUrl == "confronto")){
			$http.get('/r24af/confrontos/'+ extractUrl +"/representation").success(function(data) {
				$scope.confronto = data;
			});
		}
	}();

	$scope.salvaPaciente = function() {
		
		if (validaObjeto()) {
			var confronto = angular.toJson({confronto : $scope.confronto});
			var url = "/r24af/confrontos";
			if($scope.confronto.id == undefined){
				$http.post(url, confronto).success(function(data) {
					$scope.confrontos = data;
					$window.window.location.href = "http://localhost:8080/r24af/confrontos";
				});
			} else {
				$http.put(url, confronto).success(function(data) {
					$window.window.location.href = "http://localhost:8080/r24af/confrontos";
				});
			}
		}
	};
	
}