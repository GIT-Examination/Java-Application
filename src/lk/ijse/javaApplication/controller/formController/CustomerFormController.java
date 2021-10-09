/*
 * Copyright (c)  2020-present, Sri lanka
 */

package lk.ijse.javaApplication.controller.formController;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.javaApplication.controller.CustomerController;
import lk.ijse.javaApplication.model.Customer;

import java.sql.SQLException;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 10/9/2021
 **/
public class CustomerFormController {
    public TextField txtCustID;
    public TextField txtCustName;
    public TextField txtCustAddress;
    public TextField txtCustContact;
    public Button btnSaveCustomer;

    public void saveCustomerOnAction(ActionEvent actionEvent) {

        String custId= txtCustID.getText();
        String custName= txtCustName.getText();
        String custAddress= txtCustAddress.getText();
        String custContact= txtCustContact.getText();

        Customer c1 = new Customer(custId, custName, custAddress, custContact);

        try {
            if(new CustomerController().saveCustomer(c1)){
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
