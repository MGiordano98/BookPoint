package control.gestioneAmministratore;

import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String isbn= request.getParameter("isbn");
		String tipo= request.getParameter("tipo");
		String nuovoAttributo= request.getParameter("nuovoAttributo");
		if(nuovoAttributo!=null && !nuovoAttributo.equals("")){
		try {
			switch(tipo){
			case "titolo": manager.modificaTitolo(isbn,nuovoAttributo); break;
			case "trama": manager.modificaTrama(isbn,nuovoAttributo); break;
			case "foto": manager.modificaFoto(isbn,nuovoAttributo); break;
			case "casaEditrice": manager.modificaCasaEditrice(isbn,nuovoAttributo); break;
			case "prezzo": manager.modificaPrezzo(isbn,Double.parseDouble(nuovoAttributo)); break;
			case "quantit‡Disponibile": manager.modificaQuantit‡Disponibile(isbn,Integer.parseInt(nuovoAttributo)); break;
			case "categoria": manager.modificaCategoria(isbn,nuovoAttributo); break;
			case "dataUscita": int anno= Integer.parseInt("anno");
							   int mese= Integer.parseInt("mese");
							   int giorno= Integer.parseInt("giorno");
							   manager.modificaDataUscita(isbn,Date.valueOf(anno + "-" + mese + "-" + giorno)); break;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		RequestDispatcher dispatcher= request.getRequestDispatcher("AmministratoreVisualizzaLibro.jsp");
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
