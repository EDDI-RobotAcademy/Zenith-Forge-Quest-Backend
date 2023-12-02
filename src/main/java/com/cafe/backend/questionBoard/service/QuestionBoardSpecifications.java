package com.cafe.backend.questionBoard.service;

import com.cafe.backend.questionBoard.controller.form.QuestionBoardSearchType;
import com.cafe.backend.questionBoard.entity.QuestionBoard;
import com.cafe.backend.questionBoard.service.request.QuestionBoardSearchRequest;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class QuestionBoardSpecifications {

    public static Specification<QuestionBoard> searchQuestionBoard(QuestionBoardSearchRequest search) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (search.getUserId() != null) {
                //member 정리될 때까지 보류
//                Join<QuestionBoard, Member> memberJoin = root.join("member", JoinType.INNER);
//                predicates.add(criteriaBuilder.equal(memberJoin.get("userId"), search.getUserId()));
                predicates.add(criteriaBuilder.equal(root.get("userId"), search.getUserId()));
            }

            if (search.getSearchWord() != null) {
                Predicate content = null;
                Predicate title = null;

                if (QuestionBoardSearchType.ALL.getSearchType().equals(search.getSearchType().getSearchType())) {
                    title = criteriaBuilder.like(root.get("title"), "%" + search.getSearchWord() +"%");
                    content = criteriaBuilder.like(root.get("content"), "%" + search.getSearchWord() +"%");
                }
                if (QuestionBoardSearchType.TITLE.getSearchType().equals(search.getSearchType().getSearchType())) {
                    title = criteriaBuilder.like(root.get("title"), "%" + search.getSearchWord() +"%");
                }
                if (QuestionBoardSearchType.CONTENT.getSearchType().equals(search.getSearchType().getSearchType())) {
                    content = criteriaBuilder.like(root.get("content"), "%" + search.getSearchWord() +"%");
                }
               predicates.add(criteriaBuilder.or(content,title));
            }

            if(search.getSearchType() != null) {
                //tag table정리될 때까지 보류
            }

            if(search.getCategory() != null) {
                //category table정리될 때까지 보류
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}