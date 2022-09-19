package hello.advanced.aop.v1;


import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTranceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTranceV1 trace;

    public void save(String itemId) {

        TraceStatus status = null;
        try {
            status = trace.begin("OrderRepository.save()");

            //
            if (itemId.equals("ex")) {
                throw new IllegalStateException("예외발생");
            }
            sleep(1000);

            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e; //예외를 꼭 다시 던져주어야 한다.
        }

    }

    private void sleep(int millis) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
