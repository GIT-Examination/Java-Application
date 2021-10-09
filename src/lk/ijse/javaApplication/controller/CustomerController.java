/*
 * Copyright (c)  2020-present, Sri lanka
 */

package lk.ijse.javaApplication.controller;

import lk.ijse.javaApplication.db.DBConnection;
import lk.ijse.javaApplication.model.Customer;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 10/9/2021
 **/

public class CustomerController {

    public boolean saveCustomer(Customer customer) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm= DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO Customer VALUES (?,?,?,?)");
        pstm.setObject(1,customer.getId());
        pstm.setObject(2,customer.getName());
        pstm.setObject(3,customer.getAddress());
        pstm.setObject(4,customer.getContact());
        return pstm.executeUpdate()>0;
    }

}
