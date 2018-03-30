'use strict';	
	
var tasks = [

];	

app.service('taskProvider',function(){

		this.getTasks = function(){
			return tasks;
		}
		
		this.addTask = function(task){	
			tasks.push(task);
		}
		
		this.removeTask = function(index){
			tasks.splice(index,1);
		}
		
		this.updateItem = function(item){
			items.$save(item);
		}
});



