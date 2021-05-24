package pizzeria.main.Controllers.Orders;

import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pizzeria.main.Services.CartListService;
import pizzeria.main.Services.OrdersService;
import pizzeria.main.Services.PizzaService;
import pizzeria.main.Services.UsersService;
import pizzeria.main.Session.UsersInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value = "Order", description = "\n" + "Order management", tags = { "Order" })
@RequestMapping("/orders")
@RestController
@RequiredArgsConstructor
public class OrdersApiController {
    private final CartListService cartlistService;
    private final OrdersService ordersService;
    private final UsersService usersService;
    private final UsersInfo usersInfo;
    private final PizzaService pizzaService;

    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH");
    String nowDate = format.format(now);

    @PostMapping("/addOrder")
    @ResponseBody
    public void addOrder(
            @RequestParam(value = "pizzaUid[]") List<Long> pizzaUid,
            @RequestParam(value = "count[]") List<Long> count,
            @RequestParam(value = "cardid") String cardid,
            @RequestParam(value = "addrUid") Long addrUid) {

        ordersService.createOrders(pizzaUid, count, cardid, addrUid);

        ordersService.addOrderslist(pizzaUid, count);

        pizzaService.updateCountPizza(pizzaUid, count);
    }

    @PostMapping("/cartOrder")
    @ResponseBody
    public void cartlistOrder(
            @RequestParam(value = "pizzaUid[]") List<Long> pizzaUid,
            @RequestParam(value = "count[]") List<Long> count,
            @RequestParam(value = "cardid") String cardid,
            @RequestParam(value = "addrUid") Long addrUid
    ){

        ordersService.createOrders(pizzaUid, count, cardid, addrUid);

        ordersService.addOrderslist(pizzaUid, count);

        pizzaService.updateCountPizza(pizzaUid, count);

        cartlistService.deleteCart();

    }
}
