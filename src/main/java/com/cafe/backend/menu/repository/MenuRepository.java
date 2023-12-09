package com.cafe.backend.menu.repository;

import com.cafe.backend.menu.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @since       2023.11.18
 * @author      jerry
 * @description menu repository
 **********************************************************************************************************************/
@Repository
public interface MenuRepository extends JpaRepository<Menu, Long>, CustomMenuRepository {
}
