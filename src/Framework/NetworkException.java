package Framework;

public class NetworkException extends Exception  {

    public NetworkException(Throwable cause, Object className, String message) {
        super(className +":"+message, cause);
        setDebuggingLog();
    }

    public NetworkException(Throwable cause, Object className) {
        super(className +":" + "Error no especificado", cause);
        setDebuggingLog();
    }

    public NetworkException(String message) {
        super("Error en clase no especificada "+":"+message);
        setDebuggingLog();
    }

    void setDebuggingLog(){
        System.out.println("-------------------------");
        System.out.println("{AppException}");
        System.out.println(getMessage());
        System.out.println(getCause());
        System.out.println("-------------------------");
    }
}
