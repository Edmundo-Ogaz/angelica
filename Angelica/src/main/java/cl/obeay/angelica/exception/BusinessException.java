package cl.obeay.angelica.exception;

public class BusinessException extends GenericException {

    /**
     * 
     */
    private static final long serialVersionUID = -372097411013080769L;

    /**
     * Constructor for BusinessException
     */
    public BusinessException(String msg) {
        super(msg);
    }

    /**
     * Constructor for BusinessException
     */
    public BusinessException(String msg, Throwable p_x) {
        super(msg, p_x);
    }

}