package cadastrobd.model.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Fabrício
 */
public class SequenceManager {
    
    public int getValue(String sequence) throws SQLException {
        ResultSet rs = new ConectorBD().getSelect("SELECT NEXT VALUE FOR ".concat(sequence));
        if (rs.next()) {
            return rs.getInt(1);
        } else {
            throw new SQLException("Next value not achievable: ".concat(sequence));
        }
    }
    
}
