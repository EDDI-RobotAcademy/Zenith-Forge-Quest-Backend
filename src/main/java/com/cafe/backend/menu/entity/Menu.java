package com.cafe.backend.menu.entity;

import com.cafe.backend.common.base.entity.BaseEntity;
import com.cafe.backend.menu.service.dto.MenuModifyRequest;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Entity
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Menu extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Long sort;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Menu parent;

    @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Menu> children;

    // 권한 생성시 권한 고려

    @Builder(toBuilder = true)
    public Menu(String name, String url, Long sort, Menu parent, List<Menu> children) {
        this.name     = name;
        this.url      = url;
        this.sort     = sort;
        this.parent   = parent;
        this.children = children;
    }

    public void update(MenuModifyRequest menuModifyRequest) {

    }

    public void addChild(Menu menu) {
        this.children.add(menu);
        menu.parent = this;
    }

    public void setParent(Menu parentMenu) {
        this.parent = parentMenu;
    }
}
