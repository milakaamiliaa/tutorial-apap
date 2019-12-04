package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

//    @RequestMapping("/")
//    public String home() {
//        return "home";
//    }

    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("restoran", newRestoran);
        return "form-add-restoran";
    }

    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }

    @RequestMapping(value = "restoran/view-all", method = RequestMethod.GET)
    public String viewAll(Model model) {
        List<RestoranModel> restoList = restoranService.getRestoranList();
        Collections.sort(restoList);
        model.addAttribute("restoList", restoList);
        return "viewall-restoran";
    }

    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
            @RequestParam(value = "idRestoran") Long idRestoran, Model model
    ) {
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();

        Optional<MenuModel> menuList = menuService.findAllMenuByIdRestoran(restoran.getIdRestoran());
        restoran.setListMenu(menuList.stream().collect(Collectors.toList()));
        model.addAttribute("resto", restoran);
        return "view-restoran";
    }

    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        return "form-change-restoran";
    }

    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran,
                                           Model model) {
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);
        return "change-restoran";
    }

    @RequestMapping(value = "restoran/delete/{idRestoran}", method = RequestMethod.GET)
    public String deleteRestoran(@PathVariable Long idRestoran, Model model) {
        RestoranModel targetRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        if (targetRestoran == null) {
            return "id-restoran-not-found";
        }
        model.addAttribute("restoran", targetRestoran);
        if (restoranService.deleteRestoran(targetRestoran)) {
            return viewAll(model);
        }
        return "delete-restoran";
    }
}