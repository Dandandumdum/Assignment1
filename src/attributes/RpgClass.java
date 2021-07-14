package attributes;

public class RpgClass {
    private RpgClassType type;
    private PrimaryAttributes attributes;


    public RpgClass(RpgClassType type, PrimaryAttributes attributes ){
        this.setType(type);

    }
    public RpgClass(){
            }

    public RpgClassType getType() {
        return type;
    }

    public void setType(RpgClassType type) {
        this.type = type;
    }


}
