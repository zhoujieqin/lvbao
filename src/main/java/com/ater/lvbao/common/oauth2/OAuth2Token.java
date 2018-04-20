package com.ater.lvbao.common.oauth2;


import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author
 * @date 2017-04-01
 */
public class OAuth2Token implements AuthenticationToken {
    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
