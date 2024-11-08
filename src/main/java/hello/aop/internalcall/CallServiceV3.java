package hello.aop.internalcall;

import hello.aop.internalcall.aop.InternalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Component;

/**
 * 구조를 분리한다.
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class CallServiceV3 {

    // 내부 호출 되었던 메서드를 별도의 클래스로 분리해서 외부에서 호출하도록 구조를 변경한다
    private final InternalService internalService;

    public void external() {
        log.info("call external");
        internalService.internal();
    }
}
