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

        // TODO: naprawic filtr

//        if(true){
//            chain.doFilter(req, res);
//            return;
//        }

        @SuppressWarnings("rawtypes")
        HttpSession session = req.getSession(false);

        String loginURI = req.getContextPath() + "/login.xhtml";
        String registerURI = req.getContextPath() + "/register.xhtml";

        String addSectionURI = req.getContextPath() + "/admin/addSection.xhtml";
        String editSectionURI = req.getContextPath() + "/admin/editSection.xhtml";
        String sectionViewURI = req.getContextPath() + "/admin/sectionView.xhtml";

        String showCategoriesURI = req.getContextPath() + "/admin/showCategories.xhtml";
        String addCategoryURI = req.getContextPath() + "/admin/addCategory.xhtml";
        String editCategoryURI = req.getContextPath() + "/admin/editCategory.xhtml";


        String uri = req.getRequestURI();

        boolean loggedIn = false;
        boolean isAdmin = false;

        if (session != null) {
            loggedIn = session.getAttribute("user") != null;
            isAdmin = session.getAttribute("isAdmin") != null;
        }

        boolean loginRequest = req.getRequestURI().equals(loginURI);
        boolean registerRequest = req.getRequestURI().equals(registerURI);
        boolean resourceRequest = req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER);

        boolean addSectionRequest = req.getRequestURI().equals(addSectionURI);
        boolean editSectionRequest = req.getRequestURI().equals(editSectionURI);
        boolean sectionViewRequest = req.getRequestURI().equals(sectionViewURI);

        boolean editCategoryRequest = req.getRequestURI().equals(editCategoryURI);
        boolean addCategoryRequest = req.getRequestURI().equals(addCategoryURI);
        boolean showCategoriesRequest = req.getRequestURI().equals(showCategoriesURI);


        if((addSectionRequest || editSectionRequest || sectionViewRequest || editCategoryRequest || addCategoryRequest || showCategoriesRequest) && loggedIn && !isAdmin){
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        }


        if (loggedIn && loginRequest || loggedIn && registerRequest) {
            res.sendRedirect(req.getContextPath() + "/index.xhtml");
        } else if (loggedIn || loginRequest || resourceRequest || registerRequest) {
            chain.doFilter(req, res);
        } else if (uri.indexOf("/css") > 0) {
            chain.doFilter(req, res);
        } else if (uri.indexOf("/images") > 0) {
            chain.doFilter(req, res);
        }else if (req.getRequestURI().startsWith(req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/")){
            chain.doFilter(req, res);
        } else {
            res.sendRedirect(loginURI);
        }
    }
}


//    @Override
//    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
//
//        if (isUserLogged(req) && isSiteForNotLoggedIn(req)){
//            res.sendRedirect(req.getContextPath() + "/index.xhtml");
//        }
//
//
//        if (isResourceReq(req) || isSiteAdminAllowed(req) && isUserLogged(req) && isAdmin(req)) {
//            chain.doFilter(req, res);
//        }
//        else if (isResourceReq(req) || isSiteAllowedForLoggedIn(req) || isUserLogged(req)) {
//            chain.doFilter(req, res);
//        }
//        else if(isResourceReq(req) || isSiteAllowed(req)){
//            chain.doFilter(req, res);
//        }
//        else {
//            res.sendRedirect(req.getContextPath() + "/login.xhtml");
//        }
//    }
//
//    private boolean isUserLogged(HttpServletRequest req) {
//        var session = req.getSession(false);
//        return session != null && session.getAttribute("username") != null;
//    }
//
//    private boolean isAdmin(HttpServletRequest req) {
//        var session = req.getSession(false);
//        return session != null && session.getAttribute("isAdmin") != null;
//    }
//
//    private boolean isSiteAllowed(HttpServletRequest req) {
//        return req.getRequestURI().equals(req.getContextPath() + "/login.xhtml") ||
//                req.getRequestURI().equals(req.getContextPath() + "/register.xhtml") ||
//                req.getRequestURI().equals(req.getContextPath() + "/showAuctions.xhtml");
////                req.getRequestURI().contains("samples") ||
////                // ONLY FOR TESTING
////                req.getRequestURI().contains("api") ||
////                req.getRequestURI().contains("admin");
////                // ONLY FOR TESTING
//    }
//
//    private boolean isSiteForNotLoggedIn(HttpServletRequest req){
//        return req.getRequestURI().equals(req.getContextPath() + "/login.xhtml") ||
//                req.getRequestURI().equals(req.getContextPath() + "/register.xhtml");
//    }
//
//    private boolean isSiteAdminAllowed(HttpServletRequest req) {
//        return req.getRequestURI().contains("admin");
//    }
//
//    private boolean isSiteAllowedForLoggedIn(HttpServletRequest req) {
//        return req.getRequestURI().equals(req.getContextPath() + "/showAuctions.xhtml") ||
//                req.getRequestURI().equals(req.getContextPath() + "/addAuc.xhtml") ||
//                req.getRequestURI().equals(req.getContextPath() + "/index.xhtml");
//
//    }
//
//    private boolean isResourceReq(HttpServletRequest req) {
//        return req.getRequestURI().startsWith(
//                req.getContextPath() + ResourceHandler.RESOURCE_IDENTIFIER + "/");
//    }
//
//}