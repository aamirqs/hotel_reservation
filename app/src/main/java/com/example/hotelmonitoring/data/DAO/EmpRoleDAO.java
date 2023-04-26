package com.example.hotelmonitoring.data.DAO;

import java.sql.*;
import java.util.*;
import com.example.hotelmonitoring.data.Object.EmpRole;

public class EmpRoleDAO {
    private Connection conn;

    public EmpRoleDAO(Connection conn) {
        this.conn = conn;
    }

    public List<EmpRole> getAllEmpRoles() throws SQLException {
        List<EmpRole> empRoles = new ArrayList<>();

        Statement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Emp_Role");

            while (rs.next()) {
                EmpRole empRole = new EmpRole(
                        rs.getString("Role_Code"),
                        rs.getString("Role_Title"),
                        rs.getString("Role_Desc")
                );

                empRoles.add(empRole);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }

        return empRoles;
    }

    public EmpRole getEmpRoleByCode(String roleCode) throws SQLException {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement("SELECT * FROM Emp_Role WHERE Role_Code = ?");
            stmt.setString(1, roleCode);
            rs = stmt.executeQuery();

            if (rs.next()) {
                EmpRole empRole = new EmpRole(
                        rs.getString("Role_Code"),
                        rs.getString("Role_Title"),
                        rs.getString("Role_Desc")
                );

                return empRole;
            } else {
                return null;
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
        }
    }

    public void addEmpRole(EmpRole empRole) throws SQLException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("INSERT INTO Emp_Role (Role_Code, Role_Title, Role_Desc) VALUES (?, ?, ?)");
            stmt.setString(1, empRole.getRoleCode());
            stmt.setString(2, empRole.getRoleTitle());
            stmt.setString(3, empRole.getRoleDesc());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public void updateEmpRole(EmpRole empRole) throws SQLException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("UPDATE Emp_Role SET Role_Title = ?, Role_Desc = ? WHERE Role_Code = ?");
            stmt.setString(1, empRole.getRoleTitle());
            stmt.setString(2, empRole.getRoleDesc());
            stmt.setString(3, empRole.getRoleCode());
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }

    public void deleteEmpRole(String roleCode) throws SQLException {
        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement("DELETE FROM Emp_Role WHERE Role_Code = ?");
            stmt.setString(1, roleCode);
            stmt.executeUpdate();
        } finally {
            if (stmt != null) stmt.close();
        }
    }
}

