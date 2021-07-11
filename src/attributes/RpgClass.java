package attributes;

public class RpgClass {
    private RpgClassType type;
    private SecondaryAttributes attributes;

    public RpgClass(RpgClassType type, SecondaryAttributes attributes){
        this.setType(type);
        this.setAttributes(attributes);

    }
    public RpgClass(){
            }

    public RpgClassType getType() {
        return type;
    }

    public void setType(RpgClassType type) {
        this.type = type;
    }

    public SecondaryAttributes getAttributes() {
        return attributes;
    }

    public void setAttributes(SecondaryAttributes attributes) {
        this.attributes = attributes;
    }
}
