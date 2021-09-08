package com.huynam.service.productService;

import com.huynam.connectionJDBC.connectionJDBC;
import com.huynam.model.Category;
import com.huynam.model.Product;
import com.huynam.service.categoryService.ICategoryService;
import com.huynam.service.categoryService.categoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private final String SELECT_ALL_PRODUCT = "select * from product";
    private final String SELECT_BY_ID = "select * from product where id = ?";
    private final String SAVE_PRODUCT = "insert into product(name,price,quantity,color,description,categoryId) values(?,?,?,?,?,?)";
    private final String DELETE_PRODUCT = "delete from product where id = ?";
    private final String UPDATE_PRODUCT = "update product set name = ?, price = ?, amount = ?,color = ?,description = ?, categoryId = ? where id = ?;";
    private final Connection connection = connectionJDBC.getConnection();
    private ICategoryService categoryService = new categoryService();



    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("categoryId");
                Category category = (Category) categoryService.findById(category_id);
                Product product = new Product(id,name,price,quantity,color,description,category_id);
                productList.add(product);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return productList;

    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_product = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int category_id = resultSet.getInt("categoryId");
                Category category = (Category) categoryService.findById(category_id);
                product = new Product(id_product,name,price,quantity,color,description,category_id);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;

    }

    @Override
    public void save(Product p) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SAVE_PRODUCT);
            preparedStatement.setString(1,p.getName());
            preparedStatement.setDouble(2,p.getPrice());
            preparedStatement.setInt(3,p.getQuantity());
            preparedStatement.setString(4,p.getColor());
            preparedStatement.setString(5,p.getDescription());
            preparedStatement.setInt(6,p.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }





    @Override
    public void delete(int id) {
        try {
            PreparedStatement preparedStatement  = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void edit(int id, Product product) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryId());
            preparedStatement.setInt(7, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}

