package control.gestioneAccount;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Indirizzo;
import model.AccountManager;

/**
 * Servlet implementation class RicercaIndirizzi
 */
@WebServlet("/RicercaIndirizzi")
public class RicercaIndirizzi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AccountManager manager= new AccountManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaIndirizzi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		Collection<Indirizzo> indirizzi= null;
		
		try {
			indirizzi= manager.ricercaIndirizzi(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("indirizzi", indirizzi);
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
