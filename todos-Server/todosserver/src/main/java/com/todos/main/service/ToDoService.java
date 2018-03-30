package com.todos.main.service;

import com.todos.main.dao.jpa.ToDoRepository;
import com.todos.main.domain.ToDo;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/*
 * Service class
 */
@Service
public class ToDoService {

    private static final Logger log = LoggerFactory.getLogger(ToDoService.class);

    @Autowired
    private ToDoRepository toDoRepository;

    @Autowired
    CounterService counterService;

    @Autowired
    GaugeService gaugeService;

    public ToDoService() {
    }

    public ToDo createToDo(ToDo todo) {
        return toDoRepository.save(todo);
    }

    public ToDo getToDo(long id) {
        return toDoRepository.findOne(id);
    }

    public void updateToDo(ToDo todo) {
    	toDoRepository.save(todo);
    }

    public void deleteToDo(Long id) {
    	toDoRepository.delete(id);
    }

    public List<ToDo> getAllToDos(Integer page, Integer size) {
        Page pageOfToDos = toDoRepository.findAll(new PageRequest(page, size));
        return pageOfToDos.getContent();
    }
}
