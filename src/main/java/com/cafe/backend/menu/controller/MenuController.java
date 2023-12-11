package com.cafe.backend.menu.controller;

import com.cafe.backend.menu.controller.form.MenuAddForm;
import com.cafe.backend.menu.controller.form.MenuModifyForm;
import com.cafe.backend.menu.controller.form.MenuPageForm;
import com.cafe.backend.menu.service.MenuService;
import com.cafe.backend.menu.service.dto.MenuPageResponse;
import com.cafe.backend.menu.service.dto.MenuReadResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class MenuController {

    private final MenuService menuService;

    @PostMapping("/menus")
    public void add(@Valid @RequestBody MenuAddForm menuAddForm) {
        menuService.add(menuAddForm.toDto());
    }

    @GetMapping("/menus/{id}")
    public MenuReadResponse get(@PathVariable Long id) {
        return menuService.get(id);
    }

    @GetMapping("/menus/pages")
    public Page<MenuPageResponse> getPage(@Valid MenuPageForm menuPageForm, @PageableDefault Pageable pageable) {
        return menuService.getPage(menuPageForm.toDto(), pageable);
    }

    @PutMapping("/menus/{id}")
    public void modify(@PathVariable Long id, @Valid @RequestBody MenuModifyForm menuModifyForm) {
        menuService.modify(id, menuModifyForm.toDto());
    }

    @DeleteMapping("/menus/{id}")
    public void remove(@PathVariable Long id) {
        menuService.remove(id);
    }
}
