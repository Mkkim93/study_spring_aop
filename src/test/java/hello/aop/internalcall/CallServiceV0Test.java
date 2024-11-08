package hello.aop.internalcall;

import hello.aop.internalcall.aop.CallLogAspect;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

@Slf4j
@Import(CallLogAspect.class)
@SpringBootTest
class CallServiceV0Test {

    @Autowired
    CallServiceV0 callServiceV0; // proxy

    @Test
    void external() {
        // external 메서드 내부에 있는 internal 메서드는 aop가 적용 되지 않는다.
        // spring aop 의 한계.. (외부에서 메서드를 호출할 수 있도록 방법 수정)
        callServiceV0.external();
    }

    @Test // 외부에서 메서드를 직접 호출하여 aop 를 거치도록 한다.
    void internal() {
        callServiceV0.internal();
    }
}