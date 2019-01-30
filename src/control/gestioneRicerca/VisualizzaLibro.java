package control.gestioneRicerca;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Libro;
import model.LibroManager;

/**
 * Servlet implementation class VisualizzaLibro
 */
@WebServlet("/VisualizzaLibro")
public class VisualizzaLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroManager manager = new LibroManager();

       
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
		System.out.println("PIPPO");
		Libro libro= null;
		
		try {
			libro= manager.visualizzaLibro(isbn);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("libro", libro);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("/presentation/cliente/VisualizzaLibro.jsp");
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
