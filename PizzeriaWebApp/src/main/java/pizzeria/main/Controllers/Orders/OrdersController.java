package pizzeria.main.Controllers.Orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pizzeria.main.Services.OrdersService;
import pizzeria.main.Services.PizzaService;
import pizzeria.main.Services.UsersService;
import pizzeria.main.Session.UsersInfo;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class OrdersController {
    private final UsersInfo usersInfo;
    private final OrdersService ordersService;
    private final UsersService usersService;
    private final PizzaService pizzaservice;

    @GetMapping("/orders/addOrder")
    public String addOrder(@RequestParam(value = "pizzaUid") Long pizzaUid, @RequestParam(value="count") Long count ,Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("cardInfo", usersService.findAllCard(usersInfo));
        model.addAttribute("addrInfo", usersService.findAllAddr(usersInfo));
        model.addAttribute("pizzaInfo", pizzaservice.findPizzaById(pizzaUid));
        model.addAttribute("count", count);

        return "orders/addOrder";
    }

    @GetMapping("/orders/addCartlistOrder")
    public String addCartlistOrder(@RequestParam(value = "pizzaUid[]") List<Long> pizzaUid, @RequestParam(value = "count[]") Long[] count , Model model){
        model.addAttribute("userid", usersInfo.getUserId());
        model.addAttribute("cardInfo", usersService.findAllCard(usersInfo));
        model.addAttribute("addrInfo", usersService.findAllAddr(usersInfo));
        model.addAttribute("pizzaInfo", pizzaservice.findPizzaByArrayUid(pizzaUid));
        model.addAttribute("count", count);

        return "orders/addCartlistOrder";
    }


}