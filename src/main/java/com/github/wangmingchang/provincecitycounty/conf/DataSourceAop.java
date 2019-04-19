package com.github.wangmingchang.provincecitycounty.conf;

import com.github.wangmingchang.provincecitycounty.annotation.Master;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @auther wangmingchang
 * @date 2019/4/18 15:50
 */
@Aspect
@Component
public class DataSourceAop {

    private static final Logger log = LoggerFactory.getLogger(DataSourceAop.class);

//    @Pointcut("!@annotation(com.cjs.example.annotation.Master) " +
//            "&& (execution(* com.github.wangmingchang.provincecitycounty.dao.*.select*(..)) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.get*(..)) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.query*(..))" +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.find*(..)))")
//    public void readPointcut() {
//
//    }
//
//    @Pointcut("@annotation(com.cjs.example.annotation.Master) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.insert*(..)) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.add*(..)) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.update*(..)) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.edit*(..)) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.delete*(..)) " +
//            "|| execution(* com.github.wangmingchang.provincecitycounty.dao.*.remove*(..))")
//    public void writePointcut() {
//
//    }
//
//    @Before("readPointcut()")
//    public void read() {
//        DBContextHolder.slave();
//    }
//
//    @Before("writePointcut()")
//    public void write() {
//        DBContextHolder.master();
//    }
    
    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
    @Before("execution(* com.github.wangmingchang.provincecitycounty.dao.*.*(..))")
    public void before(JoinPoint jp) {
        String methodName = jp.getSignature().getName();
        Class<?> claz = jp.getSignature().getDeclaringType();
        Method[] methods = claz.getDeclaredMethods();
        boolean isMaster = false;
        for (Method method : methods){
            String name = method.getName();
            boolean flag = method.isAnnotationPresent((Master.class));
            if(methodName.equals(name)){
                if(flag){
                    isMaster = true;
                }
                break;
            }
        }
        log.info("当前Dao方法：{}",methodName);
        if (!isMaster && StringUtils.startsWithAny(methodName, "get", "select", "find", "query")) {
            DBContextHolder.slave();
        }else {
            DBContextHolder.master();
        }
    }
    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.github.wangmingchang.provincecitycounty.service.impl.*.*(..))")
//    public void beforeService(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//        Class<?> claz = jp.getSignature().getDeclaringType();
//        Method[] methods = claz.getDeclaredMethods();
//        boolean isMaster = false;
//        for (Method method : methods){
//            String name = method.getName();
//            boolean flag = method.isAnnotationPresent((Transactional.class));
//            if(methodName.equals(name)){
//                if(flag){
//                    isMaster = true;
//                }
//                break;
//            }
//        }
//        log.info("当前Service方法：{}",methodName);
//        if (!isMaster && StringUtils.startsWithAny(methodName, "get", "select", "find", "query")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}
