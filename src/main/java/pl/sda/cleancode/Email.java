package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

final class Email {

    private final String value;

    Email(String value) {
        this.value = requireNonNull(value);
        // TODO - add email verification
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Email email = (Email) o;
        return value.equals(email.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
