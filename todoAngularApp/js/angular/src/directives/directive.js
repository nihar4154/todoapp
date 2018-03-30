'use strict';

app.directive('taskDecorate',function(){
	return{
		restrict	:	'E',
		replace		:	true,
		templateUrl :	'views/todo/decorator/taskHTML.html' 
	}
});
