import java.sql.SQLException;
import java.util.List;

public class ThrowAndThrows {
    public double divide(double a, double b) {
        if(b == 0) {
            throw new DivideByZeroException("Divider cannot be equal to zero!");
        }

        return a / b;
    }

    public List<String> findAll() throws SQLException {
        throw new SQLException();
    }
}

class DivideByZeroException extends RuntimeException {
    public DivideByZeroException(String message) {
        super(message);
    }
}

class DataAccessException extends RuntimeException {
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }
}
