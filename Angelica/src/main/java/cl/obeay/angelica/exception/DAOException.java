package cl.obeay.angelica.exception;

public class DAOException extends GenericException {

    /**
     * 
     */
    private static final long serialVersionUID = -372097411013080769L;

    /**
     * Constructor for DAOException
     */
    public DAOException(String msg) {
        super(msg);
    }

    /**
     * Constructor for DAOException
     */
    public DAOException(String msg, Throwable p_x) {
        super(msg, p_x);
    }

}