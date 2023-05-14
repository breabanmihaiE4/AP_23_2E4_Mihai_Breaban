package org.example;

import java.sql.SQLException;

public class ArtistDAO {
    public class ArtistAO {
        public void create(String name) throws SQLException {
            Connection con = Database.getConnection();
            try (PreparedStatement pstmt = con.prepareStatement(
                    "insert into artists (name) values (?)")) {
                pstmt.setString(1, name);
                pstmt.executeUpdate();
            }
        }
        public Integer findByName(String name) throws SQLException {
            Connection con = Database.getConnection();
            try (Statement stmt = con.createStatement();
                 ResultSet rs = stmt.executeQuery(
                         "select id from artists where name='" + name + "'")) {
                return rs.next() ? rs.getInt(1) : null;
            }
        }
        public String findById(int id) throws SQLException {
            TODO
        }
    }

}
