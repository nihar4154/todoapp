'use strict';

app.config(function($routeProvider){
	
	$routeProvider
		.when('/',{
			controller:'toDoController',
			templateUrl:'views/todo/list.html'
		})
		.when('/tasks/:status',{
			controller:'toDoController',
			templateUrl:'views/todo/list.html'
		})
		.otherwise({
			redirectTo :'/'
		});
	
});
