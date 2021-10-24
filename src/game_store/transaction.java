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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class transaction extends JFrame implements MouseListener, ActionListener{

	JPanel greeting, scrollpanel;
	JLabel greetingl; 
	JLabel gameidl, namagamel, pembuatgamel, genregamel, hargagamel, 
	kuantitasl;
	JTextField gameidt, namagamet, pembuatgamet, genregamet, hargagamet, kuantitast;
	JPanel kuantitaslp, kuantitastp, gameidlp, gameidtp, namagamelp, namagametp, pembuatgamelp, pembuatgametp, genregamelp, genregametp, hargagamelp, hargagametp, footkiri;
	JPanel pembungkusbody;
	JPanel pembungkusfootkiri, pembungkusbagbawah;
	JLabel totalhargal, jumlahbayarl;
	JTextField jumlahbayart, totalharga;
	JPanel totalhargalp, totalhargap, jumlahbayarlp, jumlahbayartp;
	Font fontbody = new Font("sansserif", Font.BOLD, 16);
	Font fontheader = new Font("sansserif", Font.BOLD, 20 );
	ResultSet gamedat;
	JTable productlist;
	JScrollPane tablescroll;
	JButton OKb, bayarb, backb;
	JPanel OKbp, bayarbp, backp, pembungbutt;
	game gameDat;
	
	dbconnection db;
	public transaction(dbconnection db) {
		// TODO Auto-generated constructor stub
		this.db = db;
		
		greeting = new JPanel(new FlowLayout(FlowLayout.CENTER));
		greeting.setBackground(Color.BLACK);
		greetingl = new JLabel("What Game you want?");
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
		
		productlist = new JTable(data, column) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		productlist.setPreferredSize(new Dimension(600, 100));
		productlist.addMouseListener(this);
		productlist.getTableHeader().setReorderingAllowed(false);
		tablescroll = new JScrollPane(productlist);
		tablescroll.setPreferredSize(new Dimension(600, 100));
		tablescroll.setPreferredSize(new Dimension(600, 100));

		
		scrollpanel = new JPanel();
		scrollpanel.setBackground(Color.black);
		scrollpanel.add(tablescroll);
		
		
		
		gameidl = new JLabel("GameID");
		gameidl.setPreferredSize(new Dimension(130,30));
		gameidlp = new JPanel();
		gameidlp.setBackground(Color.GRAY.brighter());
		gameidlp.add(gameidl);
		
		gameidt = new JTextField();
		gameidt.setEditable(false);
		gameidt.setPreferredSize(new Dimension(130,30));
		gameidtp = new JPanel();
		gameidtp.setBackground(Color.GRAY.brighter());
		gameidtp.add(gameidt);
		
		namagamel = new JLabel("Nama Game");
		namagamel.setPreferredSize(new Dimension(130,30));
		namagamelp = new JPanel();
		namagamelp.setBackground(Color.GRAY.brighter());
		namagamelp.add(namagamel);
		
		namagamet = new JTextField();
		namagamet.setPreferredSize(new Dimension(130,30));
		namagamet.setEditable(false);
		namagametp = new JPanel();
		namagametp.setBackground(Color.GRAY.brighter());
		namagametp.add(namagamet);
		
		pembuatgamel = new JLabel("Pembuat Game");
		pembuatgamel.setPreferredSize(new Dimension(130,30));
		pembuatgamelp = new JPanel();
		pembuatgamelp.setBackground(Color.GRAY.brighter());
		pembuatgamelp.add(pembuatgamel);
		
		pembuatgamet = new JTextField();
		pembuatgamet.setPreferredSize(new Dimension(130,30));
		pembuatgamet.setEditable(false);
		pembuatgametp = new JPanel();
		pembuatgametp.setBackground(Color.GRAY.brighter());
		pembuatgametp.add(pembuatgamet);
		
		genregamel = new JLabel("Genre Game");
		genregamel.setPreferredSize(new Dimension(130,30));
		genregamelp = new JPanel();
		genregamelp.setBackground(Color.GRAY.brighter());
		genregamelp.add(genregamel);
		
		genregamet = new JTextField();
		genregamet.setPreferredSize(new Dimension(130,30));
		genregamet.setEditable(false);
		genregametp = new JPanel();
		genregametp.setBackground(Color.GRAY.brighter());
		genregametp.add(genregamet);
		
		hargagamel = new JLabel("Harga Satuan Game");
		hargagamel.setPreferredSize(new Dimension(130,30));
		hargagamelp = new JPanel();
		hargagamelp.setBackground(Color.GRAY.brighter());
		hargagamelp.add(hargagamel);
		
		hargagamet = new JTextField();
		hargagamet.setPreferredSize(new Dimension(130,30));
		hargagamet.setEditable(false);
		hargagametp = new JPanel();
		hargagametp.setBackground(Color.GRAY.brighter());
		hargagametp.add(hargagamet);

		
		kuantitasl = new JLabel("Kuantitas");
		kuantitasl.setPreferredSize(new Dimension(130,30));
		kuantitaslp = new JPanel();
		kuantitaslp.setBackground(Color.GRAY.brighter());
		kuantitaslp.add(kuantitasl);
		
		kuantitast = new JTextField();
		kuantitast.setPreferredSize(new Dimension(130,30));
		kuantitast.addActionListener(this);
		kuantitastp = new JPanel();
		kuantitastp.setBackground(Color.GRAY.brighter());
		kuantitastp.add(kuantitast);
		
		totalhargal = new JLabel("Total Harga :");
		totalhargal.setFont(fontbody);
		totalhargal.setPreferredSize(new Dimension(130,30));
		totalhargalp = new JPanel();
		totalhargalp.setBackground(Color.GRAY.darker());
		totalhargalp.add(totalhargal);
		
		totalharga = new JTextField();
//		totalharga.setBackground(Color.GRAY.brighter());
		totalharga.setEditable(false);
		totalharga.setFont(fontbody);
		totalharga.setPreferredSize(new Dimension(130,30));
		totalhargap = new JPanel();
		totalhargap.setBackground(Color.GRAY.darker());
		totalhargap.add(totalharga);
		
		jumlahbayarl = new JLabel("Jumlah Bayar");
		jumlahbayarl.setFont(fontbody);
		jumlahbayarl.setPreferredSize(new Dimension(130,30));
		jumlahbayarlp = new JPanel();
		jumlahbayarlp.setBackground(Color.GRAY.darker());
		jumlahbayarlp.add(jumlahbayarl);
		
		jumlahbayart = new JTextField();
		jumlahbayart.setFont(fontbody);
		jumlahbayart.setPreferredSize(new Dimension(130,30));
		jumlahbayartp = new JPanel();
		jumlahbayartp.setBackground(Color.GRAY.darker());
		jumlahbayartp.add(jumlahbayart);

		JPanel pembungkusabc = new JPanel(new GridLayout(3,1));
		pembungkusabc.setBackground(Color.gray.darker());
		
		OKb = new JButton("OK");
		OKb.addActionListener(this);
		OKb.setPreferredSize(new Dimension(130,30));
		OKbp = new JPanel();
		OKbp.setBorder(new EmptyBorder(0,0,20,0));
		OKbp.setBackground(Color.GRAY.brighter());
		OKbp.add(OKb);
		
		JPanel pembungkusatas = new JPanel();
		pembungkusatas.setBackground(Color.GRAY.darker());
		pembungkusatas.setBorder(new EmptyBorder(10,0,0,0));
		pembungkusatas.add(totalhargalp);
		pembungkusatas.add(totalhargap);
	
		pembungkusbagbawah = new JPanel();
		pembungkusbagbawah.setBackground(Color.GRAY.darker());
		pembungkusbagbawah.setBorder(new EmptyBorder(0,0,10,0));
		
		pembungkusbagbawah.add(jumlahbayarlp);
		pembungkusbagbawah.add(jumlahbayartp);
		
		pembungkusabc.add(OKbp);
		pembungkusabc.add(pembungkusatas);
		pembungkusabc.add(pembungkusbagbawah);
		
		
		
		
		
		
		
		
		footkiri = new JPanel(new GridLayout(3,4));
		footkiri.setBackground(Color.GRAY.brighter());
		footkiri.setBorder(new EmptyBorder(10,0,10,0));
		
		
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
		footkiri.add(kuantitaslp);
		footkiri.add(kuantitastp);
		
	
//		pembungkusfootkiri = new JPanel(new GridLayout(2,1));
//		pembungkusfootkiri.setBackground(Color.GRAY.darker());
//		pembungkusfootkiri.add(footkiri);
//		pembungkusfootkiri.add(OKbp);
		
		footkiri.setBorder(new EmptyBorder(10,0,10,0));
		
		pembungkusbody =  new JPanel(new GridLayout(3,1));
		pembungkusbody.setBackground(Color.BLACK);
		pembungkusbody.add(scrollpanel);
		pembungkusbody.add(footkiri);
		pembungkusbody.add(pembungkusabc);
		
		
		pembungbutt = new JPanel(new GridLayout(1,2));
		
		bayarb = new JButton("Bayar?");
		bayarb.addActionListener(this);
		bayarb.setFont(fontbody);
		bayarb.setBackground(Color.GRAY.darker());
		bayarb.setBorder(null);
		bayarb.setPreferredSize(new Dimension(130,50));
		bayarb.setForeground(Color.CYAN);
		bayarbp = new JPanel();
		bayarbp.setBorder(new EmptyBorder(20,0,20,0));
		bayarbp.setBackground(Color.BLACK);
		bayarbp.add(bayarb);
		
		backp = new JPanel(new FlowLayout());
		backp.setBackground(Color.BLACK);
		backb = new JButton("Back");
		backb.addActionListener(this);
		backb.setForeground(Color.CYAN);
		backb.setPreferredSize(new Dimension(130,50));
		backb.setBorder(null);
		backb.setBackground(Color.GRAY.darker());
		backp.setBorder(new EmptyBorder(20,0,20,0));
		backb.setFont(fontbody);
		backp.add(backb);
		
		pembungbutt.add(backp);
		pembungbutt.add(bayarbp);
		
		
		add(greeting, BorderLayout.NORTH);
		add(pembungkusbody, BorderLayout.CENTER);
		add(pembungbutt, BorderLayout.SOUTH);
//		add(scrollpanel, BorderLayout.CENTER);
//		add(footkiri, BorderLayout.SOUTH);
		
		setSize(600,800);
		setTitle("Game Store");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		
	}
	
	
	
	public void mouseClicked(MouseEvent arg0) {
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
			 
			 this.gameDat = gamedat;
			 
			 gameidt.setText(String.valueOf(gameID));
			 gameidt.setEditable(false);
			 namagamet.setText(nama_game);
			 pembuatgamet.setText(pembuat_game);
			 genregamet.setText(genre_game);
			 hargagamet.setText(String.valueOf(harga_game));
		}
		
	}
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	public void actionPerformed(ActionEvent act) {
		// TODO Auto-generated method stub
		if (act.getSource() == OKb) {
			int kuantitas = 0;
			if (!kuantitast.getText().isEmpty() && !gameidt.getText().isEmpty()) {
				try {
					if (Integer.valueOf(kuantitast.getText()) >= 1) {
						kuantitas = Integer.valueOf(kuantitast.getText());
						int hargatot = kuantitas
								* Integer.valueOf(hargagamet.getText());
						totalharga.setText(String.valueOf(hargatot));
					}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "tolong masukan angka", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "please pick up from the table and then input the quantity form","Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}
		if (act.getSource() == backb) {
			new home(db);
			this.dispose();
		}
		
		if (act.getSource() == bayarb) {
			if (!jumlahbayart.getText().isEmpty() && !totalharga.getText().isEmpty()) {
			int bayar = 0;
			int hargatot = 0;
			
				try {
					bayar = Integer.valueOf(jumlahbayart.getText());
				hargatot = Integer.valueOf(totalharga.getText());
				if (bayar >= hargatot) { 
					int kembalian = bayar - hargatot;
					JOptionPane.showMessageDialog(this, "Terima kasih, kembalian anda adalah " + kembalian, "Success Transaction", JOptionPane.INFORMATION_MESSAGE);
					
					int game_id = gameDat.getGameID();
					String nama_game = gameDat.getNama_game();
					String pembuat_game = gameDat.getPembuat_game();
					String genre_game = gameDat.getGenre_game();
					int kuantitas_game = Integer.valueOf(kuantitast.getText());
					int harga_game = gameDat.getHarga_game();
					int uang_pembayaran = bayar;
					
					struk strukpemb = new struk(game_id, nama_game, pembuat_game, genre_game, harga_game, kuantitas_game, uang_pembayaran, hargatot);
					db.insertstruk(strukpemb);
					
					new home(db);
					this.dispose();
				}
				else {
					JOptionPane.showMessageDialog(this,"Tolong insert total bayar yang melebihi total harga yang harus di bayar","UANG ANDA TIDAK CUKUP",JOptionPane.ERROR_MESSAGE);
				}
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "tolong masukan angka", "Error", JOptionPane.ERROR_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(this, "Tolong Dipilih dlu gamenya, masukin kuantitas, lalu masukin nominal bayar", "Error" , JOptionPane.ERROR_MESSAGE);
			}
			
		}
		
	}


}
