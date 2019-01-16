package control.gestioneInterazioneLibro;

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
import model.DataManager;
import model.InterazioneLibroManager;

/**
 * Servlet implementation class VisualizzaPreferiti
 */
@WebServlet("/VisualizzaPreferiti")
public class VisualizzaPreferiti extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private InterazioneLibroManager manager = new InterazioneLibroManager();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VisualizzaPreferiti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email= request.getParameter("email");
		Collection<Libro> preferiti= null; 
		
		try {
			preferiti= manager.getPreferiti(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("preferiti", preferiti);
		RequestDispatcher dispatcher= request.getRequestDispatcher("Preferiti.jsp");
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
