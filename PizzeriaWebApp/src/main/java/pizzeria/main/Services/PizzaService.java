package pizzeria.main.Services;

import pizzeria.main.Classes.Pizza;
import pizzeria.main.Dto.Pizza.PizzaSaveDto;
import pizzeria.main.Dto.Pizza.PizzaUpdateCountDto;
import pizzeria.main.Dto.Pizza.PizzaUpdateDto;
import pizzeria.main.Interfaces.CartRepository;
import pizzeria.main.Interfaces.PizzaRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class PizzaService<UsersInfo> {
    private final PizzaRepository pizzaRepository;
    private final CartRepository cartRepository;
    private final UsersInfo usersInfo;

    @Transactional
    public String savePizza(PizzaSaveDto pizzaSaveDto){
        return pizzaRepository.save(pizzaSaveDto.toEntity()).toString();
    }

    @Transactional(readOnly = true)
    public List<Pizza> findAllPizza(){
        return pizzaRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Pizza findPizzaById(Long pizzaUid){
        return pizzaRepository.findById(pizzaUid).get();
    }

    @Transactional
    public void updatePizza(Long pizzaUid, PizzaUpdateDto pizzaUpdateDto){
        findPizzaById(pizzaUid).updatePizza(pizzaUpdateDto);
    }

    @Transactional(readOnly = true)
    public List<Pizza> findPizzaByLike(String name){
        return pizzaRepository.findAllByPizzaNameIgnore(name);
    }

    @Transactional
    public void updateCountPizza(List<Long> pizzaUid, List<Long> count){
        int index = 0;
        for (Long pizzauid : pizzaUid) {
            System.out.println("Pizza count update");
            Pizza pizza = new Pizza();
            pizza = findPizzaById(pizzauid);
            Long updatePizzaCount = pizza.getPizzaCount() - count.get(index);
            PizzaUpdateCountDto pizzaUpdateCountDto = new PizzaUpdateCountDto();
            pizzaUpdateCountDto.setPizzaCount(updatePizzaCount);
            findPizzaById(pizzauid).updateCount(pizzaUpdateCountDto);
            index++;
        }
    }

    @Transactional(readOnly = true)
    public List<Pizza> findPizzaByArrayUid(List<Long> pizzaUid){
        List<Pizza> arrPizza = new ArrayList<Pizza>();
        for (Long uid : pizzaUid) {
            arrPizza.add(pizzaRepository.getOne(uid));
        }
        return arrPizza;
    }


    @Transactional
    public void deletePizza(Long uid){
        pizzaRepository.delete(findPizzaById(uid));
    }
}
