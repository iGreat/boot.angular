package boot.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum Gender {
    MALE(1, "male"),
    FEMALE(2, "female");

    private static Map<Integer, Gender> genders = new HashMap<>();

    static {
        genders.put(1, MALE);
        genders.put(2, FEMALE);
    }

    private final int value;
    private String text;

    Gender(int value, String text) {
        this.value = value;
        this.text = text;
    }

    @JsonCreator
    public static Gender castValue(@JsonProperty("value") Integer value) { //map gender class's property:value
        if (value == null)
            return null;

        return genders.get(value);
    }

    public int getValue() {
        return value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
