package pl.sda.tdd;

final class Company {

    private String name;
    private String email;
    private String vat;
    private boolean verified;

    public Company(String name, String email, String vat, boolean verified) {
        this.name = name;
        this.email = email;
        this.vat = vat;
        this.verified = verified;
    }

    public String getVatNumber() {
        return vat;
    }
}
