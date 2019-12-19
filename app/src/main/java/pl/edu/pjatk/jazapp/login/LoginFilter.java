package pl.edu.pjatk.jazapp.login;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.ResourceHandler;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;

//@Named
//@RequestScoped
@WebFilter("*")
public class LoginFilter extends HttpFilter {
    @Inject
    private LoginRequest loginRequest;

    @Override
    public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws ServletException, IOException {

        if(true){
            chain.doFilter(req, res);
            return;
        }

        @SuppressWarnings("rawtypes")
        HttpSession session = req.getSession(false);
        String loginURI = req.getContextPath() + "/login.xhtml";
        String registerURI = req.getContextPath() + "/register.xhtml";
//        String addSectionURI = req.getContextPath() + "/addSection.xhtml";
//        String editSectionURI = req.getContextPath() + "/editSection.xhtml";
        String uri = req.getRequestURI();

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean registerRequest = req.getRequestURI().equals(registerURI);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        assert session != null;
        boolean isAdmin = session.getAttribute("admin").equals(true);

//        boolean addSectionRequest = req.getRequestURI().equals(addSectionURI);
//        boolean editSectionRequest = req.getRequestURI().equals(editSectionURI);

//        if(loggedIn && isAdmin && addSectionRequest || loggedIn && isAdmin && editSectionRequest){
//            chain.doFilter(req, res);
//        }
        if(loggedIn && loginRequest || loggedIn && registerRequest){
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        }
       else if (loggedIn || loginRequest || resourceRequest || registerRequest) {
            chain.doFilter(req, res);
        }
        else if (uri.indexOf("/css") > 0) {
            chain.doFilter(req, res);
        } else if (uri.indexOf("/images") > 0) {
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(loginURI);
        }
    }
}