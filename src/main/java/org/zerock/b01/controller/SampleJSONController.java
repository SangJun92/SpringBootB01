package org.zerock.b01.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleJSONController {
    @Tag(name = "샘플로 테스트2", description = "점심 메뉴 작성")
    @GetMapping("/lunchMenu")
    public String[] lunchMenu(){
        log.info("lunchMenu.....................");
        // 화면을 찾는것이 아니라 JSON 데이터를 반환
        return new String[]{"돼지국밥","햄버거","피자"};
    }
}
