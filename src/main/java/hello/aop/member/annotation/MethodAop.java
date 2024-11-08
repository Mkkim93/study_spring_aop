package hello.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME) // 애플리케이션이 실행될때까지 애노테이션이 동작할 수 있게 해주는 설정
public @interface MethodAop {
    String value(); // 외부에서 구현할 때 값을 넣을 수 있게 됨
}
