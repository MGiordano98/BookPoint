package control.gestioneAmministratore;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Autore;
import bean.Libro;
import model.AmministratoreManager;
/**
 * Servlet implementation class AggiungiLibro
 */
@WebServlet("/AggiungiLibro")
public class AggiungiLibro extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static AmministratoreManager am= new AmministratoreManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AggiungiLibro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isbn, titolo, trama, foto, casaEditrice, categoria;
		double prezzo;
		int quantit‡Disponibile;
		ArrayList<Autore> autori= new ArrayList<Autore>();
		
		isbn= request.getParameter("isbn");
		titolo= request.getParameter("titolo");
		trama= request.getParameter("trama");
		foto= request.getParameter("foto");
		casaEditrice= request.getParameter("casaEditrice");
		categoria= request.getParameter("categoria");
		prezzo= Double.parseDouble(request.getParameter("prezzo"));
		quantit‡Disponibile= Integer.parseInt(request.getParameter("quantit‡Disponibile"));
		
		int numAutori= Integer.parseInt("numAutori");
		for(int i=0; i<numAutori; i++) {
			autori.add(new Autore(request.getParameter("autore"+ i)));
		}
		Date dataUscita= Date.valueOf(request.getParameter("dataUscita"));
		
		Libro libro= new Libro(isbn, titolo, trama, foto, casaEditrice, prezzo, quantit‡Disponibile, categoria, autori, dataUscita);
		
		try {
			am.aggiungiLibro(libro);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher("AmministratoreCatalogo.jsp");
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
