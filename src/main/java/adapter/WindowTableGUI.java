package adapter;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogic.BLFacade;
import domain.Bet;
import domain.Mugimenduak;
import domain.User;
import gui.MainGUI;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class WindowTableGUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private UserAdapter userAdap;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowTableGUI frame = new WindowTableGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WindowTableGUI() {
		setTitle("Apustuak Ikusi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(74, 59, 310, 155);
		contentPane.add(scrollPane);
	}

	public WindowTableGUI(User erab) {
		setTitle("Table of " + erab.getIzena());
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		userAdap = new UserAdapter(erab);
		table = new JTable(userAdap);
		JScrollPane scrollpane = new JScrollPane(table);
		scrollpane.setBounds(74, 59, 310, 155);
		getContentPane().add(scrollpane);

		scrollpane.setViewportView(table);

		DefaultTableModel tableModel = new DefaultTableModel(null, userAdap.getColumnNames());

		table.setModel(tableModel);

		Vector<Bet>betlista = erab.getbetlista();
		tableModel.setDataVector(null, userAdap.getColumnNames());
		tableModel.setColumnCount(4);

		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);

		this.getContentPane().add(scrollpane, null);

		Vector<Object> rowObj = new Vector<Object>();
		for(int row=0; row<userAdap.getRowCount();row++) {
			for(int col=0; col<userAdap.getColumnCount();col++) {
				rowObj.add(userAdap.getValueAt(row, col));
			}
			tableModel.addRow(rowObj); 
			rowObj = new Vector<Object>();        
		}
	}
}
