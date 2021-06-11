package pl.sda.tdd;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

final class VatNumberTest {

    @ParameterizedTest
    @ValueSource(strings = {"PL1029394093", "PL3029393943"})
    void shouldCreateValidVatNumber(String vat) {
        // when - method execution
        final var vatNumber = VatNumber.from(vat);
        // then - assertions
        assertThat(vatNumber.getValue()).isEqualTo(vat);
    }
}
