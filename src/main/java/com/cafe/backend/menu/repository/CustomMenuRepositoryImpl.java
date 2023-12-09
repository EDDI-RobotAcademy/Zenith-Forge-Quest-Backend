package com.cafe.backend.menu.repository;

import com.cafe.backend.menu.entity.Menu;
import com.cafe.backend.menu.service.dto.MenuPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class CustomMenuRepositoryImpl implements CustomMenuRepository{


    @Override
    public Page<Menu> getPage(MenuPageRequest menuPageRequest, Pageable pageable) {
        return null;
    }
}
