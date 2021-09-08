package com.huynam.controller;


import com.huynam.model.Category;
import com.huynam.model.Product;
import com.huynam.service.categoryService.categoryService;
import com.huynam.service.categoryService.ICategoryService;
import com.huynam.service.productService.IProductService;
import com.huynam.service.productService.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(value = "/products")
public class ProductServlet extends HttpServlet {
   private IProductService productService = new ProductService();
     private ICategoryService categoryService = new categoryService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(req,resp);
                break;
            case "edit":
                showEditForm(req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            default:
                showListProduct(req,resp);
                break;
        }
    }



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action==null){
            action = "";
        }
        switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            case "delete":
                break;
        }
    }

    private void searchByName(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
        String name = request.getParameter("name");
        List<Product> list = productService.findByName(name);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("Product/list.jsp");
        request.setAttribute("products",list);
        List<Category> categories = categoryService.findAll();
        request.setAttribute("categories", categories);
        requestDispatcher.forward(request,response);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Product product = productService.findById(id);
            List<Category> categoryList = categoryService.findAll();
            req.setAttribute("product",product);
            req.setAttribute("categoryList",categoryList);
            RequestDispatcher rd = req.getRequestDispatcher("/product/editProduct.jsp");
            rd.forward(req,resp);
        }
        catch (Exception e) {
            try {
                resp.sendRedirect("product/error.jsp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            String name = req.getParameter("name");
            Double price = Double.parseDouble(req.getParameter("price"));
            int  amount = Integer.parseInt(req.getParameter("quantity"));
            String color = req.getParameter("color");
            String description = req.getParameter("description");
            int category_id = Integer.parseInt(req.getParameter("categoryId"));
            Category category = new Category(category_id);
            Product product = new Product(id,name,price,amount,color,description,category_id);
            productService.edit(id,product);
            resp.sendRedirect("/products");
        }
        catch (Exception e) {
            try {
                resp.sendRedirect("product/error.jsp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {

        try {
            int id = Integer.parseInt(req.getParameter("id"));
            productService.delete(id);
            resp.sendRedirect("/products");
        }
        catch (Exception e) {
            try {
                resp.sendRedirect("product/error.jsp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }

    }
    private void showListProduct(HttpServletRequest req, HttpServletResponse resp) {

        try {
            List<Product> productList = productService.findAll();
            req.setAttribute("productList",productList);
            RequestDispatcher rd = req.getRequestDispatcher("/product/listProducts.jsp");
            rd.forward(req,resp);
        }  catch (Exception e) {
            try {
                resp.sendRedirect("product/error.jsp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    private void showCreateForm(HttpServletRequest req, HttpServletResponse resp) {
        List<Category> categoryList = categoryService.findAll();
        req.setAttribute("categoryList",categoryList);
        RequestDispatcher rd = req.getRequestDispatcher("/product/createProduct.jsp");
        try {
            rd.forward(req,resp);
        }
        catch (Exception e) {
            try {
                resp.sendRedirect("product/error.jsp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }
    private void createProduct(HttpServletRequest req, HttpServletResponse resp)  {
        try {
            String name = req.getParameter("name");
            double  price = Double.parseDouble(req.getParameter("price"));
            int  amount = Integer.parseInt(req.getParameter("quantity"));
            String color = req.getParameter("color");
            String description = req.getParameter("description");
            int category_id = Integer.parseInt(req.getParameter("categoryId"));
            Category category = new Category(category_id);
            Product product = new Product(name,price,amount,color,description,category_id);
            System.out.println(product);
            productService.save(product);
            resp.sendRedirect("/products");
        }
        catch (Exception e) {
            try {
                resp.sendRedirect("product/error.jsp");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            e.printStackTrace();
        }
    }

}