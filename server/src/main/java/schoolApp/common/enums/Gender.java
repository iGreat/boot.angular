package schoolApp.common.enums;

public enum Gender {
    Male(1), Female(2);

    private int value;

    Gender(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
