import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import javafx.scene.image.Image;
public class DBConnect {

    public static ArrayList getBooks() throws SQLException {
        String user = "student";
        String password = "student";
        ArrayList<Book> books = new ArrayList<>();
        Connection conn = null;
        Statement statement  = null;
        ResultSet resultSet = null;

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/comp1011t2s2?useSSL=false&zeroDateTimeBehavior=convertToNull&useLegacyDatetimeCode=false&serverTimezone=UTC", user, password);

            //2. create a statement
            statement = conn.createStatement();

            //3. Create the sql query
            resultSet = statement.executeQuery("SELECT * FROM books");

            //4. Loop through the results

            while (resultSet.next()) {
                Book newBook = new Book(
                        resultSet.getString( "title"),
                        resultSet.getString( "author"),
                        resultSet.getInt("bookId"),
                        resultSet.getInt("edition"),
                        resultSet.getDouble("price"),
                        resultSet.getBlob("imageLocation"));
                books.add(newBook);
            }

        } catch (SQLException e) {
            System.err.println(e);
        }
        finally {
            if (conn != null)
                conn.close();
            if (statement != null)
                statement.close();
            if (resultSet != null)
                resultSet.close();
        }

        return books;

    }
}

