package lt.edvardas.task.tools;

import lt.edvardas.task.constants.Products;
import lt.edvardas.task.model.requests.ProductsRequest;
import lt.edvardas.task.types.AgeType;
import lt.edvardas.task.types.IncomeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductsManager {

    public List<String> getProductsSuggestions(ProductsRequest request) {
        Integer age = getAgeValue(request.getAgeId());
        Integer income = getIncomeValue(request.getIncomeId());
        if (age == null || income == null) {
            return Collections.emptyList();
        }
        List<String> list = new ArrayList<>();
        if (age > AgeType.childConst) {
            list.add(Products.SIMPLE_ACCOUNT);
            list.add(Products.DEBIT_CARD);
            if (request.getStudent()) {
                list.add(Products.STUDENT_ACCOUNT);
            }
            if (income > IncomeType.smallConst) {
                list.add(Products.CREDIT_CARD);
            }
            if (income > IncomeType.midConst) {
                list.add(Products.PLUS_ACCOUNT);
                list.add(Products.GOLD_CREDIT_CARD);
            }
        } else {
            list.add(Products.JUNIOR_ACCOUNT);
        }
        if (age > AgeType.seniorConst) {
            list.add(Products.SENIOR_ACCOUNT);
        }
        return list;
    }

    private Integer getAgeValue(Integer id) {
        return (AgeType.valueOf(id) != null) ?
                AgeType.valueOf(id).getValue() : null;
    }

    private Integer getIncomeValue(Integer id) {
        return (IncomeType.valueOf(id) != null) ?
                IncomeType.valueOf(id).getValue() : null;
    }
}
