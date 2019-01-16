package control.gestioneAmministratore;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Utente;
import model.AmministratoreManager;
import model.DataManager;

/**
 * Servlet implementation class RicercaAccount
 */
@WebServlet("/RicercaAccount")
public class RicercaAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static AmministratoreManager am= new AmministratoreManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaAccount() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		
		Utente utente= null;
		try {
			utente = am.ricercaAccount(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("utente", utente);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("AmministratoreAccount.jsp");
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
