package hello.aop.order.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;

@Slf4j
@Aspect // aop 설정을 위한 애노테이션 (스프링빈에 등록을 해주어야 한다)
public class AspectV5Order {

    @Aspect
    @Order(1)
    public static class LogAspect {
        @Around("hello.aop.order.aop.PointCuts.allOrder()")
        public Object doLog(ProceedingJoinPoint joinPoint) throws Throwable{
            log.info("[log] {}", joinPoint.getSignature()); // joinPoint 시그니쳐 : 해당 메서드의 정보를 객체로 반환할 수 있다.
            return joinPoint.proceed();
        }
    }

    @Aspect
    @Order(2)
    public static class TxAspect {
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

}
