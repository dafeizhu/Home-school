package rowsMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowsMapper<T> {
	public T getEntity(ResultSet rs) throws SQLException;
}
