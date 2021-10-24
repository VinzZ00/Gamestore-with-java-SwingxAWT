package game_store;

public class game {

	private int gameID;
	private String nama_game;
	private String pembuat_game;
	private String genre_game;
	private int harga_game;
	
	
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public String getNama_game() {
		return nama_game;
	}
	public void setNama_game(String nama_game) {
		this.nama_game = nama_game;
	}
	public String getPembuat_game() {
		return pembuat_game;
	}
	public void setPembuat_game(String pembuat_game) {
		this.pembuat_game = pembuat_game;
	}
	public String getGenre_game() {
		return genre_game;
	}
	public void setGenre_game(String genre_game) {
		this.genre_game = genre_game;
	}
	public int getHarga_game() {
		return harga_game;
	}
	public void setHarga_game(int harga_game) {
		this.harga_game = harga_game;
	}
	
	public game(String nama_game, String pembuat_game, String genre_game,
			int harga_game) {
		super();
		this.nama_game = nama_game;
		this.pembuat_game = pembuat_game;
		this.genre_game = genre_game;
		this.harga_game = harga_game;
	}
	
	public game(int gameID, String nama_game, String pembuat_game,
			String genre_game, int harga_game) {
		super();
		this.gameID = gameID;
		this.nama_game = nama_game;
		this.pembuat_game = pembuat_game;
		this.genre_game = genre_game;
		this.harga_game = harga_game;
	}
	
	
	
	

}
