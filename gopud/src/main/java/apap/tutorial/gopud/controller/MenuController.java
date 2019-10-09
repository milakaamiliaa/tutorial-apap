package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.awt.*;
import java.util.ArrayList;
import java.util.Optional;

@Controller
public class MenuController {

    @Autowired
    MenuService menuService;

    @Qualifier("restoranServiceImpl")
    @Autowired
    RestoranService restoranService;

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.GET)
    private String addProductFormPage(@PathVariable(value = "idRestoran") Long idRestoran, Model model) {
        MenuModel menu = new MenuModel();
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        ArrayList<MenuModel> list = new ArrayList<MenuModel>();
        list.add(new MenuModel());
        restoran.setListMenu(list);
        model.addAttribute("restoran", restoran);
        model.addAttribute("pageTitle", "Add Menu");
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"addRow"})
    public String addRow(@ModelAttribute RestoranModel restoran, BindingResult bindingResult, Model model){
        if (restoran.getListMenu()==null){
            restoran.setListMenu(new ArrayList<MenuModel>());
        }
        restoran.getListMenu().add(new MenuModel());
        model.addAttribute("restoran", restoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "/menu/add/{idRestoran}", method = RequestMethod.POST, params={"removeRow"})
    public String removeRow(@ModelAttribute RestoranModel restoran, final BindingResult bindingResult, final HttpServletRequest request, Model model){
        final Integer rowId = Integer.valueOf(request.getParameter("removeRow"));
        restoran.getListMenu().remove(rowId.intValue());
        model.addAttribute("restoran", restoran);
        return "form-add-menu";
    }

    @RequestMapping(value = "menu/add/{restoranId}", method = RequestMethod.POST, params = {"save"})
    private String addProductSubmit(@ModelAttribute RestoranModel restoran) {
        RestoranModel restoranNow = restoranService.getRestoranByIdRestoran(restoran.getIdRestoran()).get();
        for(MenuModel menu : restoran.getListMenu()){
            menu.setRestoran(restoranNow);
            menuService.addMenu(menu);
        }
        return "add-menu";
    }

    @RequestMapping(value = "menu/change/{id}", method = RequestMethod.GET)
    public String changeMenuFormPage(@PathVariable Long id, Model model) {
        MenuModel existingMenu = menuService.getMenuById(id).get();
        model.addAttribute("menu", existingMenu);
        return "form-change-menu";
    }

    @RequestMapping(value = "menu/change/{id}", method = RequestMethod.POST)
    public String changeMenuSubmit(@PathVariable Long id, @ModelAttribute MenuModel menu, Model model) {
        MenuModel newMenuData = menuService.changeMenu(menu);
        model.addAttribute("menu", newMenuData);
        return "change-menu";
    }

    @RequestMapping(value = "menu/delete/{id}", method = RequestMethod.POST)
    public String delete(@ModelAttribute RestoranModel restoran, Model model) {
        for (MenuModel menu : restoran.getListMenu()) {
            menuService.deleteMenu(menu);
        }
        return "delete-menu";
    }
}
