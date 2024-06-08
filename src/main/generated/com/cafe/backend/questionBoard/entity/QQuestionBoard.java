package com.cafe.backend.questionBoard.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuestionBoard is a Querydsl query type for QuestionBoard
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuestionBoard extends EntityPathBase<QuestionBoard> {

    private static final long serialVersionUID = 937962081L;

    public static final QQuestionBoard questionBoard = new QQuestionBoard("questionBoard");

    public final StringPath content = createString("content");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final StringPath userId = createString("userId");

    public QQuestionBoard(String variable) {
        super(QuestionBoard.class, forVariable(variable));
    }

    public QQuestionBoard(Path<? extends QuestionBoard> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuestionBoard(PathMetadata metadata) {
        super(QuestionBoard.class, metadata);
    }

}

