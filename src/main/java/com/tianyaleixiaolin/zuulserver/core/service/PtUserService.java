package com.tianyaleixiaolin.zuulserver.core.service;

import com.tianyaleixiaolin.zuulserver.core.manager.PtRoleManager;
import com.tianyaleixiaolin.zuulserver.core.manager.PtRoleMenuManager;
import com.tianyaleixiaolin.zuulserver.core.manager.PtUserManager;
import com.tianyaleixiaolin.zuulserver.core.model.PtMenu;
import com.tianyaleixiaolin.zuulserver.core.model.PtRole;
import com.tianyaleixiaolin.zuulserver.core.model.PtUser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author libolin wrote on 2018/10/30.
 */
@Service
@Transactional
public class PtUserService {
    @Resource
    private PtRoleManager ptRoleManager;
    @Resource
    private PtRoleMenuManager ptRoleMenuManager;
    @Resource
    private PtUserManager ptUserManager;

    public boolean checkMenu(Long userId, String path, String method) {
        List<PtRole> roleList = ptRoleManager.findRolesByUser(userId);
        List<PtMenu> menuList = ptRoleMenuManager.findAllMenuByRoles(roleList);
        for (PtMenu menu : menuList) {
            String url = menu.getUrl();
            String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
            String regEx = "^" + uri + "$";
            //如果匹配，就返回true
            boolean check = Pattern.compile(regEx).matcher(path).find() || path.startsWith(url + "/")
                    && method.equals(menu.getMethod());
            if(check) {
                return true;
            }
        }

        return false;
    }

    public boolean checkState(Long userId) {
        PtUser ptUser = ptUserManager.find(userId);
        if (ptUser != null && ptUser.getState() == 0 && !ptUser.isDeleteFlag()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String url = "/group/{*}/user";
        String uri = url.replaceAll("\\{\\*\\}", "[a-zA-Z\\\\d]+");
        String regEx = "^" + uri + "$";
        String finalRequestUri = "/group/1/user";
        boolean s =  Pattern.compile(regEx).matcher(finalRequestUri).find() || finalRequestUri.startsWith(url + "/");
        System.out.println(s);
    }
}
