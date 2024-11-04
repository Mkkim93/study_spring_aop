package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Slf4j
@Aspect // aop 설정을 위한 애노테이션 (스프링빈에 등록을 해주어야 한다)
public class AspectV1 {

    @Around("execution(* hello.aop.order..*(..))")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[log] {}", joinPoint.getSignature()); // joinPoint 시그니쳐 : 해당 메서드의 정보를 객체로 반환할 수 있다.
        return joinPoint.proceed();
    }
}
