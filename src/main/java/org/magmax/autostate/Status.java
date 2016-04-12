package org.magmax.autostate;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Status {
    private static Connection conn;
    private final String SQL_GET_PROJECT = "select id from project where name=?";

    public Status (String connectionString) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        conn = DriverManager.getConnection(connectionString);
    }

    public void addStatus (String project, String status) throws SQLException {
        Integer projectId = getProject(project);
    }

    public Integer getProject (String project) throws SQLException{
        try (PreparedStatement ps = conn.prepareStatement(SQL_GET_PROJECT);) {
            ps.setString(1, project);
            try (ResultSet rs = ps.executeQuery();) {
                if (rs.next())
                    return rs.getInt("id");
                return null;
            }
        }
    }
}
