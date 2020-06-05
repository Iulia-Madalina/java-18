package servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class PostServlet extends HttpServlet {
	public static Flower flower;
	public int id;
	public static Map<Integer,Flower> map = new HashMap<>();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {



        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("name");
        String color = request.getParameter("color");
        String many = request.getParameter("many");

        flower = Flower.builder()
                .name(name)
                .color(color)
                .many(many)
                .build();


        if(name != "" || color!="" ||many!="") {
        System.out.println(flower);
        out.println("<p> Heeey! You just bought: " + flower.getMany() + " " + flower.getColor() + " " + flower.getName() + "(s) " + "</p>");
        out.println("<p> Thank you for choosing us!");
        }
        else {
        	out.println("Please enter a valid flower name, color and quantity!");
        }
        
        map.put(id++,flower);
        out.println(map);
        
        System.out.println(map);
    }
}
