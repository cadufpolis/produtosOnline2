package produtosOnline2;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.naming.InitialContext;
import javax.sql.DataSource;

@ManagedBean
@ViewScoped
public class Teste implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void testa() {
		System.out.println("qquer coisa...");

		try {
			final String sql = "select * from cliente";
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:/produtosOnline");
			Connection con = null;
			Statement stmt = null;
			ResultSet rs = null;
				con = ds.getConnection();
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				while (rs.next()) {
					System.out.println("Query '" + sql + "' returned "
							+ rs.getString(2));
				}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
/*			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (con != null)
				con.close();*/
		}
	}

}
