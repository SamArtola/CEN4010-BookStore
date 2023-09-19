import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Backend extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        // Process the data or perform any backend tasks
        // ...

        // Return a response back to the frontend
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Data received successfully!</h1>");
    }
}