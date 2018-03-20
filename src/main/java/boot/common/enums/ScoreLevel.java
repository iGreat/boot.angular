package boot.common.enums;

public enum ScoreLevel {
    F(13), DL(12), D(11), DH(10), CL(9), C(8), CH(7), BL(6), B(5), BH(4), AL(3), A(2), AH(1);

    private int result;

    ScoreLevel(int result) {
        this.result = result;
    }

    public int getResult() {
        return result;
    }
}
