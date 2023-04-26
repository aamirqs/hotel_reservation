package com.example.hotelmonitoring.data.Object;

import java.sql.*;
import java.util.*;

public class EmpRole {
    private String roleCode;
    private String roleTitle;
    private String roleDesc;

    public EmpRole(String roleCode, String roleTitle, String roleDesc) {
        this.roleCode = roleCode;
        this.roleTitle = roleTitle;
        this.roleDesc = roleDesc;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    public String getRoleTitle() {
        return roleTitle;
    }

    public void setRoleTitle(String roleTitle) {
        this.roleTitle = roleTitle;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}

