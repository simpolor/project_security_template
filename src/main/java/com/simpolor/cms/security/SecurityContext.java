package com.simpolor.cms.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.simpolor.cms.security.domain.User;

public final class SecurityContext {

	private static Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    public static User getPrincipal() {
        if(authentication != null && authentication.isAuthenticated()){
            // ignoring에 포함되지 않는 경우 무조건 인증을 통과하며,
            // "anonymousUser" 이름을 가진 권한을 가진다.
            System.out.println("isAnonymousUser(authentication.getName() : "+isAnonymousUser(authentication.getName()));
            if (!isAnonymousUser(authentication.getName())){
                return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
        }
        return null ;
    }

    public static boolean isAuthenticated(){
        if(authentication != null && !isAnonymousUser(authentication.getName()) ){
            return authentication.isAuthenticated();
        }

        return false;
    }

    public static boolean isAnonymousUser(String name){
        return "anonymousUser".equals(name);
    }
}
