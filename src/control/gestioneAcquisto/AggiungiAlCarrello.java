package control.gestioneAcquisto;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Carrello;
import bean.Libro;
import model.LibroManager;
import model.OrdineManager;

/**
 * Servlet implementation class AggiungiAlCarrello
 */
@WebServlet("/AggiungiAlCarrello")
public class AggiungiAlCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	private static OrdineManager manager= new OrdineManager();
	private static LibroManager libroManager= new LibroManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiAlCarrello() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carrello carrello= (Carrello) request.getSession().getAttribute("carrello");
		if(carrello==null) {
			carrello= new Carrello();
			request.getSession().setAttribute("carrello", carrello);
		}
		
		String isbn= request.getParameter("isbn");
		int quantità= Integer.parseInt(request.getParameter("quantita"));
		try {
			Libro lib= libroManager.visualizzaLibro(isbn);
			carrello =manager.aggiungiAlCarrello(carrello, lib, quantità);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getSession().setAttribute("carrello", carrello);
		RequestDispatcher dispatcher= request.getRequestDispatcher("VisualizzaLibro.jsp");
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
