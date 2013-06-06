angular.module('ufc', []).config(function($routeProvider) {
	$routeProvider.when('/usuario/novo', {
			controller : usuarioFormController,
			templateUrl : 'client/html/usuario/form.html'
		}
	).when('/usuario/edita/:usuarioId', {
			controller : usuarioFormController,
			templateUrl : 'client/html/usuario/form.html'
		}
	).when('/perfil', {
			controller : usuarioFormController,
			templateUrl : 'client/html/usuario/perfil.html'
		}
	).when('/ranking', {
			controller : usuarioRankingController,
			templateUrl : 'client/html/usuario/ranking.html'
		}
	).when('/login', {
			controller : usuarioFormController,
			templateUrl : 'client/html/usuario/login.html'
		}
	)
	
	.when('/lutador/novo', {
			controller : lutadorFormController,
			templateUrl : 'client/html/lutador/form.html'
		}
	).when('/lutador/edita/:lutadorId', {
			controller : lutadorFormController,
			templateUrl : 'client/html/lutador/form.html'
		}
	).when('/perfil/:lutadorId', {
		controller : usuarioFormController,
		templateUrl : 'client/html/usuario/perfil.html'
	}).when('/ranking', {
		controller : usuarioRankingController,
		templateUrl : 'client/html/usuario/ranking.html'
	}).when('/login', {
		controller : usuarioFormController,
		templateUrl : 'client/html/usuario/login.html'
	}).otherwise({
		redirectTo : '/'
	});
});