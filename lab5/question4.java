/*
 * 4. Implement a singleton class DatabaseConnection using a private constructor. Ensure that the class restricts object creation to only one instance and provides a global access point using a static method.
 */

class DatabaseConnection{
    private static DatabaseConnection dbConnection = null;
    
    public int connectionID;
    private DatabaseConnection(){
        connectionID = (int) (Math.random() * 100);
    }
    public static DatabaseConnection getConnection(){
        if (dbConnection == null) {
            dbConnection = new DatabaseConnection();
        }
        return dbConnection;
    }

    public void displayConnection() {
        System.out.println("Connection with ID : " + connectionID);
    }

}

public class question4 {
    public static void main(String[] args) {
        DatabaseConnection conn1 = DatabaseConnection.getConnection();
        DatabaseConnection conn2 = DatabaseConnection.getConnection();
        conn1.displayConnection();
        conn2.displayConnection();
    }
}
