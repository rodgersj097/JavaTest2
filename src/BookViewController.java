import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BookViewController implements Initializable {
    @FXML
    private TableView<Book> tableView;

    @FXML
    private TableColumn<Book, Integer> bookIDColumn;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, Integer> editionColumn;

    @FXML
    private TableColumn<Book, Double> priceColumn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
     bookIDColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("bookID"));
     titleColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
     authorColumn.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
     editionColumn.setCellValueFactory(new PropertyValueFactory<Book, Integer>("edition"));
     priceColumn.setCellValueFactory(new PropertyValueFactory<Book, Double>("price"));

     try {
         tableView.getItems().addAll(DBConnect.getBooks());
     } catch (SQLException e) {
         e.printStackTrace();
     }
    }

    @FXML
    public void viewSelectedBook(ActionEvent event) throws IOException {
    Book selectedBook = tableView.getSelectionModel().getSelectedItem();

    if(selectedBook != null){
        SceneChanger.changeScenes(event, "BookDetailView.fxml", "Book Details", selectedBook);
    }
    }
}
