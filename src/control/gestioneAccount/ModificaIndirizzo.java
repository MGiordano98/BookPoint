package control.gestioneAccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Indirizzo;
import bean.Utente;
import model.AccountManager;

/**
 * Servlet implementation class ModificaIndirizzo
 */
@WebServlet("/ModificaIndirizzo")
public class ModificaIndirizzo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static AccountManager manager= new AccountManager();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificaIndirizzo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idIndirizzo= Integer.parseInt(request.getParameter("idIndirizzo"));
		String via= request.getParameter("via");
		int numCivico= Integer.parseInt(request.getParameter("numCivico"));
		String cap= request.getParameter("cap");
		String città= request.getParameter("città");
		Utente utente= (Utente) request.getSession().getAttribute("utente");
		String email= utente.getEmail();
		
		try {
			Indirizzo indirizzo= new Indirizzo();
			indirizzo.setId(idIndirizzo);
			indirizzo.setVia(via);
			indirizzo.setNumCivico(numCivico);
			indirizzo.setCap(cap);
			indirizzo.setCittà(città);
			manager.modificaIndirizzo(indirizzo, email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("GestioneIndirizzi.jsp");
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
