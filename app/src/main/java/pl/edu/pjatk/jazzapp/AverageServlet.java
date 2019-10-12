package pl.edu.pjatk.jazzapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("hello")
public class AverageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setStatus(200);
        var writer = resp.getWriter();
        writer.println("Hello World!");

        if (req.getParameterMap().containsKey("average")) {
            String average = req.getParameter("average");

            String[] tab = average.split(",");

            double sum=0;
            for (String s : tab) {
                sum += Integer.parseInt(s);
            }
            double aver = sum/tab.length;


            writer.println("Srednia = " + aver);
        }

    }
}
