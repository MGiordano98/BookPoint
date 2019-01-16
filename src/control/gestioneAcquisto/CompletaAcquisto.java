package control.gestioneAcquisto;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Carrello;
import bean.Ordine;
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
		
		
		
		Ordine ordine= new Ordine();
		ordine.setVia(request.getParameter("via"));
		ordine.setCap(Integer.parseInt(request.getParameter("cap")));
		ordine.setCittà(request.getParameter("città"));
		ordine.setDataEffettuata(dataEffettuata);
		ordine.setDataConsegna(dataConsegna);
		ordine.setOra(ora);
		ordine.setNumCarta(request.getParameter("numCarta"));
		ordine.setStato("In Preparazione");
		ordine.setPrezzoTot(carrello.getTotale());
		ordine.setLibri(carrello.getLibri());
		
		boolean acquistoCompletato= false;
		
		try {
			acquistoCompletato= manager.completaAcquisto(ordine);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("acquistoCompletato", acquistoCompletato);
		RequestDispatcher dispatcher= request.getRequestDispatcher("AcquistoCompletato.jsp");
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
