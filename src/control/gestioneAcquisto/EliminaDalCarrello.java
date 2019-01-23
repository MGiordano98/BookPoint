package control.gestioneAcquisto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Carrello;
import model.OrdineManager;

/**
 * Servlet implementation class EliminaDalCarrello
 */
@WebServlet("/EliminaDalCarrello")
public class EliminaDalCarrello extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OrdineManager manager= new OrdineManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminaDalCarrello() {
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
		System.out.println(isbn);
		carrello= manager.rimuoviDalCarrello(carrello, isbn);
		
		request.getSession().setAttribute("carrello", carrello);
		RequestDispatcher dispatcher= request.getRequestDispatcher("Carrello.jsp");
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
