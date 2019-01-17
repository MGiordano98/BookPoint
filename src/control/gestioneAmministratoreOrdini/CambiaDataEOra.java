package control.gestioneAmministratoreOrdini;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AmministratoreOrdineManager;

/**
 * Servlet implementation class CambiaDataEOra
 */
@WebServlet("/CambiaDataEOra")
public class CambiaDataEOra extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AmministratoreOrdineManager manager = new AmministratoreOrdineManager();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CambiaDataEOra() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int numOrdine= Integer.parseInt(request.getParameter("numOrdine"));
		int giorno= Integer.parseInt(request.getParameter("giorno"));
		int mese= Integer.parseInt(request.getParameter("mese"));
		int anno= Integer.parseInt(request.getParameter("anno"));
		int minuti= Integer.parseInt(request.getParameter("minuti"));
		int ore= Integer.parseInt(request.getParameter("ore"));
		
		Date data= Date.valueOf(anno + "-" + mese + "-" + giorno);
		Time ora= Time.valueOf(ore + ":" + minuti);
		try {
			manager.cambiaDataEOra(numOrdine, data, ora);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("AmministratoreOrdiniOrdine.jsp");
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
