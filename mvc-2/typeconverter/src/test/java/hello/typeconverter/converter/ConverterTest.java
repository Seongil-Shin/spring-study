package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * ConverterTest
 */
public class ConverterTest {
	@Test
	void stringToInteger() {
		StringToIntegerConverter converter = new StringToIntegerConverter();
		Integer result = converter.convert("10");
		Assertions.assertThat(result).isEqualTo(10);
	}

	@Test
	void IntegerToString() {
		IntegerToStringConverter converter = new IntegerToStringConverter();
		String result = converter.convert(10);
		Assertions.assertThat(result).isEqualTo("10");
	}

	@Test
	void stringToIpPort() {
		StringToIpPortConverter converter = new StringToIpPortConverter();
		IpPort result = converter.convert("127.0.0.1:8080");
		IpPort source = new IpPort("127.0.0.1", 8080);
		Assertions.assertThat(result).isEqualTo(source);
	}

	@Test
	void ipPortToString() {
		IpPortToStringConverter converter = new IpPortToStringConverter();
		String result = converter.convert(new IpPort("127.0.0.1", 8080));
		Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
	}
}
