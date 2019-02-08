package control.gestioneAmministratoreOrdini;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ordine;
import model.AmministratoreOrdineManager;

/**
 * Servlet implementation class CambiaDataEOra
 */
@WebServlet("/CambiaDataEOra")
public class CambiaDataEOra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AmministratoreOrdineManager manager = new AmministratoreOrdineManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaDataEOra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ordine ordine= (Ordine) request.getSession().getAttribute("ordine");
		int numOrdine= ordine.getIdOrdine();
		String data= request.getParameter("modifica-data");
		String ora= request.getParameter("modifica-ora");
		System.out.println(ora);
		
		try {
			manager.cambiaDataEOra(numOrdine, Date.valueOf(data), Time.valueOf(ora+":00"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("ricercaOrdine?numOrdine="+numOrdine);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
