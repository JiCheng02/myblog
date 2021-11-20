package com.xxxxx.myblog;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(classes = {MyblogApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    //Spring提供的测试环境下访问Rest服务的客户端
    @Autowired
    TestRestTemplate restTemplate;

    @BeforeAll
    void setup() {
        System.out.println(">>  Setup");
    }

    @Test
    void assertBlogPageTitle_Content_And_StatusCode() {

        //访问/路径，以String类型解析响应的主体entity
        ResponseEntity<String> entity = restTemplate.getForEntity("/",String.class);

        //判断响应码为HttpStatus.OK，即200
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

        assertThat((entity.getBody()).contains("<h1>Hello World!</h1>"));
    }

    @Test
    void assertArticlePageTitle_Content_And_StatusCode() {
        System.out.println(">> TODO");
    }

    @AfterAll
    void teardown() {
        System.out.println(">>  Tear down");
    }

}
