package game_store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dbconnection {
	
	Connection koneksi;
	PreparedStatement ps, ps2, ps3, ps4, ps5;
	ResultSet dataresult;
	
	public dbconnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			koneksi = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamestore","root","");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertgamedat(game gamedat){
		try {
			ps = koneksi.prepareStatement("insert Into game(nama_game, pembuat_game, genre_game, harga_game) values (?,?,?,?)");
			ps.setString(1, gamedat.getNama_game());
			ps.setString(2, gamedat.getPembuat_game());
			ps.setString(3, gamedat.getGenre_game());
			ps.setString(4, String.valueOf(gamedat.getHarga_game()));
			
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletegamedat (String gameid) {
		try {
			ps = koneksi.prepareStatement("Delete from game where game_id = ? ");
			ps.setString(1, gameid);
			ps.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public ResultSet getgamedat() {
		try {
			ps = koneksi.prepareStatement("Select * from game");
			dataresult = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return dataresult;
	}
	
	public void updategamedat(game gameupd ) {
		try {
			ps = koneksi.prepareStatement("UPDATE `game` SET `nama_game` = ?, `pembuat_game` = ?, `genre_game` = ?, `harga_game` = ? WHERE `game`.`game_id` = ?");
			
			ps.setString(1, gameupd.getNama_game());
			ps.setString(2, gameupd.getPembuat_game());
			ps.setString(3, gameupd.getGenre_game());
			ps.setString(4, String.valueOf(gameupd.getHarga_game()));
			ps.setString(5, String.valueOf(gameupd.getGameID()));
			
			ps.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void insertstruk(struk strukpemb) {
		try {
			ps = koneksi
					.prepareStatement("INSERT INTO `struk` (`strukid`, `game_id`, `nama_game`, `pembuat_game`, `genre_game`, `harga_game`, `uang_pembayaran`, `Total_pembelian`, `kuantitas_game`) VALUES (NULL, ?, ?, ?, ?, ?, ?, ?,?); ");
			ps.setString(1, String.valueOf(strukpemb.getGame_id()));
			ps.setString(2, strukpemb.getNama_game());
			ps.setString(3, strukpemb.getPembuat_game());
			ps.setString(4, strukpemb.getGenre_game());
			ps.setString(5, String.valueOf(strukpemb.getHarga_game()));
			ps.setString(6, String.valueOf(strukpemb.getUang_pembayaran()));
			ps.setString(7, String.valueOf(strukpemb.getHargatot()));
			ps.setString(8, String.valueOf(strukpemb.getKuantitas_game()));
			
			ps.execute();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
	}
	
	public ResultSet getstruckdata() {
		try {
			ps = koneksi.prepareStatement("Select * from struk");
			dataresult = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataresult;
	}
	
	public ResultSet get1struckdata(String strukid) {
		try {
			ps = koneksi.prepareStatement("Select * from struk where strukid = ?");
			ps.setString(1, strukid);
			dataresult = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dataresult;
	}
	


}
