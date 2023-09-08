package com.school.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.school.configuration.HelperClass;
import com.school.dto.Student;

public class StudentDao {
	
	HelperClass helperClass=new HelperClass();
	Connection connection=null;
	
	//To delete
	public boolean deleteStudentById(int id) {
		connection= helperClass.getConnection();
		String sql="DELETE FROM student WHERE Id=?";
		int i=0;
		//establish my statement
		try {
			PreparedStatement prepareStatement=
					connection.prepareStatement(sql);
			
			prepareStatement.setInt(1, id);
			
			 i = prepareStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}if(i>0) {
			return true;
		}else {
			return false;
		}
	}
	
	
	
	//to save a student data
	public Student saveStudent(Student student) {
		connection=helperClass.getConnection();
		String sql="INSERT INTO student Values(?,?,?)";
		
		//create statement
		try {
			PreparedStatement preparedstatement=connection.prepareStatement(sql);
			
			//passed the values to dlimiters/placeholders---
			preparedstatement.setInt(1,student.getId());
			preparedstatement.setString(2,student.getName());
			preparedstatement.setString(3,student.getEmail());
			
		//execute
			preparedstatement.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}return student;

	}

}
