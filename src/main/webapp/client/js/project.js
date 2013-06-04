angular.module('project', []).config(function($routeProvider) {
	$routeProvider.when('/usuarios/novo', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/form.html'
	}).when('/usuarios/edita/:usuarioId', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/form.html'
	}).when('/perfil', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/ranking.html'
	}).when('/ranking', {
		controller : usuarioForm,
		templateUrl : 'client/html/usuario/perfil.html'
	}).otherwise({
		redirectTo : '/'
	});
});