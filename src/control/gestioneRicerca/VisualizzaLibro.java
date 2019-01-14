package control.gestioneRicerca;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Libro;
import bean.Recensione;
import model.DataManager;

/**
 * Servlet implementation class VisualizzaLibro
 */
@WebServlet("/VisualizzaLibro")
public class VisualizzaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DataManager dm= new DataManager();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn= request.getParameter("isbn");
		Libro libro= null;
		Collection<Recensione> recensioni= new LinkedList<Recensione>();
		
		try {
			libro= dm.visualizzaLibro(isbn);
			recensioni= dm.getRecensioni(isbn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("libro", libro);
		request.getSession().setAttribute("recensioni", recensioni);
		
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
