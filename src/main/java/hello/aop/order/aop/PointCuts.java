package hello.aop.order.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCuts {

    // hello.aop.order 의 패키지와 하위 패키지를 전부를 뜻한다
    @Pointcut("execution(* hello.aop.order..*(..))")
    public void allOrder() { // pointcut signature
    }


    @Pointcut("execution(* *..*Service.*(..))")
    public void allService(){}

    // allOrder 와 allService 조합
    @Pointcut("allOrder() && allService()")
    public void orderAndService() {

    }
}
