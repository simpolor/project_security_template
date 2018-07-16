package com.simpolor.cms.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.simpolor.cms.security.domain.User;

public final class SecurityContext {

    private static final String ANONYMOUS_USER  = "anonymousUser";

    public static User getPrincipal() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && authentication.isAuthenticated()){
            // ignoring에 포함되지 않는 경우 무조건 인증을 통과하며,
            // "anonymousUser" 이름을 가진 권한을 가진다.
            if (!isAnonymousUser(authentication.getName())){
                return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
        }

        return null ;
    }

    public static boolean isAuthenticated(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication != null && !isAnonymousUser(authentication.getName()) ){
            return authentication.isAuthenticated();
        }

        return false;
    }

    public static boolean isAnonymousUser(String name){
        return ANONYMOUS_USER.equals(name);
    }
}
