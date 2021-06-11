package pl.sda.tdd;

import java.util.Objects;

final class RegisteredCompany {

    private String name;
    private String vat;
    private String email;

    public RegisteredCompany(String name, String vat, String email) {
        this.name = name;
        this.vat = vat;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RegisteredCompany that = (RegisteredCompany) o;
        return Objects.equals(name, that.name) && Objects.equals(vat, that.vat) && Objects
            .equals(email, that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vat, email);
    }
}
