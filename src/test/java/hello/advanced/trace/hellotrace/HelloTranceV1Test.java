package hello.advanced.trace.hellotrace;

import hello.advanced.trace.TraceStatus;
import org.junit.jupiter.api.Test;

class HelloTranceV1Test {

    @Test
    void begin_end(){
        HelloTranceV1 trace = new HelloTranceV1();

        TraceStatus status = trace.begin("begin ");
        trace.end(status);
    }

    @Test
    void begin_exception(){
        HelloTranceV1 trace = new HelloTranceV1();

        TraceStatus status = trace.begin("begin ");
        trace.exception(status, new IllegalStateException());
    }

}