package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.service.RestoranRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/v1")
public class RecipeRestController {
    @Autowired
    RestoranRestService restoranRestService;

    @GetMapping(value = "/recipe/{menu}/{bahan}")
    private Mono<String> getStatus(@PathVariable String menu, String bahan){
        return restoranRestService.getRecipe(menu, bahan);
    }
}
