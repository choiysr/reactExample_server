package org.zerock.todo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.zerock.todo.domain.Todo;

import java.util.List;

public interface TodoService {

    public Todo add(Todo todo);

    public Todo get(Integer tno);

    public int modify(Todo todo);

    public void remove(Integer tno);

    public Page<Todo> list(Pageable pageable);

}
