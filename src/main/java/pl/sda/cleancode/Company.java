package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.util.Objects;
import pl.sda.cleancode.dto.RegisterCompanyForm;

final class Company extends Customer {

    private final Name name;
    private final Vat vat;

    Company(Email email, CustomerVerification verification, Name name, Vat vat) {
        super(email, verification);
        this.name = requireNonNull(name);
        this.vat = requireNonNull(vat);
    }

    static Company createFrom(RegisterCompanyForm form) {
        final var verification = form.isVerified()
            ? CustomerVerification.verifiedBy(CustomerVerifier.AUTO_EMAIL)
            : CustomerVerification.notVerified();
        return new Company(new Email(form.getEmail()),
            verification,
            new Name(form.getName()),
            new Vat(form.getVat()));
    }

    public Name getName() {
        return name;
    }

    public Vat getVat() {
        return vat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        if (!super.equals(o)) {
            return false;
        }
        Company company = (Company) o;
        return name.equals(company.name) && vat.equals(company.vat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, vat);
    }
}
