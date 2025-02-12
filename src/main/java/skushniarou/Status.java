package skushniarou;

public enum Status {
    INITIAL("INITIAL"),
    IN_PROGRESS("IN_PROGRESS"),
    END("END"),
    WIN("WIN"),
    DRAW("DRAW"),
    LOSE("LOSE");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}
