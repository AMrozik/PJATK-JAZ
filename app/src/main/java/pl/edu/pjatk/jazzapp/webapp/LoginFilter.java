package pl.edu.pjatk.jazzapp.webapp;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

@Named
@RequestScoped
@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Inject
    private LoginRequest loginRequest;

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login.xhtml";
        String registerURI = req.getContextPath() + "/register.xhtml";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean registerRequest = req.getRequestURI().equals(registerURI);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (loggedIn || loginRequest || resourceRequest || registerRequest) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(loginURI);
        }
    }
}