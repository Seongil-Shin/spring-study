package hello.typeconverter.formatter;

import static org.junit.jupiter.api.Assertions.*;
import java.text.ParseException;
import java.util.Locale;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * MyNumberFormatterTest
 */
class MyNumberFormatterTest {

	MyNumberFormatter formatter = new MyNumberFormatter();

	@Test
	void testParse() throws ParseException {
		//given
		Number result = formatter.parse("1,000", Locale.KOREA);

		//then
		Assertions.assertThat(result).isEqualTo(1000L);
	}

	@Test
	void testPrint() {
		//given
		String result = formatter.print(1000, Locale.KOREA);

		//assert & verify
		Assertions.assertThat(result).isEqualTo("1,000");
	}
}
