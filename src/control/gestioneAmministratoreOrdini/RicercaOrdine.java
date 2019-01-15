package control.gestioneAmministratoreOrdini;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Ordine;
import model.DataManager;

/**
 * Servlet implementation class RicercaOrdine
 */
@WebServlet("/RicercaOrdine")
public class RicercaOrdine extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DataManager dm= new DataManager();
   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RicercaOrdine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		int numOrdine= Integer.parseInt(request.getParameter("numOrdine"));
		Ordine ordine= null;
		try {
			ordine= dm.ricercaOrdine(numOrdine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("ordine", ordine);
		RequestDispatcher dispatcher= request.getRequestDispatcher("AmministratoreOrdiniOrdine.jsp");
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
