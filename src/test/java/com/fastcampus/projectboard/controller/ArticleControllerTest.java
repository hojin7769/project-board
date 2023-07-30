package com.fastcampus.projectboard.controller;

import com.fastcampus.projectboard.config.SecurityConfig;
import org.hibernate.annotations.Immutable;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@DisplayName("View 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
@Import(SecurityConfig.class)
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }
    @DisplayName("[view][GET] 게시글 리스트 (게시판)페이지 - 정상 호출")
    @Test
    void givenNoting_whenRequestingArticlesView_thenReturnsArticlesView() throws Exception {

        // Given

        // When && Then
        mvc.perform(get("/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //비슷한 유형이면 통과
                .andExpect(view().name("articles/index"))
                .andExpect(model().attributeExists("articles"));

    }

    @DisplayName("[View] [GET] 게시글 상세페이지 - 정상호출")
    @Test
    public void givenNoting_whenRequestingArticleView_thenReturnArticleView() throws Exception {
        // given

        // When && then
        mvc.perform(get("/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //비슷한 유형이면 통과
                .andExpect(view().name("articles/detail"))
                .andExpect(model().attributeExists("article"))
                .andExpect(model().attributeExists("articleComments"));

    }

    @Disabled("구현 중")
    @DisplayName("[View] [GET] 게시글 검색 전용 페이지- 정상호출")
    @Test
    public void givenNoting_whenRequestingArticleSearchView_thenReturnArticleSearchView() throws Exception {
        // given

        // When && then
        mvc.perform(get("/articles/search"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //비슷한 유형이면 통과
                .andExpect(model().attributeExists("articles/search"));


    }

    @Disabled("구현 중")
    @DisplayName("[View] [GET] 게시글 해시태그 검색 페이지 - 정상호출")
    @Test
    public void givenNoting_whenRequestingArticleHashtagSearchView_thenReturnArticleHashtagSearchView() throws Exception {
        // given

        // When && then
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_HTML)) //비슷한 유형이면 통과
                .andExpect(model().attributeExists("articles/search-hashtag"));
    }
}
