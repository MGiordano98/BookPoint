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
import bean.Utente;
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
		Utente utente= (Utente) request.getSession().getAttribute("utente");
		String email= utente.getEmail();
		Collection<Libro> preferiti= null; 
		
		try {
			preferiti= manager.getPreferiti(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("preferiti", preferiti);
		response.sendRedirect("/BookPoint/presentation/cliente/Preferiti.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
