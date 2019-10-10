package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;

import java.util.List;
import java.util.Optional;

public interface MenuService {
    void addMenu(MenuModel menu);
    Optional<MenuModel> findAllMenuByIdRestoran(Long idRestoran);
    Optional<MenuModel> getMenuById(Long id);
    MenuModel changeMenu(MenuModel menuModel);
    void deleteMenu(MenuModel menuModel);
}
