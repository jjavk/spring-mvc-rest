package com.github.rest.aspect;

import com.github.rest.annotation.IgnoreSecurity;
import com.github.rest.authorization.Constants;
import com.github.rest.authorization.TokenManager;
import com.github.rest.exception.TokenException;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import java.lang.reflect.Method;

/**
 * Created by jiabin on 2018/5/13.
 */
@Component
@Aspect
public class SecurityAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenManager tokenManager;

    @Around("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {

        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        logger.debug("methodSignature : " + methodSignature);
        Method method = methodSignature.getMethod();
        logger.debug("Method : " + method.getName() + " : "
                + method.isAnnotationPresent(IgnoreSecurity.class));

        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
            return pjp.proceed();
        }

        String token = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest().getHeader(
                Constants.DEFAULT_TOKEN_NAME);

        if (!tokenManager.checkToken(token)) {
            String message = String.format("token [%s] is invalid", token);
            logger.debug("message : " + message);
            throw new TokenException(message);
        }

        return pjp.proceed();
    }
}
