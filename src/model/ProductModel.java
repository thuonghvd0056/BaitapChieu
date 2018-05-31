/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author xuanhung
 */
public class ProductModel {

    public boolean register(Product product) {
        try {
            Connection cnn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement("insert into `products` (`name`, `image`, `price`) values (?,?,?)");
            ps.setString(1, product.getName());
            ps.setString(2, product.getImage());
            ps.setString(3, product.getPrice());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }
    
}
