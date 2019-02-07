package control.gestioneAmministratore;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
		int quantita;
		ArrayList<Autore> autori= new ArrayList<Autore>();
		
		isbn= request.getParameter("isbn");		System.out.println(isbn);
		titolo= request.getParameter("titolo"); System.out.println(titolo);
		trama= request.getParameter("trama");	System.out.println(trama);
		foto= request.getParameter("foto");		System.out.println(foto);
		
		casaEditrice= request.getParameter("casaEditrice");	System.out.println(casaEditrice);
		categoria= request.getParameter("categoria");		System.out.println(categoria);
		prezzo= Double.parseDouble(request.getParameter("prezzo"));		System.out.println(prezzo);
		quantita= Integer.parseInt(request.getParameter("quantita"));	System.out.println(quantita);
		
		String[] nomiAutori=request.getParameterValues("autore");
		System.out.println(nomiAutori.length);
		
		for(String autore : nomiAutori) {
			System.out.println(autore);
			autori.add(new Autore(autore));
		}
		
		Date dataUscita= Date.valueOf(request.getParameter("dataUscita"));
		System.out.println(request.getParameter("dataUscita"));
		
		Libro libro= new Libro(isbn, titolo, trama, isbn+".jpg", casaEditrice, prezzo, quantita, categoria, autori, dataUscita);
		
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
