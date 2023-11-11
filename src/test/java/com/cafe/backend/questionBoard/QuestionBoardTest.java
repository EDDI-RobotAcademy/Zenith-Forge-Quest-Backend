package com.cafe.backend.questionBoard;

import com.cafe.backend.questionBoard.controller.form.QuestionBoardRegisterRequestForm;
import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.repository.QuestionBoardRepository;
import com.cafe.backend.questionBoard.service.QuestionBoardServiceImpl;
import com.cafe.backend.questionBoard.service.request.QuestionBoardRegisterRequest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
        final QuestionBoardRegisterRequestForm registerRequestForm = new QuestionBoardRegisterRequestForm(
                "제목", "내용", "inji", "Spring", List.of("tag1", "tag2"));

        final QuestionBoardRegisterRequest request = registerRequestForm.toQuestionBordRegisterRequest();

        QuestionBoard expectedBoard = new QuestionBoard("제목", "내용", "inji", "Spring", List.of("tag1", "tag2"));

        doReturn(expectedBoard).when(questionBoardRepository).save(any(QuestionBoard.class));

        final QuestionBoardServiceImpl service = new QuestionBoardServiceImpl(questionBoardRepository);
        final QuestionBoard actual = service.createQuestion(request);

        assertEquals(actual.getTitle(), expectedBoard.getTitle());
        assertEquals(actual.getContent(), expectedBoard.getContent());
        assertEquals(actual.getCategory(), expectedBoard.getCategory());
        assertEquals(actual.getUserId(), expectedBoard.getUserId());
        assertEquals(actual.getTags(), expectedBoard.getTags());
    }
}