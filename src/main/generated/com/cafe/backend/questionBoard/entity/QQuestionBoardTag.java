package com.cafe.backend.questionBoard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuestionBoardTag is a Querydsl query type for QuestionBoardTag
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionBoardTag extends EntityPathBase<QuestionBoardTag> {

    private static final long serialVersionUID = -228788871L;

    public static final QQuestionBoardTag questionBoardTag = new QQuestionBoardTag("questionBoardTag");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> questionId = createNumber("questionId", Long.class);

    public final NumberPath<Long> tagId = createNumber("tagId", Long.class);

    public QQuestionBoardTag(String variable) {
        super(QuestionBoardTag.class, forVariable(variable));
    }

    public QQuestionBoardTag(Path<? extends QuestionBoardTag> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestionBoardTag(PathMetadata metadata) {
        super(QuestionBoardTag.class, metadata);
    }

}

