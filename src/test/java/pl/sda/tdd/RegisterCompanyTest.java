package pl.sda.tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

final class RegisterCompanyTest {

    @ParameterizedTest
    @CsvSource({
        "Test S.A.,PL1020303031,test@test.com",
        "Xyz S.A.,PL1020303099,xyz@test.com"
    })
    void shouldRegisterVerifiedCompany(String name, String vat, String email) {
        // given
        final var companyDao = new InMemoryCompanyDao();
        final var companyRegistration = new CompanyRegistration(companyDao);
        final var registrationForm = new CompanyRegistrationForm(name, vat, email, true);

        // when
        final var registeredCompany = companyRegistration.register(registrationForm);

        // then
        assertThat(registeredCompany).isEqualTo(new RegisteredCompany(name, vat, email));
        assertThat(companyDao.existsByVat(vat)).isTrue();
    }
}
