package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect // aop 설정을 위한 애노테이션 (스프링빈에 등록을 해주어야 한다)
public class AspectV4Pointcut {

    @Around("hello.aop.order.aop.PointCuts.allOrder()")
    public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
        log.info("[log] {}", joinPoint.getSignature()); // joinPoint 시그니쳐 : 해당 메서드의 정보를 객체로 반환할 수 있다.
        return joinPoint.proceed();
    }

    // hello.aop.order 패키지와 하위 패키지 이면서 클래스 이름 패턴이 *Service
    @Around("hello.aop.order.aop.PointCuts.orderAndService()")
    public Object doTransaction(ProceedingJoinPoint joinPoint) throws Throwable{

        try {
            log.info("[트랜잭션 시작] {}", joinPoint.getSignature());
            Object result = joinPoint.proceed();
            log.info("[트랜잭션 커밋] {}", joinPoint.getSignature());
            return result;
        } catch (Exception e) {
            log.info("[트랜잭션 롤백] {}", joinPoint.getSignature());
            throw e;
        } finally {
            log.info("[리소스 릴리즈] {}", joinPoint.getSignature());
        }
    }
}
