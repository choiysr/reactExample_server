package org.zerock.todo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.zerock.todo.domain.Todo;

import java.time.LocalDate;

public interface TodoRepository  extends JpaRepository<Todo, Integer> {


    @Modifying
    @Query("update Todo t set t.targetDate = :targetDate, t.title = :title where t.tno = :tno")
    public int updateTargetDate(LocalDate targetDate, String title, Integer tno);
}
