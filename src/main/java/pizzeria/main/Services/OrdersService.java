package pizzeria.main.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.main.Classes.*;
import pizzeria.main.Dto.Orders.OrdersCreateDto;
import pizzeria.main.Dto.Orders.OrdersSearchDto;
import pizzeria.main.Dto.OrdersList.OrdersListAddDto;
import pizzeria.main.Interfaces.OrderListRepository;
import pizzeria.main.Interfaces.OrdersRepository;
import pizzeria.main.Session.UsersInfo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//сервис класса заказы
@RequiredArgsConstructor
@Service
public class OrdersService {
    private final PizzaService pizzaService;
    private final UsersService usersService;
    private final OrdersRepository ordersRepository;
    private final OrderListRepository orderlistRepository;
    private final UsersInfo usersInfo;


    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH");
    String nowDate = format.format(now);


    @Transactional
    public void createOrders(List<Long> pizzaUid, List<Long> count, String cardId, Long addrId){
        int totalprice = 0;
        int index = 0;
        for (Long pizzauid : pizzaUid) {
            System.out.println("123123123");
            Pizza pizza = new Pizza();
            pizza = pizzaService.findPizzaById(pizzauid);
            totalprice += (pizza.getPizzaPrice()*count.get(index));
            index++;
        }
        Long totalPrice = (long) totalprice;

        Card card = new Card();
        card = usersService.findCardByCardId(cardId);

        Address addr = new Address();
        addr = usersService.findAddrByUid(addrId);

        Users user = usersService.findUsers(usersInfo);

        OrdersCreateDto ordersCreateDto = new OrdersCreateDto();
        ordersCreateDto.setUsers(user);
        ordersCreateDto.setDate(nowDate);
        ordersCreateDto.setCardId(cardId);
        ordersCreateDto.setCardType(card.getType());
        ordersCreateDto.setCardDate(card.getDatetime());
        ordersCreateDto.setBasicaddr(addr.getBasicAddr());
        ordersCreateDto.setShippingNum(addr.getShippingNum());
        ordersCreateDto.setAmount(totalPrice);
        ordersRepository.save(ordersCreateDto.toEntity());
    }

    @Transactional
    public void addOrderslist(List<Long> pizzaUid, List<Long> count){
        int index = 0;
        for (Long pizzauid : pizzaUid) {
            System.out.println(pizzaUid +"asdasd"+ count);
            Orders lastAddOrders = new Orders();
            lastAddOrders = lastAddOrders();

            Pizza pizza = new Pizza();
            pizza = pizzaService.findPizzaById(pizzauid);

            OrderListMultiId orderlistMultiid = new OrderListMultiId();
            orderlistMultiid.setPizzaUid(pizzauid);
            orderlistMultiid.setOrdersUid(lastAddOrders.getUid());

            OrdersListAddDto orderslistAddDto = new OrdersListAddDto();
            orderslistAddDto.setPizza(pizza);
            orderslistAddDto.setOrderlistMultiid(orderlistMultiid);
            orderslistAddDto.setOrders(lastAddOrders);
            orderslistAddDto.setCount(count.get(index));

            orderlistRepository.save(orderslistAddDto.toEntity());
            index++;
        }

    }

    @Transactional(readOnly = true)
    public Orders lastAddOrders(){
        return ordersRepository.findAllByOrderByUidDesc().get(0);
    }

    @Transactional(readOnly = true)
    public List<OrdersSearchDto> orderSearch(){
        List<OrdersSearchDto> ordersSearchDto = new ArrayList<OrdersSearchDto>();
        List<Orders> orders = ordersRepository.findAllByUsers_Id(usersInfo.getUserId());
        for (Orders order : orders) {
            OrdersSearchDto osd = new OrdersSearchDto();
            osd.setOrderDate(order.getDate());
            osd.setPrice(order.getAmount());
            String Address = order.getBasicaddr();
            osd.setAddress(Address);
            ordersSearchDto.add(osd);
        }

        return ordersSearchDto;
    }
}
