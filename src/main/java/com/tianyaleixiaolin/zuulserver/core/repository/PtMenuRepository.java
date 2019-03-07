package com.tianyaleixiaolin.zuulserver.core.repository;

import com.tianyaleixiaolin.zuulserver.core.model.PtMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author libolin wrote on 2018/10/26.
 */
public interface PtMenuRepository extends JpaRepository<PtMenu, Long> {
    int countByParentIdAndHideIsFalse(Long id);
}
