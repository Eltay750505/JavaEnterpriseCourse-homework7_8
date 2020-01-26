package ru.mail.romanov1234567890987.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.romanov1234567890987.service.UserService;
import ru.mail.romanov1234567890987.service.impl.UserServiceImpl;
import ru.mail.romanov1234567890987.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

public class AddUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String age = req.getParameter("age");
        String adress = req.getParameter("adress");
        String telephone = req.getParameter("telephone");

        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(userName);
        userDTO.setPassword(password);
        userDTO.setAdress(adress);
        userDTO.setTelephone(telephone);

        try {
            int ageInt = Integer.parseInt(age);
            userDTO.setAge(ageInt);
            UserDTO addedUserDTO = userService.add(userDTO);
            try (PrintWriter out = resp.getWriter()) {
                out.println("<html><body>");
                out.println("Added new user : <br>");
                out.println("id : " + addedUserDTO.getId() + "<br>");
                out.println("userName : " + addedUserDTO.getUserName() + " <br>");
                out.println("password : " + addedUserDTO.getPassword() + " <br>");
                out.println("age : " + addedUserDTO.getAge() + " <br>");
                out.println("adress : " + addedUserDTO.getAdress() + " <br>");
                out.println("telephone : " + addedUserDTO.getTelephone() + " <br>");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            logger.error("Incorrect format", e);
        }

    }
}
