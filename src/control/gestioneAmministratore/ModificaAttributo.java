package control.gestioneAmministratore;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Libro;
import model.AmministratoreManager;

/**
 * Servlet implementation class ModificaAttributo
 */
@WebServlet("/ModificaAttributo")
public class ModificaAttributo extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AmministratoreManager manager= new AmministratoreManager();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificaAttributo() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Libro libro= (Libro) request.getSession().getAttribute("libro");
		String isbn= libro.getIsbn();
		String tipo= request.getParameter("tipo");
		String nuovoAttributo= request.getParameter("nuovoAttributo");
		System.out.println(isbn + " " + tipo + " " + nuovoAttributo);
		boolean result= false;
		
		if(nuovoAttributo!=null && !nuovoAttributo.equals("")){
			try {
				switch(tipo){
				case "titolo": result=manager.modificaTitolo(isbn,nuovoAttributo); break;
				case "trama": result=manager.modificaTrama(isbn,nuovoAttributo); break;
				case "foto": result=manager.modificaFoto(isbn,nuovoAttributo); break;
				case "casaEditrice": result=manager.modificaCasaEditrice(isbn,nuovoAttributo); break;
				case "prezzo": result=manager.modificaPrezzo(isbn,Double.parseDouble(nuovoAttributo)); break;
				case "quantitaDisponibile": result=manager.modificaQuantit‡Disponibile(isbn,Integer.parseInt(nuovoAttributo)); break;
				case "categoria": result=manager.modificaCategoria(isbn,nuovoAttributo); break;
				case "dataUscita": result=manager.modificaDataUscita(isbn,Date.valueOf(nuovoAttributo)); break;
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("visualizzaLibro?isbn="+isbn);
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
