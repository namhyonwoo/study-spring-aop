package hello.advanced.trace;

//로그 종료시 사용
public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs;
    private String message; //시작 종료시 사용 메시지

    public TraceStatus(TraceId traceId, Long startTimeMs, String message) {
        this.traceId = traceId;
        this.startTimeMs = startTimeMs;
        this.message = message;
    }

    public TraceId getTraceId() {
        return traceId;
    }

    public Long getStartTimeMs() {
        return startTimeMs;
    }

    public String getMessage() {
        return message;
    }
}
