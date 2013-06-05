angular.module('project', []).config(function($routeProvider) {
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
	}).otherwise({
		redirectTo : '/'
	});
});