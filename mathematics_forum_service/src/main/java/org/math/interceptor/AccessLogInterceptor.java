package org.math.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.math.entity.AccessLog;
import org.math.utils.AddressIpUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Slf4j
public class AccessLogInterceptor implements HandlerInterceptor {
    /**
     * 请求开始时间
     */
    private static final String LOGGER_SEND_TIME = "SEND_TIME";
    /**
     * 请求日志实体标识
     */
    private static final String LOGGER_ACCESS_LOG = "ACCESS_LOG_ENTITY";

    public boolean preHandle(HttpServletRequest request) {
        AccessLog accessLog = new AccessLog();
        accessLog.setIp(AddressIpUtils.getIpAddress(request));
        accessLog.setUrl(request.getRequestURI());
        accessLog.setHttpMethod(request.getMethod());
        request.setAttribute(LOGGER_SEND_TIME, System.currentTimeMillis());
        request.setAttribute(LOGGER_ACCESS_LOG, accessLog);
        return true;
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception ex) {
        // 获取请求日志实体
        AccessLog accessLog = (AccessLog) request.getAttribute(LOGGER_ACCESS_LOG);
        // 获取请求错误码
        int status = response.getStatus();
        accessLog.setHttpStatus(status);
        long currentTime = System.currentTimeMillis();
        long sendTime = (long) request.getAttribute(LOGGER_SEND_TIME);
        // 设置请求时间差
        accessLog.setDuration((int) (currentTime - sendTime));
        accessLog.setCreateTime(LocalDateTime.now());
        log.info(accessLog.toString());
    }
}
