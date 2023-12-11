package com.cafe.backend.menu.repository;

import com.cafe.backend.menu.entity.Menu;
import com.cafe.backend.menu.entity.QMenu;
import com.cafe.backend.menu.service.dto.MenuPageRequest;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import java.util.List;

@RequiredArgsConstructor
public class CustomMenuRepositoryImpl implements CustomMenuRepository{

    private final JPAQueryFactory jpaQueryFactory;

    private final QMenu menu = QMenu.menu;

    @Override
    public Page<Menu> getPage(MenuPageRequest menuPageRequest, Pageable pageable) {
        QueryResults<Menu> results = jpaQueryFactory
                .selectFrom(menu)
                .where(
                        nameLike(menuPageRequest.name()),
                        parentIsNull()
                )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Menu> content = results.getResults();
        long count = results.getTotal();

        return new PageImpl<>(content, pageable, count);
    }

    private BooleanExpression nameLike(String name) {
        return StringUtils.hasText(name) ? menu.name.contains(name) : null;
    }

    private BooleanExpression parentIsNull() {
        return menu.parent.isNull();
    }
}
