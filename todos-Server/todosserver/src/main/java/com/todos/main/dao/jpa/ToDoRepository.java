package com.todos.main.dao.jpa;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.todos.main.domain.ToDo;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */
public interface ToDoRepository extends PagingAndSortingRepository<ToDo, Long> {
    /*ToDo findHotelByCity(String city);
    Page findAll(Pageable pageable);*/
}
