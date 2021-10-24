package game_store;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
		dbconnection db = new dbconnection();
		new home(db);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new main();

	}

}
