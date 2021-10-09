/*
 * Copyright (c)  2020-present, Sri lanka
 */

package lk.ijse.javaApplication.controller;

import lk.ijse.javaApplication.db.DBConnection;
import lk.ijse.javaApplication.model.Item;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Ravindu Lakshan <ravindulakshan877@gmail.com>
 * @since 10/9/2021
 **/
public class ItemController {

    public boolean saveItem(Item item) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm= DBConnection.getInstance().getConnection().prepareStatement("INSERT INTO PRODUCT VALUES(?,?,?,?)");
        pstm.setObject(1,item.getCode());
        pstm.setObject(2,item.getDescription());
        pstm.setObject(3,item.getUnitPrice());
        pstm.setObject(4,item.getQtyOnHand());
        return pstm.executeUpdate()>0;
    }
}
