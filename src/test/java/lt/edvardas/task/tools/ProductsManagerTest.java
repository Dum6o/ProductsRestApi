package lt.edvardas.task.tools;

import lt.edvardas.task.constants.Products;
import lt.edvardas.task.model.requests.ProductsRequest;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ProductsManagerTest {

    private ProductsManager manager;

    @Before
    public void setUp() {
        manager = new ProductsManager();
    }

    @Test
    public void getProductsSuggestions() {
        testEmptyRequest();
        testJunior();
        testSenior();
        testStudent();
        testNoneIncome();
        testSmallIncome();
        testMidIncome();
        testLargeIncome();
    }

    private void testEmptyRequest() {
        ProductsRequest request = new ProductsRequest();
        assertTrue(manager.getProductsSuggestions(request).isEmpty());

        request.setAgeId(1);
        assertTrue(manager.getProductsSuggestions(request).isEmpty());

        request.setAgeId(null);
        request.setIncomeId(1);
        assertTrue(manager.getProductsSuggestions(request).isEmpty());
    }

    private void testJunior() {
        List<String> list = getProductsList(1,1);

        assertTrue(!list.isEmpty());
        assertEquals(Products.JUNIOR_ACCOUNT, list.get(0));
    }

    private void testSenior() {
        List<String> list = getProductsList(3,1);

        assertEquals(3, list.size());
        assertTrue(list.contains(Products.SIMPLE_ACCOUNT));
        assertTrue(list.contains(Products.DEBIT_CARD));
        assertTrue(list.contains(Products.SENIOR_ACCOUNT));
    }

    private void testStudent() {
        List<String> list = getProductsList(2,1, true);

        assertEquals(3, list.size());
        assertTrue(list.contains(Products.SIMPLE_ACCOUNT));
        assertTrue(list.contains(Products.DEBIT_CARD));
        assertTrue(list.contains(Products.STUDENT_ACCOUNT));
    }

    private void testNoneIncome() {
        List<String> list = getProductsList(2,1);

        assertEquals(2, list.size());
        assertTrue(list.contains(Products.SIMPLE_ACCOUNT));
        assertTrue(list.contains(Products.DEBIT_CARD));
    }

    private void testSmallIncome() {
        List<String> list = getProductsList(2,2);

        assertEquals(2, list.size());
        assertTrue(list.contains(Products.SIMPLE_ACCOUNT));
        assertTrue(list.contains(Products.DEBIT_CARD));
    }

    private void testMidIncome() {
        List<String> list = getProductsList(2,3);

        assertEquals(3, list.size());
        assertTrue(list.contains(Products.SIMPLE_ACCOUNT));
        assertTrue(list.contains(Products.DEBIT_CARD));
        assertTrue(list.contains(Products.CREDIT_CARD));
    }

    private void testLargeIncome() {
        List<String> list = getProductsList(2,4);

        assertEquals(5, list.size());
        assertTrue(list.contains(Products.SIMPLE_ACCOUNT));
        assertTrue(list.contains(Products.DEBIT_CARD));
        assertTrue(list.contains(Products.CREDIT_CARD));
        assertTrue(list.contains(Products.PLUS_ACCOUNT));
        assertTrue(list.contains(Products.GOLD_CREDIT_CARD));
    }

    private List<String> getProductsList(Integer ageId, Integer incomeId) {
        return getProductsList(ageId, incomeId, false);
    }

    private List<String> getProductsList(Integer ageId, Integer incomeId, Boolean isStudent) {
        ProductsRequest request = new ProductsRequest();
        request.setAgeId(ageId);
        request.setIncomeId(incomeId);
        request.setStudent(isStudent);
        return manager.getProductsSuggestions(request);
    }
}