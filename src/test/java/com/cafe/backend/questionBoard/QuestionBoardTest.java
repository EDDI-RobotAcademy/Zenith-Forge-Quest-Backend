package com.cafe.backend.questionBoard;

import com.cafe.backend.questionBoard.controller.form.QuestionBoardRegisterRequestForm;
import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.entity.Tag;
import com.cafe.backend.questionBoard.repository.QuestionBoardRepository;
import com.cafe.backend.questionBoard.repository.QuestionBoardTagRepository;
import com.cafe.backend.questionBoard.repository.TagRepository;
import com.cafe.backend.questionBoard.repository.TopicRepository;
import com.cafe.backend.questionBoard.service.QuestionBoardService;
import com.cafe.backend.questionBoard.service.QuestionBoardServiceImpl;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
public class QuestionBoardTest {
    @Autowired
    private MockMvc mockMvc;

    @Mock
    private QuestionBoardRepository questionBoardRepository;

    @Mock
    private TagRepository tagRepository;

    @Mock
    private QuestionBoardTagRepository questionBoardTagRepository;

    @Mock
    private TopicRepository topicRepository;

    @InjectMocks
    private QuestionBoardServiceImpl questionBoardService;


    @Test
    @DisplayName("Mocking 테스트를 준비합니다.")
    void test () {
        System.out.println("준비하라고!");
    }


    @Test
    @DisplayName("quest board register test")
    public void register_questboard_test() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper(); // Jackson ObjectMapper

        final String json = "{\"title\":\"제목\",\"content\":\"헤이~ 나는 착한말하는 착한사람~!!\",\"userId\":\"inji\",\"category\":\"Spring\",\"tags\":\"tag1\"}";

        final QuestionBoardRegisterRequestForm registerRequestForm = objectMapper.readValue(json, QuestionBoardRegisterRequestForm.class);

        final QuestionBoardRegisterRequest request = registerRequestForm.toQuestionBoardRegisterRequest();

        QuestionBoard expectedBoard = new QuestionBoard("제목", "내용", "inji", "Spring");

        doReturn(expectedBoard).when(questionBoardRepository).save(any(QuestionBoard.class));

        final QuestionBoardServiceImpl service = new QuestionBoardServiceImpl(questionBoardRepository, tagRepository, questionBoardTagRepository, topicRepository);
        final QuestionBoard actual = service.createQuestion(request);

        assertEquals(actual.getTitle(), expectedBoard.getTitle());
        assertEquals(actual.getContent(), expectedBoard.getContent());
        assertEquals(actual.getTopic(), expectedBoard.getTopic());
        assertEquals(actual.getUserId(), expectedBoard.getUserId());
    }

    @Test
    @DisplayName("get question board none user list")
    public void get_questionboard_nonUserList_test() throws Exception {
        doReturn(Collections.emptyList())
                .when(questionBoardRepository).findAllByOrderById();

        final QuestionBoardServiceImpl service = new QuestionBoardServiceImpl(questionBoardRepository,tagRepository, questionBoardTagRepository, topicRepository);
        final List<QuestionBoard> actual = service.getQuestionByNonUser();

        assertTrue(actual.isEmpty());
    }

    @Test
    @DisplayName("get quest board by user id")
    public void get_question_board_by_useID() throws Exception {
        String name = "inji";
        String title = "타이틀변경경1";
        String content = "설명1";
        String category = "Spring";
        String tags = "init";

        mockMvc.perform(get("/question-board/list/user")
                        .param("userId", name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value(title));
    }

    @Test
    @DisplayName("get quest board by search data")
    public void get_question_board_by_search_data() throws Exception {
        String userId = "inji";
        String searchType = "ALL";
        String searchWord = "타이틀";

        mockMvc.perform(get("/question-board/list/search")
                        .param("userId", userId)
                        .param("searchType", searchType)
                        .param("searchWord", searchWord)
                )

                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].userId").value(userId))
                .andExpect(jsonPath("$[0].title").value(Matchers.containsString(searchWord)))
        ;
    }

    @Test
    @DisplayName("create quest board include tag")
    public void create_question_board_include_tag() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        List<String> tags = new ArrayList<>();
        tags.add("vue");
        tags.add("spring");
        QuestionBoardRegisterRequestForm registerRequestForm = new QuestionBoardRegisterRequestForm(
                "제목", "설", "inji", "backend", tags );

        mockMvc.perform(post("/question-board/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(registerRequestForm))
                )
                .andExpect(jsonPath("$.title").value(registerRequestForm.getTitle()))
                .andExpect(jsonPath("$.content").value(registerRequestForm.getContent()))
                .andExpect(jsonPath("$.userId").value(registerRequestForm.getUserId()))
                .andExpect(jsonPath("$.topic").value(registerRequestForm.getTopic()))
                .andExpect(jsonPath("$.tags[0].content").value(tags.get(0)))
                .andExpect(jsonPath("$.tags[1].content").value(tags.get(1)));
    }
}