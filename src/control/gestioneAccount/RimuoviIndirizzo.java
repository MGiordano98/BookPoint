package control.gestioneAccount;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;

/**
 * Servlet implementation class RimuoviIndirizzo
 */
@WebServlet("/RimuoviIndirizzo")
public class RimuoviIndirizzo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AccountManager manager= new AccountManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RimuoviIndirizzo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idIndirizzo= Integer.parseInt(request.getParameter("idIndirizzo"));
		
		try {
			manager.rimuoviIndirizzo(idIndirizzo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("ricercaIndirizzi");
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
