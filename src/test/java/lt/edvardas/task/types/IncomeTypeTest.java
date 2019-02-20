package lt.edvardas.task.types;

import org.junit.Test;

import static org.junit.Assert.*;

public class IncomeTypeTest {

    @Test
    public void getKey() {
        assertTrue(IncomeType.NONE.getKey() > 0);
        assertTrue(IncomeType.SMALL.getKey() > 1);
        assertTrue(IncomeType.MEDIUM.getKey() > 2);
        assertTrue(IncomeType.LARGE.getKey() > 3);
    }

    @Test
    public void getValue() {
        assertTrue(IncomeType.NONE.getValue() < 1);
        assertTrue(IncomeType.SMALL.getValue() < IncomeType.smallConst &&
                IncomeType.SMALL.getValue() > IncomeType.noneConst);
        assertTrue(IncomeType.MEDIUM.getValue() < IncomeType.midConst &&
                IncomeType.MEDIUM.getValue() > IncomeType.smallConst);
        assertTrue(IncomeType.LARGE.getValue() > IncomeType.midConst);
    }

    @Test
    public void valueOf() {
        assertEquals(IncomeType.NONE, IncomeType.valueOf(1));
        assertEquals(IncomeType.SMALL, IncomeType.valueOf(2));
        assertEquals(IncomeType.MEDIUM, IncomeType.valueOf(3));
        assertEquals(IncomeType.LARGE, IncomeType.valueOf(4));
    }
}