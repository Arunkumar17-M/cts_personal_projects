package innerclasses;

public class AnonymousDriverManager {

	
	public static AnonymousConnection getconnection() {
		AnonymousConnection con = new AnonymousConnection() {
			
			@Override
			public void createStatement() {
				System.out.println("inside the static method of DriverManager"
						+ "\nAnonymous inner class end with semicolon");
			}
		};
		return con;
	}
}
