package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;


public class EmployeeDao {
	
	 public Employee LoginEmployee(String username, String password) throws ClassNotFoundException {
		 String SELECT_LOGIN = "SELECT first_name, last_name, username, password, address, contact FROM employee " + 
				 				"WHERE username=? AND password=?;";
		 
		 Employee employee = null;

	     Class.forName("com.mysql.jdbc.Driver");
		 
		 try (Connection connection = DriverManager
		            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");

		            // Step 2:Create a statement using connection object
		            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LOGIN)) {
		            preparedStatement.setString(1, username);
		            preparedStatement.setString(2, password);

		            System.out.println(preparedStatement);
		            // Step 3: Execute the query or update query
		            try (ResultSet resultSet = preparedStatement.executeQuery();) {
		            	if (resultSet.next()) {
		            		employee = new Employee();
		            		employee.setFirstName(resultSet.getString("first_name"));
		            		employee.setLastName(resultSet.getString("last_name"));
		            		employee.setUsername(resultSet.getString("username"));
		            		employee.setPassword(resultSet.getString("password"));
		            		employee.setAddress(resultSet.getString("address"));
		            		employee.setContact(resultSet.getString("contact"));
		            	}
		            }
		            catch (SQLException e) {
		 				e.printStackTrace();
		 			}

		        } catch (SQLException e) {
		            // process sql exception
		            e.printStackTrace();
		        }
		 return employee;
	 }
	
	 public int registerEmployee(Employee employee) throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO employee" +
	            "  (id, first_name, last_name, username, password, address, contact) VALUES " +
	            " (?,?,?,?,?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/employees", "root", "root");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, employee.getFirstName());
	            preparedStatement.setString(3, employee.getLastName());
	            preparedStatement.setString(4, employee.getUsername());
	            preparedStatement.setString(5, employee.getPassword());
	            preparedStatement.setString(6, employee.getAddress());
	            preparedStatement.setString(7, employee.getContact());

	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            e.printStackTrace();
	        }
	        return result;
	    }

}
