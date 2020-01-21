package org.zerock.todo.repo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.todo.domain.Todo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class TodoRepoTests {

    @Autowired
    private TodoRepository todoRepository;

    @Test
    @Commit
    public void addDummies() {

        IntStream.range(1,101).forEach(i -> {
            Todo obj = todoRepository.save(
                    Todo.builder()
                            .title("title......"+ i)
                            .targetDate(LocalDate.parse("2020-01-01", DateTimeFormatter.ISO_DATE))
                            .build());
            log.info(""+obj);
        });
    }

    @Test
    public void selectOne(){
        Todo todo = todoRepository.findById(99).get();
        log.info(""+todo);
    }

    @Test
    public void selectAll(){
        List<Todo> todos = todoRepository.findAll();
        log.info(""+todos);
    }


    @Commit
    @Transactional
    @Test
    public void updateOne() {

        String title ="Updated Title...";
        Integer tno = 99;
        LocalDate targetDate = LocalDate.parse("2019-12-31", DateTimeFormatter.ISO_DATE);

        int count = todoRepository.updateTargetDate(targetDate, title, tno);

        log.info("COUNT: " + count);
    }


}
