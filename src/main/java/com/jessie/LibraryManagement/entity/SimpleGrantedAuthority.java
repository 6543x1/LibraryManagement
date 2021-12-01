package com.jessie.LibraryManagement.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.util.Assert;

public class SimpleGrantedAuthority implements GrantedAuthority {
    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private final String role;

    // 在构造方法中，SimpleGrantedAuthority 将角色的字符串表示保存进了 role 字段中
    // 作为一种简单的角色表示形式
    public SimpleGrantedAuthority(String role) {
        Assert.hasText(role, "A granted authority textual representation is required");
        this.role = role;
    }

    // 在 getAuthority() 方法中，SimpleGrantedAuthority 不对 role 进行处理直接将 role 作为角色返回
    @Override
    public String getAuthority() {
        return role;
    }

}
