package lab3;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class List extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = request.getParameter("name");

        String adminEmail = getServletConfig().getInitParameter("adminEmail");

        PrintWriter out = response.getWriter();
        try {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Список книг</title></head>");
            out.println("<body>");
            out.println("<h1>Список книг читателя " + (name != null ? name : "без имени") + "</h1>");
            out.println("<table border='1'>");
            out.println("<tr><td><b>Автор</b></td><td><b>Название</b></td><td><b>Прочитал</b></td></tr>");
            out.println("<tr><td>Булгаков</td><td>Мастер и Маргарита</td><td>Да</td></tr>");
            out.println("<tr><td>Пелевин</td><td>Чапаев и Пустота</td><td>Нет</td></tr>");
            out.println("</table>");
            if (adminEmail != null) {
                out.println("<p><small>Контакт: " + adminEmail + "</small></p>");
            }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}