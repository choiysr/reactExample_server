package org.zerock.todo.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.zerock.todo.domain.Todo;
import org.zerock.todo.repo.TodoRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;

    @Override
    public Todo add(Todo todo) {
        return todoRepository.save(todo);
    }

    @Override
    public Todo get(Integer tno) {
        return todoRepository.getOne(tno);
    }

    @Override
    public int modify(Todo todo) {
        return 0;
    }

    @Override
    public void remove(Integer tno) {
        todoRepository.delete(Todo.builder().tno(tno).build());
    }

    @Override
    public Page<Todo> list(Pageable pageable) {
        return todoRepository.findAll(pageable) ;
    }
}
