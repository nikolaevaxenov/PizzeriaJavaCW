package pizzeria.main.Controllers.Pizza;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pizzeria.main.Services.PizzaService;
import pizzeria.main.Session.UsersInfo;

@RequiredArgsConstructor
@Controller
public class PizzasController {
    private final PizzaService pizzaService;
    private final UsersInfo usersInfo;

    @GetMapping("/pizzas/pizzasave")
    public String pizzasave(Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        return "pizzas/savePizza";
    }

    @GetMapping("/pizzas/pizzadetail")
    public String pizzadetail(@RequestParam(value = "uid") Long uid, Model model) {
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("pizzaInfo",pizzaService.findPizzaById(uid));
        if(usersInfo.getUserId() != null){
            if(usersInfo.getUserId().equals("master")){
                model.addAttribute("master", usersInfo.getUserId());
            }
        }
        if(usersInfo.getUserId() == null){
            model.addAttribute("existSession", "notExistSession");
        }
        return "pizzas/detailPizza";
    }

    @GetMapping("/pizzas/pizzaupdate")
    public String pizzaupdate(@RequestParam(value="uid") Long uid, Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("pizzaInfo", pizzaService.findPizzaById(uid));
        return "pizzas/updatePizza";
    }

    @GetMapping("/pizzas/pizzaSearch")
    public String pizzasearch(@RequestParam(value = "sn") String search, Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("pizzaInfo",pizzaService.findPizzaByLike(search));
        return "pizzas/searchPizza";
    }
}
