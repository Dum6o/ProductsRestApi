package lt.edvardas.task.controllers;

import lt.edvardas.task.model.requests.ProductsRequest;
import lt.edvardas.task.model.responses.ProductsResponse;
import lt.edvardas.task.tools.ProductsManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(maxAge = 600)
@RestController
public class ProductsController {

    @RequestMapping("/")
    public boolean checkConnection() {
        return true;
    }

    @RequestMapping(path = "/products", produces = "application/json")
    public @ResponseBody
    ProductsResponse getRecommendedProducts(@RequestParam Integer ageId,
                                            @RequestParam Boolean isStudent,
                                            @RequestParam Integer incomeId) {
        ProductsResponse response = new ProductsResponse();
        List<String> list = new ProductsManager().getProductsSuggestions(new ProductsRequest(ageId, incomeId, isStudent));
        if (!list.isEmpty()) {
            response.setSuccess(true);
            response.setProducts(list);
        }
        return response;
    }
}
