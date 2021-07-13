package attributes;

public class RpgClass {
    private RpgClassType type;
    private PrimaryAttributes primaryAttributes;
    private SecondaryAttributes secondaryAttributes;

    public RpgClass(RpgClassType type, PrimaryAttributes primaryAttributes ,SecondaryAttributes secondaryAttributes){
        this.setType(type);
        this.setSecondaryAttributes(secondaryAttributes);

    }
    public RpgClass(){
            }

    public RpgClassType getType() {
        return type;
    }

    public void setType(RpgClassType type) {
        this.type = type;
    }

    public SecondaryAttributes getSecondaryAttributes() {
        return secondaryAttributes;
    }

    public void setSecondaryAttributes(SecondaryAttributes secondaryAttributes) {
        this.secondaryAttributes = secondaryAttributes;
    }

    public PrimaryAttributes getPrimaryAttributes() {
        return primaryAttributes;
    }

    public void setPrimaryAttributes(PrimaryAttributes primaryAttributes) {
        this.primaryAttributes = primaryAttributes;
    }
}
