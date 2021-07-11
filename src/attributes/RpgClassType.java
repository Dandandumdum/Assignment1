package attributes;

public enum RpgClassType {

    MAGE,
    RANGER,
    ROGUE,
    WARRIOR,
    //Attempt at have initialized attributes
    MAGE2(new SecondaryAttributes(1,1,8,5,1,1,1)),
    RANGER2(new SecondaryAttributes(1,7,1,8,0,0,0)),
    ROGUE2(new SecondaryAttributes(2,6,1,8,0,0,0)),
    WARRIOR2(new SecondaryAttributes(5,2,1,10,1,1,1));

    private SecondaryAttributes secondary;
    RpgClassType(SecondaryAttributes secondary){
        this.setSecondary(secondary);
    }
     RpgClassType(){
            }

    public SecondaryAttributes getSecondary() {

        return secondary;
    }

    public void setSecondary(SecondaryAttributes secondary) {
        this.secondary = secondary;
    }
}
