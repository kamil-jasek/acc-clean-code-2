package pl.sda.tdd;

final class VatNumber {

    private String vatNumber;

    private VatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public static VatNumber from(String vatNumber) {
        return new VatNumber(vatNumber);
    }

    public String getValue() {
        return vatNumber;
    }
}
