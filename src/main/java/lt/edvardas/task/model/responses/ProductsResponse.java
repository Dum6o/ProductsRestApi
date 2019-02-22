package lt.edvardas.task.model.responses;

import java.util.List;

public class ProductsResponse {

    private Boolean success = false;
    private List<String> products;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = (success != null)? success : false;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }
}
