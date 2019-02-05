package control.gestioneAcquisto;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Indirizzo;
import bean.Ordine;
import bean.Utente;
import carrello.Carrello;
import model.OrdineManager;

/**
 * Servlet implementation class CompletaAcquisto
 */
@WebServlet("/CompletaAcquisto")
public class CompletaAcquisto extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static OrdineManager manager= new OrdineManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompletaAcquisto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carrello carrello= (Carrello) request.getSession().getAttribute("carrello");
		
		GregorianCalendar data= new GregorianCalendar();
		Date dataEffettuata= new Date(data.getTime().getTime());
		Time ora = new Time(data.getTime().getTime());
		data.add(Calendar.DAY_OF_MONTH, 7);
		Date dataConsegna= new Date(data.getTime().getTime());
		Collection<?> indirizzi= (Collection<?>) request.getSession().getAttribute("indirizzi");
		int idIndirizzo= Integer.parseInt(request.getParameter("idIndirizzo"));
		Utente utente= (Utente) request.getSession().getAttribute("utente");
		String email= utente.getEmail();
		Indirizzo indirizzo= cercaIndirizzo(indirizzi, idIndirizzo);
		
		Ordine ordine= new Ordine();
		ordine.setVia(indirizzo.getVia());
		ordine.setCap(indirizzo.getCap());
		ordine.setCittà(indirizzo.getCittà());
		ordine.setNumCivico(indirizzo.getNumCivico());
		ordine.setDataEffettuata(dataEffettuata);
		ordine.setDataConsegna(dataConsegna);
		ordine.setOra(ora);
		ordine.setNumCarta(request.getParameter("numCarta"));
		ordine.setStato("In Preparazione");
		ordine.setPrezzoTot(carrello.getTotale());
		ordine.setLibri(carrello.getLibri());
		ordine.setEmail(email);
		
		boolean acquistoCompletato= false;
		
		try {
			acquistoCompletato= manager.completaAcquisto(ordine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(acquistoCompletato) {
			request.getSession().removeAttribute("carrello");
		}
		
		request.getSession().setAttribute("acquistoCompletato", acquistoCompletato);
		RequestDispatcher dispatcher= request.getRequestDispatcher("AcquistoCompletato.jsp");
		dispatcher.forward(request, response);
	}

	private Indirizzo cercaIndirizzo(Collection<?> indirizzi, int idIndirizzo) {
		Indirizzo ind=null;
		Iterator it= indirizzi.iterator();
		while(it.hasNext()) {
			Indirizzo indirizzo= (Indirizzo) it.next();
			if(indirizzo.getId() == idIndirizzo)
				ind= indirizzo;
		}
		return ind;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
