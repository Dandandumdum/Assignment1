package attributes;

public class PrimaryAttributes {
    private int strength;
    private int dexterity;
    private int intelligence;
    private int vitality;
    private int totalPrimaryAttributes;

    public PrimaryAttributes( int str, int dex, int intl, int vit){
        this.setStrength(str);
        this.setDexterity(dex);
        this.setIntelligence(intl);
        this.setVitality(vit);
        this.setTotalPrimaryAttributes(getStrength(), getDexterity(),getIntelligence(),getVitality());
    }
    public PrimaryAttributes(){
        this.setTotalPrimaryAttributes(getStrength(), getDexterity(),getIntelligence(),getVitality());
    }


    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getVitality() {
        return vitality;
    }

    public void setVitality(int vitality) {
        this.vitality = vitality;
    }

    public int getTotalPrimaryAttributes() {
        return totalPrimaryAttributes;
    }
//Sets totalPrimaryAttributes to equal the sum of all primary attributes (Strength, dexterity, intelligence, vitality).
    public void setTotalPrimaryAttributes(int str, int dex, int intl ,int vit) {
        this.totalPrimaryAttributes = str+dex+vit+intl;
    }
}
