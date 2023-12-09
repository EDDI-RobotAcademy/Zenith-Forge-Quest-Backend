package com.cafe.backend.menu.service;

import com.cafe.backend.common.exception.custom.NotFoundException;
import com.cafe.backend.menu.entity.Menu;
import com.cafe.backend.menu.repository.MenuRepository;
import com.cafe.backend.menu.service.dto.*;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class MenuService {

    private final MenuRepository menuRepository;

    public void add(MenuAddRequest menuAddRequest) {
        Menu menu = menuAddRequest.toEntity();
        Menu parentMenu = menuRepository.save(menu);

        recursive(parentMenu);
    }

    public MenuReadResponse get(Long id) {
        return MenuReadResponse.of(getMenu(id));
    }

    public void modify(Long id, MenuModifyRequest menuModifyRequest) {
        Menu menu = getMenu(id);
        menu.update(menuModifyRequest.toEntity());
    }

    public void remove(Long id) {
        menuRepository.delete(getMenu(id));
    }

    public Page<MenuPageResponse> getPage(MenuPageRequest menuPageRequest, Pageable pageable) {
        Page<Menu> page = menuRepository.getPage(menuPageRequest, pageable);
        return new PageImpl<>(MenuPageResponse.of(page.getContent()), pageable, page.getTotalElements());
    }

    private Menu getMenu(Long id) {
        return menuRepository.findById(id).orElseThrow(() ->
                new NotFoundException("해당 아이디를 가진 메뉴가 없습니다."));
    }

    private void recursive(Menu parentMenu) {
        List<Menu> children = parentMenu.getChildren();

        for (Menu child : children) {
            child.setParent(parentMenu);

            if (BooleanUtils.isFalse(child.getChildren().isEmpty())) {
                recursive(child);
            }
        }
    }
}
