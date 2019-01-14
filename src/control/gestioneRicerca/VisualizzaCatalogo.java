package control.gestioneRicerca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Carrello;
import bean.Libro;
import model.DataManager;

/**
 * Servlet implementation class VisualizzaCatalogo
 */
@WebServlet("/VisualizzaCatalogo")
public class VisualizzaCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static DataManager dm= new DataManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaCatalogo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Collection<Libro>> catalogo=null;
		catalogo= dm.visualizzaCatalogo();
		
		request.getSession().setAttribute("catalogo", catalogo);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("Libri.jsp");
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
