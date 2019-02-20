package lt.edvardas.task.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping("/")
    public boolean checkConnection() {
        return true;
    }

    @RequestMapping(path = "/products", method = RequestMethod.GET, produces = "application/json")
    public List<String> getRecommendedProducts() {

        return null;
    }
}
