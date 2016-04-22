package cl.obeay.angelica.exception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class GenericException extends Exception implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private Throwable m_nestedException;


    /**
     *
     *
     */
    public GenericException() {
        this("", null);
    }

    /**
     *
     * @param p_message
     */
    public GenericException(String p_message) {
        this(p_message, null);
    }

    /**
     *
     * @param p_message
     * @param p_nestedException
     */
    public GenericException(String p_message, Throwable p_nestedException) {
        super(p_message == null ? "" : p_message);
        m_nestedException = null;
        m_nestedException = p_nestedException;
    }

    /**
     *
     */
    public String getMessage() {
        StringBuffer buffer = new StringBuffer("");
        buffer.append(super.getMessage());
        if (nestedException() != null) {
            buffer.append(". Nested exception: (");
            buffer.append(nestedException().getClass().getName());
            buffer.append(", ");
            buffer.append(nestedException().getMessage());
            buffer.append(")");
        }
        return buffer.toString();
    }

    /**
     *
     * @return
     */
    public Throwable nestedException() {
        return m_nestedException;
    }

    /**
     *
     */
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    /**
     *
     */
    public void printStackTrace(PrintStream p_s) {
        super.printStackTrace(p_s);
        if (nestedException() != null) {
            p_s.println("--- nested exception stack trace ---");
            nestedException().printStackTrace(p_s);
        }
    }

    /**
     *
     */
    public void printStackTrace(PrintWriter p_w) {
        super.printStackTrace(p_w);
        if (nestedException() != null) {
            p_w.println("--- nested exception stack trace ---");
            nestedException().printStackTrace(p_w);
        }
    }

}