package game_store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

public class cetakStruk extends JFrame implements ActionListener{

	dbconnection db;
	JPanel greeting, com, list, combop, pembungkuslist, strukidp, pembungkuscomb, gameidp, namagamep, pembuatgamep, genregamep, hargagamep, hargatotalp, uangbayarp, bungkusstruk;
	JComboBox<String> combob;
	JButton combobut, cetakstruk, back;
	JPanel cetakstrukp, backp, bungkuskanan, bungkusfooter;
	JLabel greetingl, coml, listl, strukidl, gameid, namagame, pembuatgame, genregame, hargagame, Hargatotal, uangbayar, kuantitasgame;
	Font fontbody = new Font("sansserif", Font.BOLD, 16);
	Font fontheader = new Font("sansserif", Font.BOLD, 20 );
	Vector<String> listmenu;
	ResultSet rs;
	int totalharga, uangpembayaran;
	
	
	public cetakStruk(dbconnection db) {
		// TODO Auto-generated constructor stub
		this.db = db;
		
		rs = db.getstruckdata();
		listmenu = new Vector<String>();
		
		
		
		try {
			while (rs.next()) {
				if (!String.valueOf(rs.getObject("strukid")).isEmpty()) {
					listmenu.add(String.valueOf(rs.getObject("strukid")));
					combob = new JComboBox<String>(listmenu);
					combob.setBackground(Color.WHITE);
					combob.setPreferredSize(new Dimension(180,40));
					
					
					
				}
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		greeting = new JPanel(new FlowLayout(FlowLayout.CENTER));
		greeting.setBackground(Color.BLACK);
		greetingl = new JLabel("Here you can print out your receipt in a text file");
		greetingl.setBorder(new EmptyBorder(10,10,20,10));
		greetingl.setForeground(Color.GREEN.brighter());
		greetingl.setFont(fontheader);
		greeting.add(greetingl);	
		
		com = new JPanel(new FlowLayout());
		com.setBackground(Color.BLACK);
		coml = new JLabel("please select your struck id you want to print out");
		coml.setBorder(new EmptyBorder(0,10,10,10));
		coml.setForeground(Color.CYAN.brighter());
		coml.setPreferredSize(new Dimension(480,50));
		coml.setFont(fontbody);
		com.add(coml);
		
//		list = new JPanel(new FlowLayout(FlowLayout.LEFT));
//		list.setBackground(Color.BLACK);
//		listl = new JLabel("list");
//		listl.setBorder(new EmptyBorder(10,10,0,10));
//		listl.setForeground(Color.GRAY.brighter());
//		listl.setFont(fontbody);
//		list.add(listl);
		
	
		combop = new JPanel(new FlowLayout(FlowLayout.CENTER));
		combop.setBackground(Color.GRAY.brighter());
		combop.setBorder(new EmptyBorder(0,10,10,10));
		combop.add(combob);
		
		combobut = new JButton("Select");
		combobut.addActionListener(this);
		combobut.setFont(fontbody);
		combobut.setBackground(Color.GRAY.darker());
		combobut.setForeground(Color.CYAN);
		
		pembungkuscomb = new JPanel(new GridLayout(1,2));
		pembungkuscomb.add(combop);
		pembungkuscomb.add(combobut);
		
		pembungkuslist = new JPanel(new GridLayout(3,1));
		pembungkuslist.setBackground(Color.BLACK);
		pembungkuslist.add(com);
//		pembungkuslist.add(list);
		pembungkuslist.add(pembungkuscomb);
		
		
		
		
		bungkusstruk = new JPanel(new GridLayout(9,1));
		bungkusstruk.setBackground(Color.GRAY.brighter());
		bungkusstruk.setBorder(new EmptyBorder(10,20,10,20));
		
		strukidl = new JLabel("Strukid : ");
//		strukidp = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		strukidp.add(strukidl);
		
		gameid = new JLabel("game ID : ");
//		gameidp = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		gameidp.add(gameid);
		
		namagame = new JLabel("nama Game :");
//		namagamep = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		namagamep.add(namagame);
		
		pembuatgame = new JLabel("Pembuat Game : ");
//		pembuatgamep = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		pembuatgamep.add(pembuatgame);
		
		genregame = new JLabel("Genre Game : ");
//		genregamep = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		genregamep.add(genregame);
		
		hargagame = new JLabel("Harga Game : ");
//		hargagamep = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		hargagamep.add(hargagame);
		
		kuantitasgame = new JLabel("Kuantitas Game : ");
		
		Hargatotal = new JLabel("Total Pembelian : ");
//		hargatotalp = new JPanel(new FlowLayout(FlowLayout.CENTER));
//		hargatotalp.add(Hargatotal);
		
		uangbayar = new JLabel("Uang yang dibayarkan : ");
		
		
		bungkusstruk.add(strukidl);
		bungkusstruk.add(gameid);
		bungkusstruk.add(namagame);
		bungkusstruk.add(pembuatgame);
		bungkusstruk.add(genregame);
		bungkusstruk.add(hargagame);
		bungkusstruk.add(kuantitasgame);
		bungkusstruk.add(Hargatotal);
		bungkusstruk.add(uangbayar);
		
		bungkusfooter = new JPanel(new GridLayout(1,2));
		
		
		cetakstruk = new JButton("Cetak Struk");
		cetakstruk.setEnabled(false);
		cetakstruk.setPreferredSize(new Dimension(150,45));
		cetakstruk.addActionListener(this);
		cetakstruk.setFont(fontbody);
		cetakstruk.setBackground(Color.GRAY.darker());
		cetakstruk.setForeground(Color.CYAN);
		
		cetakstrukp = new JPanel();
		cetakstrukp.setBackground(Color.gray.brighter());
		cetakstrukp.add(cetakstruk);
		
		back = new JButton("Back");
		back.addActionListener(this);
		back.setPreferredSize(new Dimension(150,45));
		back.setFont(fontbody);
		back.setBackground(Color.GRAY.darker());
		back.setForeground(Color.CYAN);
		
		backp = new JPanel();
		backp.setBackground(Color.gray.brighter());
		backp.add(back);
		
		bungkuskanan = new JPanel(new GridLayout(2,1));
		bungkuskanan.setBorder(new EmptyBorder(20,0,10,0));
		bungkuskanan.setBackground(Color.gray.brighter());
		bungkuskanan.add(cetakstrukp);
		bungkuskanan.add(backp);
		
		bungkusfooter.add(bungkusstruk);
		bungkusfooter.add(bungkuskanan);
		
		
		add(greeting, BorderLayout.NORTH);
		add(pembungkuslist, BorderLayout.CENTER);
		add(bungkusfooter, BorderLayout.SOUTH);
		
		
		setSize(600,400);
		setTitle("Game Store");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
//		setBackground(Color.BLACK);
		setResizable(false);
		setVisible(true);
	}


	public void actionPerformed(ActionEvent act) {
		// TODO Auto-generated method stub
		if (act.getSource() == combobut) {
			try {
				rs = db.get1struckdata(String.valueOf(combob.getSelectedItem()));
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "you don't have any transaction avaiable", "Error", JOptionPane.ERROR_MESSAGE);
				new home(db);
				this.dispose();
				
			}
			cetakstruk.setEnabled(true);
			
			try {
				while (rs.next()) {	
					String strukid = "Struk ID : " + rs.getObject("strukid");
					String game_id = "Game ID : " + rs.getObject("game_id");
					String nama_game = "Nama Game : "  + rs.getObject("nama_game");
					String pembuat_game = "Pembuat Game : " + rs.getObject("pembuat_game");
					String genre_game = "Genre Game : " + rs.getObject("genre_game");
					String harga_game = "Harga Game : " + rs.getObject("harga_game");
					String kuantitas_game = "Kuantitas Game : " + rs.getObject("kuantitas_game");
					String total_harga = "Total Pembelian : " + rs.getObject("Total_pembelian");
					String uang_pembayaran = "Uang yang dibayarkan : " + rs.getObject("uang_pembayaran");
					
					totalharga = Integer.valueOf(String.valueOf(rs.getObject("Total_pembelian")));
					uangpembayaran = Integer.valueOf(String.valueOf(rs.getObject("Uang_pembayaran")));
					
					strukidl.setText(strukid);
					gameid.setText(game_id);
					namagame.setText(nama_game);
					pembuatgame.setText(pembuat_game);
					genregame.setText(genre_game);
					hargagame.setText(harga_game);
					kuantitasgame.setText(kuantitas_game);
					uangbayar.setText(uang_pembayaran);
					Hargatotal.setText(total_harga);
					
					System.out.println(strukid);
					System.out.println(game_id);
					System.out.println(nama_game);
					System.out.println(pembuat_game);
					System.out.println(genre_game);
					System.out.println(harga_game);
					System.out.println(uang_pembayaran);
					System.out.println(total_harga);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		if (act.getSource() == cetakstruk) {
			System.out.println("readed");
			File struk = new File("Struk.txt");
			String notif = "A Struk .txt file has been created in " + struk.getAbsolutePath();
			
			String strukid = strukidl.getText();
			String game_id = gameid.getText();
			String nama_game = namagame.getText();
			String pembuat_game = pembuatgame.getText();
			String genre_game = genregame.getText();
			String harga_game = hargagame.getText();
			String kuantitas_game = kuantitasgame.getText();
			String harga_total = Hargatotal.getText();
			String uang_pembayaran = uangbayar.getText();
			
			
			try {
				if (struk.createNewFile()) {
					JOptionPane.showMessageDialog(this, notif,
							"Struck Created Succesfully",
							JOptionPane.INFORMATION_MESSAGE);
				}
				else {
					FileWriter writer = null;
					try {
						writer = new FileWriter(struk);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try {
						String content = "Struk Pembelian \n\n" + strukid + "\n" + game_id + "\n" + nama_game + "\n" + pembuat_game + "\n" + genre_game + "\n" + harga_game + "\n" + harga_game + "\n" + kuantitas_game + "\n" + harga_total + "\n" + uang_pembayaran + "\nKembaliannya : " + String.valueOf((uangpembayaran-totalharga));
						writer.write(content);
						writer.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						}
				}
			} catch (HeadlessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

				
			
		}
		if (act.getSource() == back) {
			new home(db);
			this.dispose();
		}
		
		
	}

}
