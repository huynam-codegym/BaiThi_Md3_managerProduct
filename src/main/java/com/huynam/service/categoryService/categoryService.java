package com.huynam.service.categoryService;

import com.huynam.connectionJDBC.connectionJDBC;
import com.huynam.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class categoryService implements ICategoryService{

    private final String SELECT_ALL_CATEGORY = "select * from category";
    private final String SELECT_BY_ID = "select * from category where id = ?;";
    private final String FIND_BY_NAME = "select * from product where name like ?;";

    private Connection connection = connectionJDBC.getConnection();

    @Override
    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CATEGORY);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                Category category = new Category(id,name);
                categoryList.add(category);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryList;

    }

    @Override
    public Category findById(int id) {

        Category category = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int id_category = resultSet.getInt(1);
                String name = resultSet.getString(2);
                category = new Category(id_category,name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return category;
    }
    @Override
    public List<Category> findByName(String name) {
        return null;
    }
    @Override
    public void save(Object p) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void edit(int id, Object o) {

    }
}
