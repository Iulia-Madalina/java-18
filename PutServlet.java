package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PutServlet extends HttpServlet {
	

    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	
    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
    	out.println(PostServlet.map);
    	System.out.println(PostServlet.map);
    }


}
