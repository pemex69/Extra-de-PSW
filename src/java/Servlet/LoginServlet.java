package Servlet;

import Controller.ClientActions;
import Model.Client;
import Model.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Enumeration;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            String clientEmail = request.getParameter("clientEmail");
            String clientPass = request.getParameter("clientPass");

            Client client = ClientActions.loginClient(clientEmail, clientPass);

            String clientName = "";

            if (client != null) {
                try {
                    Connection con = DatabaseConnection.getConnection();
                    String nameQuery = "SELECT clientName FROM Clients WHERE clientEmail = ?";
                    PreparedStatement ps = con.prepareStatement(nameQuery);
                    ps.setString(1, clientEmail);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
                        clientName = rs.getString("clientName");
                    }
                    con.close();
                } catch (Exception e) {
                    System.out.println("Error during name extraction: " + e.getMessage());
                }

                HttpSession clientSession = request.getSession(true);
                String clientSessionId = clientSession.getId();
                long sessionCreationTime = clientSession.getCreationTime();
                long lastClientSessionAccessedTime = clientSession.getLastAccessedTime();

                //'Cookie' [HashMap]
                String atribute = "clientAccount.ss";
                Integer account = (Integer) clientSession.getAttribute(atribute);
                if (account == null) {
                    account = new Integer(1);
                } else {
                    account = new Integer(account.intValue() + 1);
                }

                clientSession.setAttribute(atribute, account);
                Enumeration sessionParams = clientSession.getAttributeNames();
                while (sessionParams.hasMoreElements()) {
                    String params = (String) sessionParams.nextElement();
                    Object value = clientSession.getAttribute(params);
                    System.out.println("The parameter is: " + params + " and its value: " + value.toString());
                }
                clientSession.setAttribute("clientName", clientName);
                clientSession.setAttribute("clientEmail", clientEmail);
                clientSession.setAttribute("clientPass", clientPass);
                response.sendRedirect("pets.jsp"); // Redirige a la página de inicio después de iniciar sesión
            } else {
                response.sendRedirect("error.jsp"); // Redirige a la página de inicio de sesión con un mensaje de error
            }
        }
    }
}
