package control.gestioneAccount;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.CartaDiCredito;
import model.AccountManager;

/**
 * Servlet implementation class AggiungiCarta
 */
@WebServlet("/AggiungiCarta")
public class AggiungiCarta extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static AccountManager manager= new AccountManager();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiCarta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		int numCarta= Integer.parseInt(request.getParameter("numCarta"));
		String intestatario= request.getParameter("intestatario");
		int mese= Integer.parseInt(request.getParameter("mese"));
		int anno= Integer.parseInt(request.getParameter("anno"));
		int cvv= Integer.parseInt(request.getParameter("cvv"));
		
		Date dataScadenza= Date.valueOf(anno + "-" + mese + "-01");
		try {
			CartaDiCredito carta = new CartaDiCredito(numCarta, intestatario, dataScadenza, cvv);
			manager.aggiungiCarta(email, carta);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("GestioneCarteDiCredito.jsp");
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
