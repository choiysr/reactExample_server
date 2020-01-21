package org.zerock.todo.domain;

import lombok.Data;

@Data
public class DegreeVO {

    private int windchill, current, max, min;

    private String desc;

}