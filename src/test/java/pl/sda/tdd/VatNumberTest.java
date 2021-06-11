package pl.sda.tdd;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.Test;
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

    @ParameterizedTest
    @ValueSource(strings = {"0302203033", "P2030303033", "PL293939930", "we9303202022"})
    void shouldNotCreateInvalidVatNumber(String vat) {
        assertThatCode(() -> VatNumber.from(vat))
            .hasMessage("Invalid vat number: " + vat);
    }

    @Test
    void shouldNotCreateNullVatNumber() {
        assertThatCode(() -> VatNumber.from(null))
            .hasMessage("Vat number is null");
    }

    @Test
    void shouldCompareVatNumbers() {
        // given
        final var firstVat = VatNumber.from("PL1029393091");
        final var secondVat = VatNumber.from("PL1029393092");
        final var thirdVat = VatNumber.from("PL1029393091");

        // then
        assertThat(firstVat).isNotEqualTo(secondVat);
        assertThat(firstVat).isEqualTo(thirdVat);
        assertThat(secondVat).isNotEqualTo(thirdVat);
    }
}
