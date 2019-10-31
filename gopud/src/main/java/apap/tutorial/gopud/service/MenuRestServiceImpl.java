package apap.tutorial.gopud.service;


import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService {
    @Autowired
    private MenuDB menuDb;

    @Override
    public MenuModel addMenu(MenuModel menu) {
        return menuDb.save(menu);
    }

    @Override
    public MenuModel updateMenu(Long idMenu, MenuModel menuUpdate) {
        MenuModel menu = getMenuById(idMenu);
        menu.setDeskripsi(menuUpdate.getDeskripsi());
        menu.setDurasiMasak(menuUpdate.getDurasiMasak());
        menu.setHarga(menuUpdate.getHarga());
        menu.setNama(menuUpdate.getNama());
        return menuDb.save(menu);
    }

    @Override
    public List<MenuModel> retrieveMenuList() {
        return menuDb.findAllByOrderByNamaAsc();
    }

    @Override
    public MenuModel getMenuById(Long idMenu) {
        Optional<MenuModel> menu = menuDb.findById(idMenu);
        if(menu.isPresent()){
            return menu.get();
        } else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteMenu(Long idMenu) {
        MenuModel menu = getMenuById(idMenu);
        menuDb.delete(menu);
    }
}
