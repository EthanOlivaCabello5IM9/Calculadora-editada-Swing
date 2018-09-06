package operaciones;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class calculadora extends HttpServlet {

    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        double n1, n2, answer;
        int operacion;

        ServletOutputStream out = res.getOutputStream();

        n1 = Double.parseDouble(req.getParameter("num1"));
        n2 = Double.parseDouble(req.getParameter("num2"));
        operacion = Integer.parseInt(req.getParameter("operar"));

        answer = calcularRes(n1, n2, operacion);

        out.println("<html>");
        out.println("<head><title>.:CalculadoraServlet:.</title></head>");
        out.println("<body bgcolor = 'orange'>");
        out.println("<h1><center>Resultado</center></h1>");
        out.println("<h2>   <b><center>" + answer + "</center></b></h2>");
        out.println("<h1><center>El resultado es</center></h1>");
        out.println("<a href=\"index.html\">Regresar</a>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

    public double calcularRes(double n1, double n2, int operacion) {
        double answer = 0;

        switch (operacion) {
            case 1:
                return n1 + n2;

            case 2:
                return n1 - n2;

            case 3:
                return n1 * n2;

            case 4:
                return n1 / n2;

            case 5:
                return Math.abs(n1);
            case 6:
                return Math.sin(n1);

            case 7:
                return Math.cos(n1);

            case 8:
                return Math.tan(n1);

            case 9:
                return Math.pow(n1, 2);

            case 10:
                return Math.log10(n1);
        }

        return answer;
    }
}
