package control.gestioneAcquisto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bean.CartaDiCredito;
import bean.Indirizzo;
import bean.Utente;
import model.AccountManager;

/**
 * Servlet implementation class SelezionaCartaEIndirizzo
 */
@WebServlet("/SelezionaCartaEIndirizzo")
public class SelezionaCartaEIndirizzo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AccountManager manager = new AccountManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelezionaCartaEIndirizzo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Utente utente= (Utente) request.getSession().getAttribute("utente");
		String email= utente.getEmail();
		
		Collection<CartaDiCredito> carte= null;
		Collection<Indirizzo> indirizzi= null;
		System.out.println("pippo");
		
		try {
			carte= manager.ricercaCarte(email);
			indirizzi= manager.ricercaIndirizzi(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("carte", carte);
		request.getSession().setAttribute("indirizzi", indirizzi);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CompletaAcquisto.jsp");
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
