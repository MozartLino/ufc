angular.module('project', []).config(function($routeProvider) {
	$routeProvider.when('/usuarios/novo', {
		controller : usuarioController,
		templateUrl : 'form.html'
	}).otherwise({
		redirectTo : '/'
	});
});