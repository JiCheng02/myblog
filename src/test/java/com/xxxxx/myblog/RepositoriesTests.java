package com.xxxxx.myblog;

import com.xxxxx.myblog.entity.Article;
import com.xxxxx.myblog.entity.User;
import com.xxxxx.myblog.repository.ArticleRepository;
import com.xxxxx.myblog.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
public class RepositoriesTests {

    @Autowired
    TestEntityManager entityManager;

    @Autowired
    ArticleRepository articleRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void whenFindByIdOrNull_thenReturnArticle() {
        User leili = new User().setLogin("leili").setFirstName("Lei").setLastName("Li");
        entityManager.persist(leili);
        Article article = new Article().setTitle("Spring Framework 5.0 goes GA").setHeadline("Dear Spring community ...")
                .setContent("Lorem ipsum").setAuthor(leili);
        entityManager.persist(article);
        entityManager.flush();
        Article found = articleRepository.findById(article.getId()).orElse(null);
        assertThat(article).isEqualTo(found);
    }

    @Test
    void whenFindByLogin_thenReturnUser() {
        User leili = new User().setLogin("leili").setFirstName("Lei").setLastName("Li");
        entityManager.persistAndFlush(leili);
        User found = userRepository.findByLogin(leili.getLogin());
        assertThat(found).isEqualTo(leili);
    }
}
