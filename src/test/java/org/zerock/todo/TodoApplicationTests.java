package org.zerock.todo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.todo.repo.TodoRepository;

@SpringBootTest
@Slf4j
class TodoApplicationTests {



    @Test
    void contextLoads() {

        log.info("contextLoads.................");
    }

}
