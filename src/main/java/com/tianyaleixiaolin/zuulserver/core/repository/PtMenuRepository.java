package com.tianyaleixiaolin.zuulserver.core.repository;

import com.tianyaleixiaolin.zuulserver.core.model.PtMenu;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author wuweifeng wrote on 2017/10/26.
 */
public interface PtMenuRepository extends JpaRepository<PtMenu, Long> {
    int countByParentIdAndHideIsFalse(Long id);
}
