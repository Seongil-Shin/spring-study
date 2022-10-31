package hello.typeconverter.formatter;

import java.text.NumberFormat;
import java.util.Locale;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

/**
 * MyNumberFormatter
 */
@Slf4j
public class MyNumberFormatter implements Formatter<Number> {

	@Override
	public Number parse(String text, Locale locale) throws java.text.ParseException {
		log.info("text={}, locale={}", text, locale);
		NumberFormat format = NumberFormat.getInstance(locale);
		return format.parse(text);
	}

	@Override
	public String print(Number object, Locale locale) {
		log.info("object={}, locale={}", object, locale);
		String format = NumberFormat.getInstance(locale).format(object);
		return format;
	}
}
