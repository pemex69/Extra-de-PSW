package Servlet;

import Controller.VeterinarianActions;
import Model.Veterinarian;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;
import java.util.Enumeration;

/**
 * Servlet implementation class VetLogin
 */
public class VetLogin extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String vetEmail = request.getParameter("clientEmail");
        String vetPass = request.getParameter("clientPass");

        Veterinarian vet = new Veterinarian();
        vet.setVetEmail(vetEmail);
        vet.setVetPass(vetPass);

        int vetId = VeterinarianActions.loginVeterinarian(vet);

        if (vetId > 0) {
            HttpSession session = request.getSession(true);
            session.setAttribute("vetEmail", vetEmail);
            response.sendRedirect("vetHomePage.jsp");
        } else {
            response.sendRedirect("error.jsp");
        }
    }
}
