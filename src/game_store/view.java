package game_store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

public class view extends JFrame implements ActionListener{

	dbconnection db;
	ResultSet gamedat;
	JTable productlist;
	JScrollPane tablescroll;
	JPanel scrollpanel, greeting, back;
	JButton backb;
	JLabel greetingl;
	Font fontbody = new Font("sansserif", Font.BOLD, 16);
	Font fontheader = new Font("sansserif", Font.BOLD, 20 );
	
	
	public view(dbconnection db) {
		this.db = db;
		
		greeting = new JPanel(new FlowLayout(FlowLayout.CENTER));
		greeting.setBackground(Color.BLACK);
		greetingl = new JLabel("Game Menu List");
		greetingl.setBorder(new EmptyBorder(10,10,20,10));
		greetingl.setForeground(Color.GREEN.brighter());
		greetingl.setFont(fontheader);
		greeting.add(greetingl);

		Vector<String> column = new Vector<String>();
		column.add("game_id");
		column.add("nama_game");
		column.add("Pembuat_game");
		column.add("genre_game");
		column.add("harga_game");
		
		Vector<Vector<Object>> data = new Vector<Vector<Object>>();
		
		gamedat = db.getgamedat();
		
		try {
			while (gamedat.next()) {
				Vector<Object> datar = new Vector<Object>();
				datar.add(gamedat.getObject("game_id"));
				datar.add(gamedat.getObject("nama_game"));
				datar.add(gamedat.getObject("pembuat_game"));
				datar.add(gamedat.getObject("genre_game"));
				datar.add(gamedat.getObject("harga_game"));
				
				data.add(datar);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		productlist = new JTable(data, column);
		tablescroll = new JScrollPane(productlist);
		tablescroll.setPreferredSize(new Dimension(500, 200));

		
		scrollpanel = new JPanel();
		scrollpanel.setBackground(Color.black);
		scrollpanel.add(tablescroll);
		
		back = new JPanel(new FlowLayout());
		back.setBackground(Color.BLACK);
		backb = new JButton("Back to Home");
		backb.addActionListener(this);
		backb.setForeground(Color.CYAN);
		backb.setPreferredSize(new Dimension(180,50));
		backb.setBorder(null);
		backb.setBackground(Color.gray.darker());
		backb.setFont(fontbody);
		back.add(backb);
		
		add(scrollpanel, BorderLayout.CENTER);
		add(greeting, BorderLayout.NORTH);
		add(back, BorderLayout.SOUTH);
		
		setSize(500,400);
		setTitle("Game Store");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
		
	}

	public void actionPerformed(ActionEvent act) {
		if (act.getSource() == backb) {
			new home(db);
			this.dispose();
		}

	}

}
