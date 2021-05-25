package pizzeria.main.Controllers.Users;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pizzeria.main.Services.CartListService;
import pizzeria.main.Services.OrdersService;
import pizzeria.main.Services.PizzaService;
import pizzeria.main.Services.UsersService;
import pizzeria.main.Session.UsersInfo;

@RequiredArgsConstructor
@Controller
public class UsersController {

    private final UsersService usersService;
    private final UsersInfo usersInfo;
    private final PizzaService pizzaService;
    private final CartListService cartlistService;
    private final OrdersService ordersService;

    @GetMapping("/")
    public String main(Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("pizzaInfo", pizzaService.findAllPizza());
        if(usersInfo.getUserId() != null){
            if(usersInfo.getUserId().equals("master")){
                model.addAttribute("master", usersInfo.getUserId());
            }
        }
        return "main";
    }

    @GetMapping("/users/login")
    public String login() {return "users/login";}

    @GetMapping("/users/signup")
    public String signup() {return "users/signup";}

    @GetMapping("/users/mypage")
    public String mypage(Model model)
    {
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("cardInfo", usersService.findAllCard(usersInfo));
        model.addAttribute("addrInfo", usersService.findAllAddr(usersInfo));
        model.addAttribute("orderInfo", ordersService.orderSearch());
        return "users/mypage";
    }

    @GetMapping("/users/cartlist")
    public String cartlist(Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        if(cartlistService.cartfindByUser() != null){
            model.addAttribute("cartlistInfo", cartlistService.findByCartuid());
        }
        return "users/cartlist";
    }


}
