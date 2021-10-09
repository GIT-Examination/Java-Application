/*
 * Copyright (c)  2020-present, Sri lanka
 */

package lk.ijse.javaApplication.controller.formController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.javaApplication.controller.ItemController;
import lk.ijse.javaApplication.model.Item;

import java.sql.SQLException;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 10/9/2021
 **/
public class ItemSaveFormController {
    public TextField txtCode;
    public TextField txtDescription;
    public TextField txtUnitPrice;
    public TextField txtQTYOnHand;
    public Button btnSave;

    public void itemSaveOnAction(ActionEvent actionEvent) {
        String code=txtCode.getText();
        String description=txtDescription.getText();
        Double unitPrice= Double.valueOf(txtUnitPrice.getText());
        int qtyOnHand= Integer.parseInt(txtQTYOnHand.getText());

        Item item= new Item(code,description,unitPrice,qtyOnHand);

        try {
            if(new ItemController().saveItem(item)){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Saved").show();
            }else {
                new Alert(Alert.AlertType.ERROR,"Something went wrong").show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
