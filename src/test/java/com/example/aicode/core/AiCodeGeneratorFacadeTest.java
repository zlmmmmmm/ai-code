package com.example.aicode.core;

import com.example.aicode.core.AiCodeGeneratorFacade;
import com.example.aicode.model.enums.CodeGenTypeEnum;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AiCodeGeneratorFacadeTest {
    @Resource
    private AiCodeGeneratorFacade aiCodeGeneratorFacade;

    @Test
    void generateAndSaveCode() {
    }

    @Test
    void generateAndSaveCodeStream() {
        Flux<String> x = aiCodeGeneratorFacade.generateAndSaveCodeStream("生成一个关与蔡徐坤简介的页面", CodeGenTypeEnum.MULTI_FILE);
        //等待最后输出完成
        List<String> result = x.collectList().block();
        Assertions.assertNotNull(result);
    }
}