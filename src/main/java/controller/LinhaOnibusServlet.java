package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import model.LinhaOnibus;
import database.LinhaOnibusDAO;

@WebServlet("/linhaservlet")
public class LinhaOnibusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private LinhaOnibusDAO linhasDAO;

    public void init() {
        linhasDAO = new LinhaOnibusDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<LinhaOnibus> linhas = linhasDAO.getLinhas();

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write((new Gson()).toJson(linhas));
    }

}
