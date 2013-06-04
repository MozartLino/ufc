angular.module('project', []).config(function($routeProvider) {
	$routeProvider.when('/usuario/novo', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/form.html'
	}).when('/usuario/edita/:usuarioId', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/form.html'
	}).when('/perfil', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/perfil.html'
	}).when('/ranking', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/ranking.html'
	}).when('/login', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/login.html'
	}).otherwise({
		redirectTo : '/'
	});
});