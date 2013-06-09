angular.module('ufc', []).config(function($routeProvider) {
	$routeProvider.when('/usuario/novo', {
		controller : usuarioFormController,
		templateUrl : 'client/html/usuario/form.html'
	}).when('/usuario/edita/:usuarioId', {
		controller : usuarioFormController,
		templateUrl : 'client/html/usuario/form.html'
	}).when('/perfil', {
		controller : usuarioFormController,
		templateUrl : 'client/html/usuario/perfil.html'
	}).when('/ranking', {
		controller : usuarioRankingController,
		templateUrl : 'client/html/usuario/ranking.html'
	}).when('/login', {
		controller : usuarioFormController,
		templateUrl : 'client/html/usuario/login.html'
	})

	// confrontos
	.when('/confronto/abertos', {
		controller : confrontoAbertosController,
		templateUrl : 'client/html/confronto/abertos.html'
	}).when('/confronto/:confrontoId', {
		controller : confrontoController,
		templateUrl : 'client/html/confronto/confronto.html'
	})

	//categoria

	.when('/categoria/novo', {
		controller : categoriaFormController,
		templateUrl : 'client/html/categoria/form.html'
	})
	.when('/categoria/edita/:categoriaId', {
		controller : categoriaFormController,
		templateUrl : 'client/html/categoria/form.html'
	})
	
	//lutador

	.when('/lutador/novo', {
		controller : lutadorFormController,
		templateUrl : 'client/html/lutador/form.html'
	})
	.when('/lutador/edita/:lutadorId', {
		controller : lutadorFormController,
		templateUrl : 'client/html/lutador/form.html'
	})


	.otherwise({
		redirectTo : '/'
	});
});