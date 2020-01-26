package ru.mail.romanov1234567890987.controller;

import ru.mail.romanov1234567890987.service.UserService;
import ru.mail.romanov1234567890987.service.impl.UserServiceImpl;
import ru.mail.romanov1234567890987.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ShowUsersServlet extends HttpServlet {
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserDTO> users = userService.findAll();
        try (PrintWriter out = resp.getWriter()) {
            out.println("<html><body>");
            for (UserDTO element : users) {
                out.println("id : " + element.getId() + "<br>");
                out.println("userName : " + element.getUserName() + " <br>");
                out.println("password : " + element.getPassword() + " <br>");
                out.println("age : " + element.getAge() + " <br>");
                out.println("isActive : " + element.isActive() + " <br>");
                out.println("adress : " + element.getAdress() + " <br>");
                out.println("telephone : " + element.getTelephone() + " <br>");
                out.println("<br><br>");
            }
            out.println("</body></html>");
        }

    }
}