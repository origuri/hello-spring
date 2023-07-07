package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TimeTraceAop {
    // hello 패키지안에 모든 것을 시간 측정하겠다는 의미
    @Around("execution(* hello.hellospring..*(..))")
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();
        System.out.println("start : "+joinPoint.toString());
        System.out.println("start : "+start);
        try {
            return joinPoint.proceed();
        }finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish -start;
            System.out.println("end : "+joinPoint.toString()+" "+timeMs+"ms");
            System.out.println("end : "+finish+" "+timeMs);
        }

    }
}
