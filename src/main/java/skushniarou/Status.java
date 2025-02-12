package skushniarou;

public enum Status {
    INITIAL("INITIAL"),
    IN_PROGRESS("IN_PROGRESS"),
    END("END");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
