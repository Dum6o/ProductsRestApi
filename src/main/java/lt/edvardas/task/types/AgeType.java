package lt.edvardas.task.types;

import lt.edvardas.task.constants.AgeConstants;

import java.util.Arrays;

public enum AgeType implements AgeConstants {
    CHILD(1, 17),
    ADULT(2, 64),
    SENIOR(3,66)
    ;

    private Integer key;
    private Integer value;

    AgeType(Integer key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }

    public static AgeType valueOf(Integer key) {
        return Arrays.stream(values())
                .filter(type -> type.key.equals(key))
                .findAny()
                .orElse(null);
    }
}
