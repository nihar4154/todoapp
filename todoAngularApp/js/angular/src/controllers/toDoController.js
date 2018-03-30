'use strict';

app.controller("toDoController",function($scope,$http,$routeParams,taskProvider){

	/*
	 * Display all tasks | toDo | complete tasks
	 */
	if(angular.isUndefined($routeParams.status))
		$scope.status = "";
	else
		$scope.status = ($routeParams.status=="complete")?true:false;
	
	
	$scope.tasks = taskProvider.getTasks();

  /*  $scope.tasks = function(){
    	$http
                    .get('http://localhost:8090/todos/v1/getlist')
                    .then(function(response) {
                		return response.body;
            });
    };*/

    

	/*
	 * Add a task
	 */
	$scope.addTask = function(task){
		var taskToAdd = {
			id 		: 	$scope.tasks.length + 1,
			content	:	task.content,
			isDone	: 	false
		};
		
		if($scope.task.content.length >=1){

			$http
                    .post('http://localhost:8090/todos/v1/getlist', JSON.stringify(taskToAdd))
                    .success(function(data, status, headers, config) {
                        console.log('success');
                        taskProvider.addTask(taskToAdd);
                        
                    }).error(function(data, status, headers, config) {
            });

			
			
			$scope.task.content = "";
		}
	}
	
	/*
	 * Change status task
	 */
	 $scope.updateStatusTask = function(task){

	    task.isDone = !task.isDone;
		var url = 'http://localhost:8090/todos/v1/getlist/'+task.id;
		$http
                    .put(url, JSON.stringify(task))
                    .success(function() {
                        console.log('success');
                        task.isDone = !task.isDone;
                        
                    }).error(function(data, status, headers, config) {

            });
                    
	 }
	 
	/*
	 * Remove task
	 */
	 $scope.deleteTask = function(task,index){
		//taskProvider.removeTask(index);
		var url = 'http://localhost:8090/todos/v1/getlist/'+task.id;
		$http
                    .delete(url, JSON.stringify(task))
                    .then(function(response) {
                		taskProvider.removeTask(index);
            });
	 }
	 


});

