package com.example.servlet;

import com.example.User;
import com.example.Warehouse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/add")
public class AddUserServlet extends HttpServlet {

  @Override
  protected void doPost (HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");

    User user = new User(firstName, lastName);
    Warehouse.getInstance().addUser(user);

    request.setAttribute("user", user);
    request.getRequestDispatcher("src/main/webapp/jsp/add.jsp").forward(request, response);
  }
}
