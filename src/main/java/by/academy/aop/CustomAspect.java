package by.academy.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;



@Aspect
@Component
public class CustomAspect {
    private static final Logger log = Logger.getLogger(CustomAspect.class);

    @Pointcut("execution(* by.academy.repository.jdbctemplate.JdbcTemplateUserRepository.*(..))")
    public void aroundRepositoryPointcut() {
    }

    @Around("aroundRepositoryPointcut()")
    public Object logAroundMethods(ProceedingJoinPoint joinPoint) throws Throwable {

        System.out.println(joinPoint.getArgs().length);

        log.info("Method " + joinPoint.getSignature().getName() + " start");

        Object proceed = joinPoint.proceed();

        log.info("Method " + joinPoint.getSignature().getName() + " finished");
        return proceed;
    }
}
