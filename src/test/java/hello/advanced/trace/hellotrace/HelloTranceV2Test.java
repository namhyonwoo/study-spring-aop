package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTranceV2Test {

    @Test
    void begin_end(){
        HelloTranceV2 trace = new HelloTranceV2();

        TraceStatus status = trace.begin("hello ");

        TraceStatus status1 = trace.beginSync(status.getTraceId(), "hello2 ");
        trace.end(status1);

        trace.end(status);
    }

    @Test
    void begin_exception(){
        HelloTranceV2 trace = new HelloTranceV2();
        TraceStatus status = trace.begin("hello ");

        TraceStatus status1 = trace.beginSync(status.getTraceId(), "hello2 ");
        trace.exception(status1, new IllegalStateException());

        trace.exception(status, new IllegalStateException());
    }

}