package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("api/v1")
public class MenuRestController {
    @Autowired
    private MenuRestService menuRestService;

    @PostMapping(value = "/menu")
    private MenuModel addMenu(@Valid @RequestBody MenuModel menu, BindingResult bindingResult){
        if(bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        } else {
            return menuRestService.addMenu(menu);
        }
    }

    @GetMapping(value = "/menu/{idMenu}")
    private MenuModel getMenu(@PathVariable("idMenu") Long idMenu){
        try{
            return menuRestService.getMenuById(idMenu);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Menu " + String.valueOf(idMenu)+" Not Found");
        }
    }

    @GetMapping(value = "/menus")
    private List<MenuModel> retrieveListMenu(){
        return menuRestService.retrieveMenuList();
    }

    @DeleteMapping(value = "/menu/{idMenu}")
    private ResponseEntity<String> deleteMenu(@PathVariable("idMenu") Long idMenu){
        try {
            menuRestService.deleteMenu(idMenu);
            return ResponseEntity.ok("Menu with ID "+ String.valueOf(idMenu)+" Deleted!");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Menu with ID " + String.valueOf(idMenu)+" Not Found");
        }
    }

    @PutMapping(value = "/menu/{idMenu}")
    private MenuModel updateMenu(@PathVariable("idMenu") Long idMenu, @RequestBody MenuModel menu){
        try {
            return menuRestService.updateMenu(idMenu, menu);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Menu " + String.valueOf(idMenu)+" Not Found");
        }
    }
}
