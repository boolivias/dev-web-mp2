package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.LinhaOnibusDAO;

@WebServlet("/usertype")
public class UserTypeServlet extends HttpServlet {
    private LinhaOnibusDAO linhasDAO = null;

    public void init(){
        linhasDAO = new LinhaOnibusDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
     throws ServletException, IOException {
        String user = request.getParameter("user");
        // if (user.equalsIgnoreCase("funcionario")){
        System.out.println(user);
        if (user != null && user.equalsIgnoreCase("funcionario")){
            request.setAttribute("linhas", linhasDAO.getLinhas());
            RequestDispatcher dispatcher = request.getRequestDispatcher("./GRAFICOS-ONIBUS.JSP");
            dispatcher.forward(request, response);
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher("./ATRASOS-VIEW.JSP");
            dispatcher.forward(request, response);
        }
    }
}
