package pl.sda.cleancode;

import static java.util.Objects.requireNonNull;

import java.time.LocalDateTime;
import java.util.Objects;

final class CustomerVerification {

    private final boolean verified;
    private final LocalDateTime verificationTime;
    private final CustomerVerifier verifier;

    private CustomerVerification() {
        this.verified = false;
        this.verificationTime = null;
        this.verifier = null;
    }

    private CustomerVerification(CustomerVerifier verifier) {
        this.verified = true;
        this.verificationTime = LocalDateTime.now();
        this.verifier = requireNonNull(verifier);
    }

    static CustomerVerification notVerified() {
        return new CustomerVerification();
    }

    static CustomerVerification verifiedBy(CustomerVerifier verifier) {
        return new CustomerVerification(verifier);
    }

    public boolean isVerified() {
        return verified;
    }

    public LocalDateTime getVerificationTime() {
        return verificationTime;
    }

    public CustomerVerifier getVerifier() {
        return verifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerVerification that = (CustomerVerification) o;
        return verified == that.verified && Objects.equals(verificationTime, that.verificationTime)
            && verifier == that.verifier;
    }

    @Override
    public int hashCode() {
        return Objects.hash(verified, verificationTime, verifier);
    }
}
