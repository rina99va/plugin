package plugin.servlet;

import com.atlassian.velocity.VelocityManager;
import com.google.common.collect.Maps;
import org.apache.velocity.app.Velocity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/gantt")
public class Servlet extends HttpServlet {

    private final VelocityManager velocityManager;

    public Servlet(VelocityManager velocityManager) {
        this.velocityManager = velocityManager;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, Object> context = Maps.newHashMap();
        context.put("myVar", Math.random());

        String content = this.velocityManager.getEncodedBody("/", "servlet.vm", "UTF-8", Maps.newHashMap());
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write(content);
        response.getWriter().close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
