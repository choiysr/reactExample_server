package org.zerock.todo.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.todo.domain.DegreeVO;

@RestController
@AllArgsConstructor
@Slf4j
@CrossOrigin
public class WeatherController {


    private org.zerock.todov.service.WeatherService weatherService;

    @RequestMapping("/weather")
    public ResponseEntity<DegreeVO> getNow(@RequestParam("code") String code )throws Exception{

        return new ResponseEntity<>(weatherService.getWeather(code), HttpStatus.OK);

    }
}