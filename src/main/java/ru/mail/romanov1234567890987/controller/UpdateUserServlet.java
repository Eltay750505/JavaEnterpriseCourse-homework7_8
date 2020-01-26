package ru.mail.romanov1234567890987.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.romanov1234567890987.service.UserService;
import ru.mail.romanov1234567890987.service.impl.UserServiceImpl;
import ru.mail.romanov1234567890987.service.model.UpdateUserDTO;
import ru.mail.romanov1234567890987.service.model.UserDTO;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

public class UpdateUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private UserService userService = UserServiceImpl.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        String adress = req.getParameter("adress");
        UpdateUserDTO userDTO = new UpdateUserDTO();
        userDTO.setAdress(adress);
        try {
            int idInt = Integer.parseInt(id);
            userDTO.setId(idInt);
            UpdateUserDTO addedUserDTO = userService.update(userDTO);
            try (PrintWriter out = resp.getWriter()) {
                out.println("<html><body>");
                out.println("Added new user : <br>");
                out.println("id : " + addedUserDTO.getId() + "<br>");
                out.println("adress : " + addedUserDTO.getAdress() + " <br>");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            logger.error("Incorrect format", e);
        }
    }
}
