package com.yr.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
/**
 * 
 * @author zxy
 * 
 * @时间:2017年7月4日下午8:10:06
 * 
 * @Order(1) // 执行优先级
 * @Aspect //标识这个类是一个AOP切面类(也就是我们实现的代理类)
 * @Component // 万能注解
 */
@Aspect
@Component
public class LoggingAspect {

    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码. 使用 @Pointcut 来声明切入点表达式.
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
     * 
     * 如果是这个类里面的方法调用，就会先进入到我们的这个AOP类来
     */
    //这里只是一个规则　
    @Pointcut("execution(* com.yr..*.*(..))")
    public void declareJointPointExpression() {
    }
    
    /**
     * @Before 表示前置通知 execution(修饰符 返回类型(com.yr.spt.aop.*.*(int, int)) *表示任意类型)
     * @param joinPoint
     */
    @Before("declareJointPointExpression()")//切入点表达式,两种注解都可
    // @Before("execution(public int com.yr.spt.aop.ArithmeticCalculator.*(int,int))")//非切入点注解
    public void beforeMethod(JoinPoint joinPoint) {
           System.out.println("前1");
    }


    /**
     * @After 表示后置通知: 在方法执行之后(无论是否抛异常)执行的代码. 注:在后置方法中还不能访问目标方法的结果
     * @param joinPoint
     */
    @After("declareJointPointExpression()")
    // @After("execution(* com.yr.spt.aop.ArithmeticCalculator.*(..))")
    public void afterMethod(JoinPoint joinPoint) {
       System.out.println("后1");
    }

    /**
     * @AfterReturning 表示返回通知,在方法法正常结束受执行的代码 返回通知是可以访问到方法的返回值的!
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "declareJointPointExpression()", returning = "result")
    // @AfterReturning(value = "execution(*
    // com.yr.spt.aop.ArithmeticCalculator.*(..))", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
       System.out.println("返回1");
    }
    
    

    /**
     * @AfterThrowing 表示异常通知,在目标方法出现异常时会执行的代码. 可以访问到异常对象; 且可以指定在出现特定异常时再执行通知代码
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "declareJointPointExpression()", throwing = "e")
    // @AfterThrowing(value = "execution(*
    // com.yr.spt.aop.ArithmeticCalculator.*(..))", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("异常1");
    }

    
    /**
     * @Around 表示环绕通知, 环绕通知需要携带 ProceedingJoinPoint 类型的参数. 环绕通知类似于动态代理的全过程:
     *         ProceedingJoinPoint 类型的参数可以决定是否执行目标方法. 且环绕通知必须有返回值, 返回值即为目标方法的返回值
     * @param pjd
     * @return  
     * 在前方法执行前执行，在后方法执行后执行
     */
     //@Around("declareJointPointExpression()")
     //@Around("execution(* com.yr.spt.aop.ArithmeticCalculator.*(..))")
    public Object aroundMethod(ProceedingJoinPoint pjd) {
        Object result = null;
        String methodName = pjd.getSignature().getName();
        try {
            // 前置通知
            System.out.println("环绕11");
            // 执行目标方法
            result = pjd.proceed();
            // 返回通知
        } catch (Throwable e) {
        }
        // 后置通知
        System.out.println("环绕1111");
        return result;
    }

}
