package game_store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javafx.scene.layout.Border;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class productmanager extends JFrame implements ActionListener, MouseListener {
	
	JLabel greetingl, gameidl, namagamel, pembuatgamel, genregamel, hargagamel;
	JTextField gameidt, namagamet, pembuatgamet, genregamet, hargagamet;
	JPanel greeting, Create, update, Delete, clear, pembungkus, scrollpanel, back, pembungkusfoot, footkiri, gameidlp, namagamelp, pembuatgamelp, genregamelp, hargagamelp, gameidtp, namagametp, pembuatgametp, genregametp, hargagametp;
	JButton Createb, updateb, Deleteb, backb, clearb;
	Font fontbody = new Font("sansserif", Font.BOLD, 16);
	Font fontheader = new Font("sansserif", Font.BOLD, 20 );
	dbconnection db;
	JTable productlist;
	ResultSet gamedat;
	JScrollPane tablescroll;
	game updgame, upgrgame;

	public productmanager(dbconnection db) {
		
		this.db = db;
		
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
		productlist.getTableHeader().setReorderingAllowed(false);
		for (int c = 0; c < productlist.getColumnCount(); c++)
		{
		    Class<?> col_class = productlist.getColumnClass(c);
		    productlist.setDefaultEditor(col_class, null);        // remove editor
		}
		productlist.addMouseListener(this);
		productlist.setPreferredSize(new Dimension(700,150));
		tablescroll = new JScrollPane(productlist);
		tablescroll.setPreferredSize(new Dimension(700, 150));
		
		scrollpanel = new JPanel();
		scrollpanel.setPreferredSize(new Dimension(700,150));
		scrollpanel.setBackground(Color.BLACK);
		scrollpanel.add(tablescroll);
		
		
		// TODO Auto-generated constructor stub
		greeting = new JPanel(new FlowLayout(FlowLayout.CENTER));
		greeting.setBackground(Color.BLACK);
		greetingl = new JLabel("Choose What You Gonna Do");
		greetingl.setBorder(new EmptyBorder(10,10,20,10));
		greetingl.setForeground(Color.GREEN.brighter());
		greetingl.setFont(fontheader);
		greeting.add(greetingl);		
		
		
		Create = new JPanel(new FlowLayout());
		Create.setBackground(Color.BLACK);
		Createb = new JButton("Create new product");
		Createb.addActionListener(this);
		Createb.setForeground(Color.CYAN);
		Createb.setPreferredSize(new Dimension(180,50));
		Createb.setBorder(null);
		Createb.setBackground(Color.GRAY.darker());
		Createb.setFont(fontbody);
		Create.add(Createb);
		
		update = new JPanel(new FlowLayout());
		update.setBackground(Color.BLACK);
		updateb = new JButton("Update product");
		updateb.setEnabled(false);
		updateb.addActionListener(this);
		updateb.setForeground(Color.CYAN);
		updateb.setPreferredSize(new Dimension(180,50));
		updateb.setBorder(null);
		updateb.setBackground(Color.GRAY.darker());
		updateb.setFont(fontbody);
		update.add(updateb);
		
		Delete = new JPanel(new FlowLayout());
		Delete.setBackground(Color.BLACK);
		Deleteb = new JButton("Delete Product");
		Deleteb.addActionListener(this);
		Deleteb.setForeground(Color.CYAN);
		Deleteb.setPreferredSize(new Dimension(180,50));
		Deleteb.setBorder(null);
		Deleteb.setBackground(Color.gray.darker());
		Deleteb.setFont(fontbody);
		Delete.add(Deleteb);
		
		back = new JPanel(new FlowLayout());
		back.setBackground(Color.BLACK);
		backb = new JButton("Back");
		backb.addActionListener(this);
		backb.setForeground(Color.CYAN);
		backb.setPreferredSize(new Dimension(180,50));
		backb.setBorder(null);
		backb.setBackground(Color.GRAY.darker());
		backb.setFont(fontbody);
		back.add(backb);
		
		pembungkusfoot = new  JPanel(new GridLayout(1,2));
		
		footkiri = new JPanel(new GridLayout(3,4));

		gameidl = new JLabel("GameID");
		gameidl.setPreferredSize(new Dimension(130,35));
		gameidlp = new JPanel();
		gameidlp.setBackground(Color.GRAY.brighter());
		gameidlp.add(gameidl);
		
		gameidt = new JTextField();
		gameidt.setEditable(false);
		gameidt.setPreferredSize(new Dimension(130,35));
		gameidtp = new JPanel();
		gameidtp.setBackground(Color.GRAY.brighter());
		gameidtp.add(gameidt);
		
		namagamel = new JLabel("Nama Game");
		namagamel.setPreferredSize(new Dimension(130,35));
		namagamelp = new JPanel();
		namagamelp.setBackground(Color.GRAY.brighter());
		namagamelp.add(namagamel);
		
		namagamet = new JTextField();
		namagamet.setPreferredSize(new Dimension(130,35));
		namagametp = new JPanel();
		namagametp.setBackground(Color.GRAY.brighter());
		namagametp.add(namagamet);
		
		pembuatgamel = new JLabel("Pembuat Game");
		pembuatgamel.setPreferredSize(new Dimension(130,35));
		pembuatgamelp = new JPanel();
		pembuatgamelp.setBackground(Color.GRAY.brighter());
		pembuatgamelp.add(pembuatgamel);
		
		pembuatgamet = new JTextField();
		pembuatgamet.setPreferredSize(new Dimension(130,35));
		pembuatgametp = new JPanel();
		pembuatgametp.setBackground(Color.GRAY.brighter());
		pembuatgametp.add(pembuatgamet);
		
		genregamel = new JLabel("Genre Game");
		genregamel.setPreferredSize(new Dimension(130,35));
		genregamelp = new JPanel();
		genregamelp.setBackground(Color.GRAY.brighter());
		genregamelp.add(genregamel);
		
		genregamet = new JTextField();
		genregamet.setPreferredSize(new Dimension(130,35));
		genregametp = new JPanel();
		genregametp.setBackground(Color.GRAY.brighter());
		genregametp.add(genregamet);
		
		hargagamel = new JLabel("Harga Game");
		hargagamel.setPreferredSize(new Dimension(130,35));
		hargagamelp = new JPanel();
		hargagamelp.setBackground(Color.GRAY.brighter());
		hargagamelp.add(hargagamel);
		
		hargagamet = new JTextField();
		hargagamet.setPreferredSize(new Dimension(130,35));
		hargagametp = new JPanel();
		hargagametp.setBackground(Color.GRAY.brighter());
		hargagametp.add(hargagamet);
		
		footkiri.setBackground(Color.GRAY.brighter());
		
		
		footkiri.add(gameidlp);
		footkiri.add(gameidtp);
		footkiri.add(namagamelp);
		footkiri.add(namagametp);
		footkiri.add(pembuatgamelp);
		footkiri.add(pembuatgametp);
		footkiri.add(genregamelp);
		footkiri.add(genregametp);
		footkiri.add(hargagamelp);
		footkiri.add(hargagametp);
		
		footkiri.setBorder(new EmptyBorder(10,0,5,0));
		

		clear = new JPanel(new FlowLayout());
		clear.setBackground(Color.BLACK);
		clearb = new JButton("Clear the form");
		clearb.addActionListener(this);
		clearb.setForeground(Color.CYAN);
		clearb.setPreferredSize(new Dimension(180,50));
		clearb.setBorder(null);
		clearb.setBackground(Color.GRAY.darker());
		clearb.setFont(fontbody);
		clear.add(clearb);
		
		
		pembungkus = new JPanel(new GridLayout(3,2));
		pembungkus.setBackground(Color.BLACK);
		pembungkus.setBorder(new EmptyBorder(5,0,0,0));
		pembungkus.add(Create);
		pembungkus.add(update);
		pembungkus.add(Delete);
		pembungkus.add(clear);
		pembungkus.add(back);
		
		pembungkusfoot = new JPanel(new GridLayout(2,1));
		pembungkusfoot.add(footkiri);
		pembungkusfoot.add(pembungkus);
		
		
		
		
		
		
		//add to the mainframe
		add(greeting, BorderLayout.NORTH);
		add(scrollpanel, BorderLayout.CENTER);
		add(pembungkusfoot, BorderLayout.SOUTH);
		
		
		
		
		
		
		setSize(700,600);
		setTitle("Game Store");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent act) {
		// TODO Auto-generated method stub
		if (act.getSource() == Createb) {
			try {
				String nama_game = namagamet.getText();
				String pembuat_game = pembuatgamet.getText();
				String genre_game = genregamet.getText();
				int harga_game = Integer.valueOf(hargagamet.getText());
				game newgame = new game(nama_game, pembuat_game, genre_game,
						harga_game);
				db.insertgamedat(newgame);
				new home(db);
				this.dispose();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Please input data properly", "Error",JOptionPane.ERROR_MESSAGE);
				// TODO: handle exception
			}
		}
		
		if (act.getSource() == Deleteb) {
			if (!gameidt.getText().isEmpty()) {
				String idname = String.valueOf(updgame.getGameID());
			db.deletegamedat(idname);
			new home(db);
			this.dispose();
			}
			else {
				JOptionPane.showMessageDialog(this, "Please Select a Game First", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
		if (act.getSource() == updateb) {
			
			int gameID = Integer.valueOf(gameidt.getText());
			String nama_game = namagamet.getText();
			String pembuat_game = pembuatgamet.getText();
			String genre_game = genregamet.getText();
			String harga_game = hargagamet.getText();
			try {
				game upgrgame = new game(gameID, nama_game, pembuat_game, genre_game, Integer.valueOf(harga_game));
				db.updategamedat(upgrgame);
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Please input only number character", "Error", JOptionPane.ERROR_MESSAGE);
			}
			new home(db);
			this.dispose();
		}
		
		if (act.getSource() == clearb) {
			 gameidt.setText(null);
			 gameidt.setEditable(false);
			 namagamet.setText(null);
			 pembuatgamet.setText(null);
			 genregamet.setText(null);
			 hargagamet.setText(null);
			 
			 updateb.setEnabled(false);
			 Createb.setEnabled(true);
		}
		
		if (act.getSource() == backb) {

			new home(db);
			this.dispose();
		}
		
	}
		
	

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		final int ind = productlist.getSelectedRow();
		if (ind != -1) {
			
			 int gameID = Integer.valueOf(productlist.getValueAt(ind, 0).toString());
			 String nama_game = productlist.getValueAt(ind, 1).toString();
			 String pembuat_game = productlist.getValueAt(ind, 2).toString();
			 String genre_game = productlist.getValueAt(ind, 3).toString();
			 int harga_game = Integer.valueOf(productlist.getValueAt(ind, 4).toString());
			 
			 System.out.println(gameID);
			 System.out.println(nama_game);
			 System.out.println(pembuat_game);
			 System.out.println(genre_game);
			 System.out.println(harga_game);
			 
			 game gamedat = new game(gameID, nama_game, pembuat_game, genre_game, harga_game);
			 
			 gameidt.setText(String.valueOf(gameID));
			 gameidt.setEditable(false);
			 namagamet.setText(nama_game);
			 pembuatgamet.setText(pembuat_game);
			 genregamet.setText(genre_game);
			 hargagamet.setText(String.valueOf(harga_game));
			 
			 Createb.setEnabled(false);
			 updateb.setEnabled(true);
			 
			 updgame = gamedat;
			 productlist.addMouseListener(new MouseListener() {
				
				public void mouseReleased(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				public void mousePressed(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				public void mouseExited(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				public void mouseEntered(MouseEvent arg0) {
					// TODO Auto-generated method stub
					
				}
				
				public void mouseClicked(MouseEvent arg0) {
					int ind =  productlist.getSelectedRow();
					if (ind == -1) {
						gameidt.setText(null);
						 gameidt.setEditable(false);
						 updateb.setEnabled(false);
						 namagamet.setText(null);
						 pembuatgamet.setText(null);
						 genregamet.setText(null);
						 hargagamet.setText(null);
						 
						 Createb.setEnabled(true);
					}
					
				}
			});
			}
	
		if (ind == -1) {
			Createb.setEnabled(true);
			updateb.setEnabled(false);
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


}
