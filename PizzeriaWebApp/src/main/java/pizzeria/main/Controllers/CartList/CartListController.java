package pizzeria.main.Controllers.CartList;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import pizzeria.main.Services.CartListService;

@RequiredArgsConstructor
@Controller
public class CartListController {
    private final CartListService cartlistService;
}

