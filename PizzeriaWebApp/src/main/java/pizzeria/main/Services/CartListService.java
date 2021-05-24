package pizzeria.main.Services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pizzeria.main.Classes.Cart;
import pizzeria.main.Classes.CartList;
import pizzeria.main.Classes.MultiId;
import pizzeria.main.Dto.CartList.CartCreateDto;
import pizzeria.main.Dto.CartList.CartListAddDto;
import pizzeria.main.Interfaces.CartListRepository;
import pizzeria.main.Interfaces.CartRepository;
import pizzeria.main.Interfaces.PizzaRepository;
import pizzeria.main.Session.UsersInfo;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
//Сервис класса список корзины
@RequiredArgsConstructor
@Service
public class CartListService {
    private final UsersInfo usersInfo;
    private final CartRepository cartRepository;
    private final PizzaRepository pizzaRepository;
    private final CartListRepository cartlistRepository;
    private final UsersService usersService;
    private final PizzaService pizzaService;

    Date now = new Date();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy ss:mm:HH");
    String nowDate = format.format(now);

    @Transactional(readOnly = true)
    public Cart cartfindByUser(){
        return cartRepository.findByUsers_Id(usersInfo.getUserId());
    }

    @Transactional(readOnly = true)
    public boolean existCart(){
        return cartRepository.findByUsers_Id(usersInfo.getUserId()) != null;
    }

    @Transactional
    public String createCart(){
        CartCreateDto cartCreateDto = new CartCreateDto();
        cartCreateDto.setCreatetime(nowDate);
        cartCreateDto.setModifytime(nowDate);
        cartCreateDto.setUsers(usersService.findUsers(usersInfo));

        return cartRepository.save(cartCreateDto.toEntity()).toString();
    }

    @Transactional
    public void deleteCart(){
        Cart cart = cartfindByUser();
        cartRepository.delete(cart);
    }

    @Transactional
    public String addCartlist(Long pizzaUid, CartListAddDto cartlistAddDto){
        Long cartUid = cartRepository.findByUsers_Id(usersInfo.getUserId()).getUid();
        MultiId multiId = new MultiId();
        multiId.setCartUid(cartUid);
        multiId.setPizzaUid(pizzaUid);
        cartlistAddDto.setMultiId(multiId);
        cartlistAddDto.setPizza(pizzaService.findPizzaById(pizzaUid));
        cartlistAddDto.setCart(cartfindByUser());

        return cartlistRepository.save(cartlistAddDto.toEntity()).toString();
    }

    @Transactional
    public void updateModifyTimeInCart(){
        Cart cart = cartfindByUser();
        cart.updateModifytime(nowDate);
    }

    @Transactional(readOnly = true)
    public List<CartList> findByCartuid(){
        Long cartUid = cartfindByUser().getUid();
        return cartlistRepository.findAllByCart_Uid(cartUid);
    }

    @Transactional
    public void deleteCartlist(Long pizzaUid){
        Cart cart = cartfindByUser();
        MultiId mId = new MultiId();
        mId.setCartUid(cart.getUid());
        mId.setPizzaUid(pizzaUid);
        cartlistRepository.deleteById(mId);
    }

}