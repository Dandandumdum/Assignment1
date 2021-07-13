public class InvalidWeaponException extends RuntimeException{
    public InvalidWeaponException(String errorMessage){
        errorMessage.equals("Invalid Weapon Selection");
        System.out.println(errorMessage);
    }
}
