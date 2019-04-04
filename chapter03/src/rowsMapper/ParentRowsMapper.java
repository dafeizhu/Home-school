package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.Parent;

public class ParentRowsMapper implements RowsMapper<Parent>{
	@Override
	public Parent getEntity(ResultSet rs) throws SQLException {
		Parent parent = new Parent();
		parent.setParId(rs.getInt("p_ID"));
		parent.setParNo(rs.getInt("p_NO"));
		parent.setParName(rs.getString("p_Name"));
		parent.setParLogin(rs.getString("p_Password"));
		parent.setSex(rs.getString("p_Sex"));
		parent.setParTel(rs.getString("p_Tel"));
		
		return parent;
	}

}
