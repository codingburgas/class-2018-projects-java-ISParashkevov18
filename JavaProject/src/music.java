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

@SuppressWarnings("unused")
public class music {
	private String url = "jdbc:sqlserver://SD2365\\sqlexpress;databaseName=MusicStore;integratedSecurity=true";
	private Connection conn;

	music() {
		System.out.println("Connecting...");
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Connected!");
	}

	public void ShowCustomers() {
		String query1 = "SELECT TOP 2 * FROM Musician";
		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query1);
			while (rs.next()) {
				System.out.println(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void DeleteCustomers() {
		String query1 = "DELETE FROM dbo.Musician WHERE MusicianID = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(query1);
			pst.setInt(1, 15);
			pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void UpdateCustomers(Integer Musician, String First_Name) {
		String query1 = "UPDATE dbo.Musician SET First_Name = ? " + "WHERE MusicianID = ?";
		try {
			PreparedStatement pst = conn.prepareStatement(query1);
			pst.setString(1, First_Name);
			pst.setInt(2, 6);
			pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void InsertCustomers(int MusicianID, String First_Name, String Last_Name) {
		String query1 = "INSERT INTO dbo.Musician (MusicianID, First_Name, Last_Name) VALUES (?, ?, ?)";
		try {
			PreparedStatement pst = conn.prepareStatement(query1);
			pst.setInt(1, MusicianID);
			pst.setString(2, First_Name);
			pst.setString(3, Last_Name);
			pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}