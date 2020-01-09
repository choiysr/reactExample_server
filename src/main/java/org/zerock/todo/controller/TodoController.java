package org.zerock.todo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zerock.todo.domain.Todo;
import org.zerock.todo.service.TodoService;


@RestController
@RequestMapping("/todos")
@Slf4j
@AllArgsConstructor
@CrossOrigin
public class TodoController {


    private TodoService todoService;


    @GetMapping("/list")
    public Page<Todo> getList(
            @PageableDefault(sort = "tno", direction = Sort.Direction.DESC)
                    Pageable pageable){

        log.info("" + pageable);

        return todoService.list(pageable);
    }

    @DeleteMapping("/{tno}")
    public ResponseEntity<String> remove(@PathVariable("tno") Integer tno) {

        log.info("remove................." + tno);

        todoService.remove(tno);

        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);

    }

    @PostMapping("/")
    public ResponseEntity<Todo> register(@RequestBody Todo todo){

        log.info("todo: " + todo);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(todoService.add(todo), HttpStatus.OK);

    }

}
