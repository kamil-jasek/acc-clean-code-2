package pl.sda.tdd;

final class CompanyRegistrationForm {

    private String name;
    private String vat;
    private String email;
    private boolean verified;

    public CompanyRegistrationForm(String name, String vat, String email, boolean verified) {
        this.name = name;
        this.vat = vat;
        this.email = email;
        this.verified = verified;
    }

    public String getName() {
        return name;
    }

    public String getVat() {
        return vat;
    }

    public String getEmail() {
        return email;
    }

    public boolean isVerified() {
        return verified;
    }
}
