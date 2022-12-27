package hello.advanced.trace.logtrace;

import hello.advanced.trace.TraceStatus;

/**
 * LogTrace
 */
public interface LogTrace {
	TraceStatus begin(String message);

	void end(TraceStatus status);

	void exception(TraceStatus status, Exception e);
}
