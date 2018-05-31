/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import com.jfoenix.controls.JFXTextField;
import entity.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import model.ProductModel;

/**
 *
 * @author xuanhung
 */
public class FXMLDocumentController implements Initializable {

    private ProductModel Model = new ProductModel();

    @FXML
    private Label lblUserNameError;
    @FXML
    private Label lblPasswordError;
    @FXML
    private Label lblEmailError;
    @FXML
    private Label lblMessage;
    @FXML
    private Label txtName;
    @FXML
    private Label txtImage;
    @FXML
    private Label txtPrice;
    @FXML
    private JFXTextField txtName1;
    @FXML
    private JFXTextField txtImage1;
    @FXML
    private JFXTextField txtPrice1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void handleSubmit(ActionEvent event) {
        String name = txtName1.getText();
        String image = txtImage1.getText();
        String price = txtPrice1.getText();
        if (name == null || name.length() == 0) {
            lblMessage.setText("Vui lòng sửa các thông tin bên dưới và thử lại.");
            lblMessage.setTextFill(Color.web("red"));
            lblUserNameError.setText("*");
            return;
        } else {
            lblUserNameError.setText("");
        }
        if (image == null || image.length() == 0) {
            lblMessage.setText("Vui lòng sửa các thông tin bên dưới và thử lại.");
            lblMessage.setTextFill(Color.web("red"));
            lblPasswordError.setText("*");
            return;
        } else {
            lblPasswordError.setText("");
        }
        if (price == null || price.length() == 0) {
            lblMessage.setText("Vui lòng sửa các thông tin bên dưới và thử lại.");
            lblMessage.setTextFill(Color.web("red"));
            lblEmailError.setText("*");
            return;
        } else {
            lblEmailError.setText("");
        }
        // Đảm bảo validated.
        Product product = new Product(name, image, price);
        if (Model.register(product)) {
            lblMessage.setText("Đăng ký thành công.");
            lblMessage.setTextFill(Color.web("green"));
            txtName1.clear();
            txtImage1.clear();
            txtPrice1.clear();
        } else {
            lblMessage.setText("Đăng ký thất bại, vui lòng thử lại.");
            lblMessage.setTextFill(Color.web("red"));
        }
    }

    @FXML
    private void handleReset(ActionEvent event) {
        txtName1.clear();
        txtImage1.clear();
        txtPrice1.clear();
    }

}
