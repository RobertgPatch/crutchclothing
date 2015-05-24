package com.crutchclothing.json.datatable;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.crutchclothing.users.model.User;
import com.crutchclothing.users.service.UserService;

public class UserDataServlet extends HttpServlet { 
/*
 @Autowired
 @Qualifier("userService")
 UserService userService;
 private static final long serialVersionUID = 1L; 

 public UserDataServlet() { 
  super(); 
 } 

 protected void doGet(HttpServletRequest request, 
   HttpServletResponse response) throws ServletException, IOException { 

  response.setContentType("application/json"); 
  PrintWriter out = response.getWriter(); 

  List<User> lisOfUsers = userService.findAllUsers(); 

  DataTableObject dataTableObject = new DataTableObject(); 

  dataTableObject.setAaData(lisOfUsers); 
  
  

  Gson gson = new GsonBuilder().setPrettyPrinting().create(); 

  String json = gson.toJson(dataTableObject); 

  out.print(json);  

 } 

 protected void doPost(HttpServletRequest request, 

   HttpServletResponse response) throws ServletException, IOException { 

  doGet(request, response); 
 
 } 

*/
} 
