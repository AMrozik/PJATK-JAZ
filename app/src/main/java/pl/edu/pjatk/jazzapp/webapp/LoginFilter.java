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
@WebFilter("/index.xhtml")
public class LoginFilter extends HttpFilter {
    @Inject
    private LoginRequest loginRequest;
//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//        if (req.getRequestURI().contains("/index.xhtml") && req.isRequestedSessionIdFromCookie()){
//            res.sendRedirect("index.xhtml");
//        }
//        else {
//            chain.doFilter(req, res);
//            res.addCookie(new Cookie("Logged", loginRequest.getUsername()));
//        }
//    }

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login.xhtml";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        if (loggedIn || loginRequest || resourceRequest) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(loginURI);
        }
    }
}
