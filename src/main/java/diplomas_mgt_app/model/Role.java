package diplomas_mgt_app.model;

public enum Role {
    Student("Student"),
    Professor("Professor");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

