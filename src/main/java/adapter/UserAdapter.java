package adapter;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import businessLogic.BLFacade;
import domain.Bet;
import domain.Event;
import domain.Kuota;
import domain.Question;
import domain.User;
import gui.MainGUI;

public class UserAdapter extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	private List<domain.Bet> bets = new ArrayList<domain.Bet>();
	private String[] colNames = {"Event", "Question", "Event Date", "Bet(€)"};
	private BLFacade facade;
	
	public UserAdapter(User u) {
		this.bets=u.getbetlista();
		this.facade = MainGUI.getBusinessLogic();
	}
	
	public int getColumnCount() {
		return colNames.length;
	}
	public int getRowCount() {
		return bets.size();
	}
	public Object getValueAt(int row, int col) {
		Bet userBet = bets.get(row);
		int kuotaId = userBet.getKuotaId();
		Kuota userKuota = facade.getKuota(kuotaId);
		int questionId = userKuota.getQuestionId();
		Question userQuestion = facade.getQuestion(questionId);
		Event userEvent = userQuestion.getEvent();
		switch(col) {
		case 0: return userEvent.getDescription();
		case 1: return userQuestion.getQuestion();
		case 2: return userEvent.getEventDate();
		case 3: return userBet.getZenbatDiru();
		default:
		}
		return null;
	}

	  public String getColumnName(int col) {
	        return colNames[col];
	  }
	  
	  public String[] getColumnNames() {
	        return this.colNames;
	    }
}
