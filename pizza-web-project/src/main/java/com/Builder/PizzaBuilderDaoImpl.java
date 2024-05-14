package com.Builder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.db.DatabaseConnection;
public class PizzaBuilderDaoImpl implements PizzaBuilderDao{
	private DatabaseConnection dbConnection;

    public PizzaBuilderDaoImpl(DatabaseConnection dbConnection) {
        this.dbConnection = dbConnection;
    }
    @Override
	public List<PizzaBuilder> getAllPizzas(){
        List<PizzaBuilder> pizzas = new ArrayList<>();
        String sql = "SELECT * FROM mydb";

        try (Connection connection = dbConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet rs = preparedStatement.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                books.add(new Book(id, title, author));
            }
        } catch (SQLException e) {
        	// Wrap the SQLException in a custom unchecked exception
            throw new DataAccessException("Error accessing the database", e);
        
    }
        return books;
    }

	
}
