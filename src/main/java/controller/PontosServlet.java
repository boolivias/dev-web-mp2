package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import model.PontosOnibus;
import database.PontosOnibusDAO;

@WebServlet("/pontoservlet")
public class PontosServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PontosOnibusDAO pontosDao;

    public void init() {
        pontosDao = new PontosOnibusDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int pontoId = Integer.parseInt(request.getParameter("pontoId"));
        List<PontosOnibus> pontos = pontosDao.getPrevisao(pontoId);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write((new Gson()).toJson(pontos));
    }

}
