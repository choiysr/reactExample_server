package org.zerock.todo.service;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import org.zerock.todo.domain.DegreeVO;

@Service
@Slf4j
public class WeatherServiceImpl implements org.zerock.todov.service.WeatherService {
    @Override
    public DegreeVO getWeather(String code) throws Exception{

        Document doc = Jsoup.connect("https://m.weather.naver.com/m/main.nhn?regionCode=09110127").get();

        //log.info("" + doc.title());

        Elements ele = doc.select(".card_now");

        //log.info(ele.html());

        Elements degrees = ele.get(0).select(".degree_code");

        degrees.forEach( deg -> {
            log.info("" + deg);
        });

        DegreeVO vo = new DegreeVO();

        vo.setCurrent(Integer.parseInt(degrees.get(0).text()));
        vo.setMin(Integer.parseInt(degrees.get(1).text()));
        vo.setMax(Integer.parseInt(degrees.get(2).text()));
        vo.setWindchill(Integer.parseInt(degrees.get(3).text()));

        Elements textEle = ele.get(0).select(".weather_set_summary");

        log.info(textEle.text());

        vo.setDesc(textEle.text());

        log.info("" + vo);

        return vo;
    }
}