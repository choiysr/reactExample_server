package org.zerock.todov.service;

import org.zerock.todo.domain.DegreeVO;

public interface WeatherService {

    public DegreeVO getWeather(String code)throws Exception;
}