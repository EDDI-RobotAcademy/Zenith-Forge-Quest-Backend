package com.cafe.backend.questionBoard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuestionBoardTopic is a Querydsl query type for QuestionBoardTopic
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionBoardTopic extends EntityPathBase<QuestionBoardTopic> {

    private static final long serialVersionUID = -822343858L;

    public static final QQuestionBoardTopic questionBoardTopic = new QQuestionBoardTopic("questionBoardTopic");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final NumberPath<Long> topicId = createNumber("topicId", Long.class);

    public QQuestionBoardTopic(String variable) {
        super(QuestionBoardTopic.class, forVariable(variable));
    }

    public QQuestionBoardTopic(Path<? extends QuestionBoardTopic> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestionBoardTopic(PathMetadata metadata) {
        super(QuestionBoardTopic.class, metadata);
    }

}

