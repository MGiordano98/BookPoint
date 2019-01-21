package control.gestioneRicerca;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import bean.Libro;
import model.LibroManager;

/**
 * Servlet implementation class VisualizzaCatalogo
 */
@WebServlet("/VisualizzaCatalogo")
public class VisualizzaCatalogo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LibroManager manager = new LibroManager();
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
		Collection<Libro> libriInEvidenza=null;
		Collection<Libro> libriPiùVenduti=null;
		try {
			libriInEvidenza = manager.getLibriInEvidenza();
			libriPiùVenduti= manager.getLibriPiùVenduti();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		request.getSession().setAttribute("libriInEvidenza", libriInEvidenza);
		request.getSession().setAttribute("libriPiùVenduti", libriPiùVenduti);

		response.sendRedirect("presentation/cliente/Libri.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
