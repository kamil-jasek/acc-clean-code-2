package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

abstract class Customer {

    private final UUID id;
    private final LocalDateTime createTime;
    private final Email email;
    private CustomerVerification verification;
    private Address address;

    protected Customer(Email email, CustomerVerification verification) {
        this.id = UUID.randomUUID();
        this.createTime = LocalDateTime.now();
        this.email = requireNonNull(email);
        this.verification = requireNonNull(verification);
    }

    public UUID getId() {
        return id;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public Email getEmail() {
        return email;
    }

    public CustomerVerification getVerification() {
        return verification;
    }

    public Address getAddress() {
        return address;
    }

    public void markVerified(CustomerVerifier verifier) {
        if (!verification.isVerified()) {
            verification = CustomerVerification.verifiedBy(verifier);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return id.equals(customer.id) && createTime.equals(customer.createTime) && email.equals(customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, email);
    }
}
