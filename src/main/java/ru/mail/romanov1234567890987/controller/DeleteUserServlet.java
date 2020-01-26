package ru.mail.romanov1234567890987.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.mail.romanov1234567890987.service.UserService;
import ru.mail.romanov1234567890987.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.invoke.MethodHandles;

public class DeleteUserServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(MethodHandles.lookup().lookupClass());
    private UserService userService = UserServiceImpl.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            Integer idInt = Integer.parseInt(id);
            userService.deleteUserById(idInt);
            try (PrintWriter out = resp.getWriter()) {
                out.println("<html><body>");
                out.println("Object successfully deleted");
                out.println("</body></html>");
            }
        } catch (NumberFormatException e) {
            logger.error("Incorrect format", e);
        }
    }
}
