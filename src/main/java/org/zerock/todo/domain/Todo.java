package org.zerock.todo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
public class Todo {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer tno;

    private String title;

    private LocalDate targetDate;

    @CreationTimestamp
    private LocalDateTime regdate;
}
