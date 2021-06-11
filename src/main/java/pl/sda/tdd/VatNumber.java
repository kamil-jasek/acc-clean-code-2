package pl.sda.tdd;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

final class VatNumber {

    private final String vatNumber;

    private VatNumber(String vatNumber) {
        this.vatNumber = requireNonNull(vatNumber, "Vat number is null");
        verifyVat();
    }

    private void verifyVat() {
        if (!this.vatNumber.matches("[A-Z]{2}\\d{10}")) {
            throw new IllegalArgumentException("Invalid vat number: " + this.vatNumber);
        }
    }

    public static VatNumber from(String vatNumber) {
        return new VatNumber(vatNumber);
    }

    public String getValue() {
        return vatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VatNumber vatNumber1 = (VatNumber) o;
        return vatNumber.equals(vatNumber1.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatNumber);
    }
}
