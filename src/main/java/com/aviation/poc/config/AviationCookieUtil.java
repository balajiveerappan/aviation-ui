package com.aviation.poc.config;



import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public final class AviationCookieUtil {
    public static void create(final HttpServletResponse httpServletResponse, final String name, final String value, final Boolean secure, final Integer maxAge, final String domain) {
        Cookie cookie = new Cookie(name, value);
        cookie.setSecure(secure);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(maxAge);
        cookie.setDomain(domain);
        cookie.setPath("/");
        httpServletResponse.addCookie(cookie);
    }

    public static void clear(final HttpServletResponse httpServletResponse, final String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }

    public static String getValue(final HttpServletRequest httpServletRequest, final String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
}