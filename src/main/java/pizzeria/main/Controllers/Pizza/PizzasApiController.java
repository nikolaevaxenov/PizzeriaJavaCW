package pizzeria.main.Controllers.Pizza;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import pizzeria.main.Config.ApiResponse;
import pizzeria.main.Dto.Pizza.PizzaSaveDto;
import pizzeria.main.Dto.Pizza.PizzaUpdateDto;
import pizzeria.main.Services.PizzaService;

@Api(value = "pizzas", description = "\n" +
        "Pizza management", tags = { "\n" +
        "pizzas" })
@RequestMapping("/pizzas")
@RestController
@RequiredArgsConstructor
public class PizzasApiController {
    private final PizzaService pizzaService;

    @ApiOperation(value = "Pizza registration")
    @PostMapping("/savePizzas")
    public ResponseEntity<?> savePizzas(@RequestBody PizzaSaveDto pizzaSaveDto){
        ApiResponse result = null;
        try {
            result = new ApiResponse(true, "\n" + "success", pizzaService.savePizza(pizzaSaveDto));
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "\n" + "Pizza modification")
    @PostMapping("/updatePizzas/{uid}")
    public ResponseEntity<?> updatePizzas(@PathVariable("uid") Long uid, @RequestBody PizzaUpdateDto pizzaUpdateDto){
        ApiResponse result = null;
        pizzaUpdateDto.setUid(uid);
        try {
            pizzaService.updatePizza(uid, pizzaUpdateDto);
            result = new ApiResponse(true, "\n" + "success",pizzaService.findPizzaById(uid));
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @ApiOperation(value = "\n" + "Delete pizza")
    @PostMapping("/deletePizzas/{uid}")
    public RedirectView deletePizzas(@PathVariable("uid") Long uid){
        pizzaService.deletePizza(uid);
        return new RedirectView("/");
    }

}