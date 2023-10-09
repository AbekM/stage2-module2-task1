package com.example.servlet;


import com.example.User;
import com.example.Warehouse;
import java.io.IOException;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet ("/users")
public class GetUsersServlet extends HttpServlet {

  @Override
  protected void doGet (HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      Set<User> users = Warehouse.getInstance().getUsers();
    request.setAttribute("users", users);
    request.getRequestDispatcher("src/main/webapp/jsp/users.jsp").forward(request, response);
  }
}
