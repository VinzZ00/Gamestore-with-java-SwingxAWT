package game_store;

public class struk {
	
	private int strukID;
	private int game_id;
	private String nama_game;
	private String pembuat_game;
	private String genre_game;
	private int harga_game;
	private int kuantitas_game;
	private int uang_pembayaran;
	private int hargatot;
	
	public int getHargatot() {
		return hargatot;
	}
	public void setHargatot(int hargatot) {
		this.hargatot = hargatot;
	}
	public int getGame_id() {
		return game_id;
	}
	public void setGame_id(int game_id) {
		this.game_id = game_id;
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
	public int getStrukID() {
		return strukID;
	}
	public void setStrukID(int strukID) {
		this.strukID = strukID;
	}
	public int getUang_pembayaran() {
		return uang_pembayaran;
	}
	public void setUang_pembayaran(int uang_pembayaran) {
		this.uang_pembayaran = uang_pembayaran;
	}
	public int getKuantitas_game() {
		return kuantitas_game;
	}
	public void setKuantitas_game(int kuantitas_game) {
		this.kuantitas_game = kuantitas_game;
	}
	
	public struk(int strukID, int game_id, String nama_game,
			String pembuat_game, String genre_game, int harga_game,
			int kuantitas_game, int uang_pembayaran, int hargatot) {
		super();
		this.strukID = strukID;
		this.game_id = game_id;
		this.nama_game = nama_game;
		this.pembuat_game = pembuat_game;
		this.genre_game = genre_game;
		this.harga_game = harga_game;
		this.kuantitas_game = kuantitas_game;
		this.uang_pembayaran = uang_pembayaran;
		this.hargatot = hargatot;
	}
	
	public struk(int game_id, String nama_game, String pembuat_game,
			String genre_game, int harga_game, int kuantitas_game,
			int uang_pembayaran, int hargatot) {
		super();
		this.game_id = game_id;
		this.nama_game = nama_game;
		this.pembuat_game = pembuat_game;
		this.genre_game = genre_game;
		this.harga_game = harga_game;
		this.kuantitas_game = kuantitas_game;
		this.uang_pembayaran = uang_pembayaran;
		this.hargatot = hargatot;
	}
	
	

	

	
	
	
}
