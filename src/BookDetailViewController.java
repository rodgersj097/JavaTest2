import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BookDetailViewController implements Initializable, BookLoaderInterface {

    @FXML
    private ImageView imageView;

    @FXML
    private Label titleLabel;

    @FXML
    private Label authorLabel;

    @FXML
    private Label priceLabel;

    Book activeBook;
    @Override
    public void initialize(URL location, ResourceBundle resources) {


    }
    @Override
    public void loadBook(Book book) {
        activeBook = book;
        updateView();
    }

    public void updateView(){
        imageView.setImage(activeBook.getImage());
        titleLabel.setText(activeBook.getTitle());
        authorLabel.setText(activeBook.getAuthor());
        priceLabel.setText(String.format("%.0f",activeBook.getPrice()));
    }

    @FXML
    public void goBackButtonPushed(ActionEvent event) throws IOException {
    SceneChanger.changeScenes(event, "BookView.fxml", "List of Books");
    }



}
