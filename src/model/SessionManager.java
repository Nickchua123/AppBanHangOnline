
package model;

/**
 *
 * @author dungp
 */
public class SessionManager {
    private static String username;
    private static String email;
    private static String id;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        SessionManager.username = username;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        SessionManager.email = email;
    }

    public static String getId() {
        return id;
    }

    public static void setId(String id) {
        SessionManager.id = id;
    }

   
    public static void clearSession() {
        username = null;
        email = null;
        id = null;
    }
}
