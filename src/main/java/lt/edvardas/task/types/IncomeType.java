package lt.edvardas.task.types;

import lt.edvardas.task.constants.IncomeConstants;

import java.util.Arrays;

public enum IncomeType implements IncomeConstants {
    NONE(1, 0),
    SMALL(2, 11999),
    MEDIUM(3, 39999),
    LARGE(4, 40002);

    private Integer key;
    private Integer value;

    IncomeType(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public static IncomeType valueOf(Integer key) {
        return Arrays.stream(values())
                .filter(type -> type.key.equals(key))
                .findAny()
                .orElse(null);
    }
}
