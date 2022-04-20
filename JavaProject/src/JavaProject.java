import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Connection;
import static java.nio.charset.StandardCharsets.UTF_8;

public class JavaProject {
	public static void main(String[] args) {
		System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out), true, UTF_8));

		music cs = new music();

		System.out.println();
		System.out.println("Select statement: ");
		System.out.println();

		cs.ShowMusician();

		System.out.println();
		System.out.println("Delete statement: ");
		System.out.println();

		cs.DeleteMusician();

		System.out.println();
		System.out.println("Update statement: ");
		System.out.println();

		cs.UpdateMusician(6, "Metro", "Boomin");

		System.out.println();
		System.out.println("Insert statement: ");
		System.out.println();

		cs.InsertCustomers( 6 , "Metro", "Boomin");
	}

}