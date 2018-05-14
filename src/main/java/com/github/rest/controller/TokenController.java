package com.github.rest.controller;

import com.github.rest.annotation.IgnoreSecurity;
import com.github.rest.authorization.Constants;
import com.github.rest.authorization.TokenManager;
import com.github.rest.exception.TokenException;
import com.github.rest.response.ErrorCode;
import com.github.rest.response.Response;
import com.github.rest.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created By jiabin on 18-5-14.
 */
@RestController
@RequestMapping("/tokens")
public class TokenController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    TokenManager tokenManager;
    @Autowired
    UserService userService;

    /**
     * 登录处理
     * @param uname
     * @param passwd
     * @param response
     * @return
     */
    @IgnoreSecurity
    @PostMapping()
    public Response login(@RequestParam("uname") String uname,
                          @RequestParam("passwd") String passwd, HttpServletResponse response) {
        boolean flag = userService.login(uname, passwd);
        if (flag) {
            String token = tokenManager.createToken(uname);
            logger.debug("**** Generate Token **** : " + token);
            Cookie cookie = new Cookie(Constants.DEFAULT_TOKEN_NAME, token);
            logger.debug("Write Token to Cookie and return to the Client : " + cookie.toString());
            response.addCookie(cookie);
            return Response.success();
        }
        return Response.fail(ErrorCode.LOGIN_ERROR);
    }

    /**
     * 登出处理
     * @param request
     * @return
     */
    @IgnoreSecurity
    @DeleteMapping
    public Response logout(HttpServletRequest request) {
        String token = request.getHeader(Constants.DEFAULT_TOKEN_NAME);
        tokenManager.deleteToken(token);
        logger.debug("Logout Success...");
        return Response.success();
    }
}
