package lt.edvardas.task.types;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AgeTypeTest {

    @Test
    public void getKey() {
        assertTrue(AgeType.CHILD.getKey() < 2);
        assertTrue(AgeType.ADULT.getKey() < 3);
        assertTrue(AgeType.SENIOR.getKey() < 4);
    }

    @Test
    public void getValue() {
        assertTrue(AgeType.CHILD.getValue() > AgeType.noneConst && AgeType.CHILD.getValue() < AgeType.adultConst);
        assertTrue(AgeType.ADULT.getValue() > AgeType.childConst && AgeType.ADULT.getValue() < AgeType.seniorConst);
        assertTrue(AgeType.SENIOR.getValue() > AgeType.seniorConst);
    }

    @Test
    public void valueOf() {
        assertEquals(AgeType.CHILD, AgeType.valueOf(1));
        assertEquals(AgeType.ADULT, AgeType.valueOf(2));
        assertEquals(AgeType.SENIOR, AgeType.valueOf(3));
    }
}