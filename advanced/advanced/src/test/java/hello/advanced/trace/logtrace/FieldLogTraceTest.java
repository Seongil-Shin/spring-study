package hello.advanced.trace.logtrace;

import static org.junit.jupiter.api.Assertions.*;
import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.logtrace.FieldLogTrace;
import org.junit.jupiter.api.Test;

/**
 * FieldLogTraceTest
 *
 */
class FieldLogTraceTest {
	FieldLogTrace trace = new FieldLogTrace();


	@Test
	void begin_end_level2() {
		TraceStatus status1 = trace.begin("hello");
		TraceStatus status2 = trace.begin("hello2");
		trace.end(status2);
		trace.end(status1);
	}

	@Test
	void begin_exception_level2() {
		TraceStatus status1 = trace.begin("hello");
		TraceStatus status2 = trace.begin("hello2");
		trace.exception(status2, new IllegalStateException("예외 발생"));
		trace.exception(status1, new IllegalStateException("예외 발생"));
	}
}
