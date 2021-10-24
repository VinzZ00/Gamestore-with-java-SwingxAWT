package game_store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.scene.layout.Border;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class home extends JFrame implements ActionListener{
	
	JLabel greetingl;
	JPanel greeting, view, transaction, cetakstruk, pmanager, pembungkus;
	JButton pmanagerb ,viewb, transactionb, cetakstrukb;
	Font fontbody = new Font("sansserif", Font.BOLD, 16);
	Font fontheader = new Font("sansserif", Font.BOLD, 20 );
	dbconnection db;
	ResultSet rs;

	public home(dbconnection db) {
		this.db = db;
		rs = db.getstruckdata();
		
		// TODO Auto-generated constructor stub
		
		greeting = new JPanel(new FlowLayout(FlowLayout.CENTER));
		greeting.setBackground(Color.BLACK);
		greetingl = new JLabel("Welcome to Ultimate Games Store");
		greetingl.setBorder(new EmptyBorder(10,10,20,10));
		greetingl.setForeground(Color.GREEN.brighter());
		greetingl.setFont(fontheader);
		greeting.add(greetingl);		
		
		
		pmanager = new JPanel(new FlowLayout());
		pmanager.setBackground(Color.BLACK);
		pmanagerb = new JButton("Product manager");
		pmanagerb.addActionListener(this);
		pmanagerb.setForeground(Color.CYAN);
		pmanagerb.setPreferredSize(new Dimension(150,50));
		pmanagerb.setBorder(null);
		pmanagerb.setBackground(Color.GRAY.darker());
		pmanagerb.setFont(fontbody);
		pmanager.add(pmanagerb);
		
		view = new JPanel(new FlowLayout());
		view.setBackground(Color.BLACK);
		viewb = new JButton("View");
		viewb.addActionListener(this);
		viewb.setForeground(Color.CYAN);
		viewb.setPreferredSize(new Dimension(150,50));
		viewb.setBorder(null);
		viewb.setBackground(Color.GRAY.darker());
		viewb.setFont(fontbody);
		view.add(viewb);
		
		transaction = new JPanel(new FlowLayout());
		transaction.setBackground(Color.BLACK);
		transactionb = new JButton("Transaction");
		transactionb.addActionListener(this);
		transactionb.setForeground(Color.CYAN);
		transactionb.setPreferredSize(new Dimension(150,50));
		transactionb.setBorder(null);
		transactionb.setBackground(Color.gray.darker());
		transactionb.setFont(fontbody);
		transaction.add(transactionb);
		
		cetakstruk = new JPanel(new FlowLayout());
		cetakstruk.setBackground(Color.BLACK);
		cetakstrukb = new JButton("Cetak Struk");
		cetakstrukb.addActionListener(this);
		cetakstrukb.setForeground(Color.CYAN);
		cetakstrukb.setPreferredSize(new Dimension(150,50));
		cetakstrukb.setBorder(null);
		cetakstrukb.setBackground(Color.GRAY.darker());
		cetakstrukb.setFont(fontbody);
		cetakstruk.add(cetakstrukb);
		
		pembungkus = new JPanel(new GridLayout(4,1));
		pembungkus.setBackground(Color.BLACK);
		pembungkus.add(pmanager);
		pembungkus.add(view);
		pembungkus.add(transaction);
		pembungkus.add(cetakstruk);
		
		
		//add to the mainframe
		add(greeting, BorderLayout.NORTH);
		add(pembungkus, BorderLayout.CENTER);
		
		
		
		
		
		
		setSize(500,400);
		setTitle("Game Store");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setBackground(Color.BLACK);
		setResizable(false);
		setVisible(true);
	}


	public void actionPerformed(ActionEvent act) {
		if (act.getSource() == pmanagerb) {
			new productmanager(db);
			this.dispose();
		}
		if (act.getSource() == viewb) {
			new view(db);
			this.dispose();
		}
		if (act.getSource() == transactionb) {
			new transaction(db);
			this.dispose();
		}
		if (act.getSource() == cetakstrukb) {
			try {
				new cetakStruk(db);
				this.dispose();
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "You don't have any sales struk yet", "Erorr", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		// TODO Auto-generated method stub
		
	}

}
