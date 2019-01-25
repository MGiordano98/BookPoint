package control.gestioneAmministratoreOrdini;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Ordine;
import model.AmministratoreOrdineManager;

/**
 * Servlet implementation class CambiaStato
 */
@WebServlet("/CambiaStato")
public class CambiaStato extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AmministratoreOrdineManager manager = new AmministratoreOrdineManager();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaStato() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ordine ordine= (Ordine) request.getSession().getAttribute("ordine");
		int numOrdine= ordine.getIdOrdine();
		String stato= request.getParameter("modifica-stato");
		System.out.println(stato);
		
		try {
			manager.cambiaStato(numOrdine, stato);
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
