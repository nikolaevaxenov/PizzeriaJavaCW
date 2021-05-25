package pizzeria.main.Controllers.CartList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pizzeria.main.Config.ApiResponse;
import pizzeria.main.Dto.CartList.CartListAddDto;
import pizzeria.main.Services.CartListService;
import pizzeria.main.Services.PizzaService;

import java.util.List;

@Api(value = "Cart", description = "Cart management", tags = { "Cart" })
@RequestMapping("/cart")
@RestController
@RequiredArgsConstructor
public class CartListApiController {
    private final CartListService cartlistService;
    private final PizzaService pizzaService;

    @ApiOperation(value = "Add to Shopping Cart")
    @PostMapping("/addCartlist/{pizzaUid}")
    public ResponseEntity<?> addCartlist(@PathVariable(value = "pizzaUid") Long pizzaUid, @RequestBody CartListAddDto cartlistAddDto) {
        ApiResponse result = null;
        try {
            if (cartlistService.existCart()){
                System.out.println("Exist Cart");
                result = new ApiResponse(true, "success", cartlistService.addCartlist(pizzaUid, cartlistAddDto));
                cartlistService.updateModifyTimeInCart();
            }else {
                System.out.println("Not Exist Cart");
                cartlistService.createCart();
                result = new ApiResponse(true, "\n" + "success", cartlistService.addCartlist(pizzaUid, cartlistAddDto));
            }
            return ResponseEntity.ok().body(result);
        }catch (Exception e){
            e.printStackTrace();
            result = new ApiResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(result);
        }
    }

    @PostMapping(value = "/deleteCartlist")
    public void deleteCartlist(@RequestParam(value = "checkArr[]") List<Long> valueArr){
        for (Long string : valueArr) {
            cartlistService.deleteCartlist(string);
        }
    }
}