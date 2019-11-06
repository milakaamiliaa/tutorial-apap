package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;

import java.util.List;

public interface MenuRestService {
    MenuModel addMenu(MenuModel menu);
    MenuModel updateMenu(Long id, MenuModel menuUpdate);
    List<MenuModel> retrieveMenuList();
    MenuModel getMenuById(Long id);
    void deleteMenu(Long id);
}
