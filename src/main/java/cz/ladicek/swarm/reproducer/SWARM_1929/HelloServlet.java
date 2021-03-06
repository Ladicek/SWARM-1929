package cz.ladicek.swarm.reproducer.SWARM_1929;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class HelloServlet extends HttpServlet {
    @Inject
    private HelloService hello;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        switch (req.getParameter("op")) {
            case "call":
                resp.getWriter().print(hello.performSomeRequest());
                break;
            case "count":
                resp.getWriter().print(hello.getCounter());
                break;
        }
    }
}
