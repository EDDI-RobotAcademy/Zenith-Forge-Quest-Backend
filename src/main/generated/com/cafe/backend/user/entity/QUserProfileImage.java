package com.cafe.backend.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserProfileImage is a Querydsl query type for UserProfileImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserProfileImage extends EntityPathBase<UserProfileImage> {

    private static final long serialVersionUID = -1089971997L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserProfileImage userProfileImage1 = new QUserProfileImage("userProfileImage1");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QUserProfile userProfile;

    public final StringPath userProfileImage = createString("userProfileImage");

    public QUserProfileImage(String variable) {
        this(UserProfileImage.class, forVariable(variable), INITS);
    }

    public QUserProfileImage(Path<? extends UserProfileImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserProfileImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserProfileImage(PathMetadata metadata, PathInits inits) {
        this(UserProfileImage.class, metadata, inits);
    }

    public QUserProfileImage(Class<? extends UserProfileImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.userProfile = inits.isInitialized("userProfile") ? new QUserProfile(forProperty("userProfile"), inits.get("userProfile")) : null;
    }

}

