package com.xxxxx.myblog;

import com.xxxxx.myblog.utils.CommonUtil;
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
        System.out.println(">> Assert blog page title, content and status code");
        ResponseEntity<String> entity = restTemplate.getForEntity("/", String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains("<h1>Blog</h1>", "title");
    }

    @Test
    void assertArticlePageTitle_Content_And_StatusCode() {
        System.out.println(">> Assert article page title, content and status code");
        String title = "title1";
        ResponseEntity<String> entity = restTemplate.getForEntity(String.format("/article/%s", CommonUtil.toSlug(title)), String.class);
        assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(entity.getBody()).contains(title, "headline1", "content1");
    }
    @AfterAll
    void teardown() {
        System.out.println(">>  Tear down");
    }

}
