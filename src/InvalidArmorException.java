import attributes.*;

public class InvalidArmorException extends RuntimeException {
    public InvalidArmorException(String errorMessage){
        errorMessage.equals("Invalid armor selection.");
        System.out.println(errorMessage);
    }


}
