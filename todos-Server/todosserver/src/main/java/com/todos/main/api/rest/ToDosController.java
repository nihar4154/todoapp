package com.todos.main.api.rest;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todos.main.domain.ToDo;
import com.todos.main.service.ToDoService;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * RESTful API end points using Spring MVC
 */

@RestController
@RequestMapping(value = "/todos/v1/getlist")
public class ToDosController {

    @Autowired
    private ToDoService toDoService;

    
   @RequestMapping(value = "",
            method = RequestMethod.POST,
            consumes = {"application/json"}
           )
   @CrossOrigin(origins = "/*")
    @ResponseStatus(HttpStatus.CREATED)
    public void createHotel(@RequestBody ToDo toDo,
                                 HttpServletRequest request, HttpServletResponse response) {
       this.toDoService.createToDo(toDo);
    }
   
   
   
   

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<ToDo> getAllToDos(HttpServletRequest request, HttpServletResponse response) {
        return (List<ToDo>) this.toDoService.getAllToDos(0, 100);
    }

    
    
    
    
    @RequestMapping(value = "/{id}",
            method = RequestMethod.PUT,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateToDo(@PathVariable("id") Long id, @RequestBody ToDo toDo,
                                 HttpServletRequest request, HttpServletResponse response) {
        this.toDoService.updateToDo(toDo);
    }
    
    
    
    
    @RequestMapping(value = "/{id}",
            method = RequestMethod.DELETE,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteToDo(@PathVariable("id") Long id, HttpServletRequest request,
                                 HttpServletResponse response) {
        this.toDoService.deleteToDo(id);;
    }
}
