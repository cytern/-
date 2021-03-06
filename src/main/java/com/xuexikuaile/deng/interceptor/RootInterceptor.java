package com.xuexikuaile.deng.interceptor;

import com.xuexikuaile.deng.dao.STokenDao;
import com.xuexikuaile.deng.pojo.SToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: cytern
 * @Date: 2020/6/10 16:43
 */
@Component
public class RootInterceptor implements HandlerInterceptor {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private STokenDao sTokenDao;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }else {
            try {
                String token1 = request.getHeader("User-Token");
                if (token1 != null){
                    SToken sToken = sTokenDao.getTokenByToken(token1);
                    if ( sToken.getUserType().equals("root")){
                        logger.info("用户"+sToken.getSTokenId() + " " + "权限为" + sToken.getUserType() + " " + "访问" + "root级别内容");
                        return true;
                    }
                }
            } catch (Exception e) {
            }
            request.getRequestDispatcher("/error/needLogin").forward(request,response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
