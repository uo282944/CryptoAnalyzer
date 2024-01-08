package utils;


import java.sql.*;

public class Jdbc {

    private static String URL = "jdbc:sqlite:BD/sqliteadmin/CryptoScanner.s3db";

    public static void close(ResultSet rs, Statement st, Connection c) {
        close(rs);
        close(st);
        close(c);
    }
    public static void close(ResultSet rs, Statement st) {
        close(rs);
        close(st);
    }

    protected static void close(ResultSet rs) {
        if (rs != null) try { rs.close(); } catch(SQLException e) {/* ignore */}
    }

    public static void close(Statement st) {
        if (st != null ) try { st.close(); } catch(SQLException e) {/* ignore */}
    }

    public static void close(Connection c) {
        if (c != null) try { c.close(); } catch(SQLException e) {/* ignore */}
    }

    public static Connection createThreadConnection() throws SQLException {
        Connection con = DriverManager.getConnection(URL);
        threadConnection.set(con);
        return con;
    }

    private static ThreadLocal<Connection> threadConnection = new ThreadLocal<Connection>();

    public static Connection getCurrentConnection() {
        return threadConnection.get();
    }
}
