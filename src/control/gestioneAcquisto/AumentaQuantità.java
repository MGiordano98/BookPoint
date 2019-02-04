package control.gestioneAcquisto;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import bean.Libro;
import carrello.Carrello;
import model.OrdineManager;

/**
 * Servlet implementation class AumentaQuantit‡
 */
@WebServlet("/AumentaQuantit‡")
public class AumentaQuantit‡ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static OrdineManager manager= new OrdineManager();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AumentaQuantit‡() {
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
		
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		
		String isbn= request.getParameter("isbn");
		carrello.aumentaQuantit‡(isbn);
		Libro lib= carrello.getLibro(isbn);
		
		request.getSession().setAttribute("carrello", carrello);
		String risposta= "{\"totaleCarrello\": \""+carrello.getTotale()+"\","
				+ "\"totaleProdotto\": \""+lib.getQuantit‡Selezionata()*lib.getPrezzo()+"\","
						+ "\"quantit‡\": \""+lib.getQuantit‡Selezionata()+"\"}";
		System.out.println(risposta);
		response.getWriter().write(risposta);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
