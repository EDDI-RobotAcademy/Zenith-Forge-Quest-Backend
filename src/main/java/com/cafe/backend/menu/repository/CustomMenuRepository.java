package com.cafe.backend.menu.repository;

import com.cafe.backend.menu.entity.Menu;
import com.cafe.backend.menu.service.dto.MenuPageRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @since       2023.11.19
 * @author      jerry
 * @description custom menu repository
 **********************************************************************************************************************/
public interface CustomMenuRepository {

    Page<Menu> getPage(MenuPageRequest menuPageRequest, Pageable pageable);
}
