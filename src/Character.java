import Items.*;
import attributes.RpgClassType;
import attributes.PrimaryAttributes;


import java.util.HashMap;

public class Character {
    private int level;
    private RpgClassType rpgClassType;
    private PrimaryAttributes primary;
    private int health;
    private int armorRating;
    private int elementalResistance;
    private double characterDps;
    private double weaponDps;
    private double characterDamageBonus;
    HashMap<Slot, Armor> equippedArmor = new HashMap<Slot, Armor>();
    HashMap<Slot, Weapon> equippedWeapon = new HashMap<Slot, Weapon>();


        public Character(){
            this.setLevel(1);//Initialize new instance of a character at level 1
        }

        public Character(RpgClassType rpgClassType, int level){
        this.setPlayerClass(rpgClassType);
        this.setLevel(level);
        this.setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
        this.setCharacterDamageBonus(getPlayerClass());

    }
    //Initializes Attributes at lvl One based upon character rpg class
    PrimaryAttributes WARRIOR = new PrimaryAttributes(5,2,1,10);
    PrimaryAttributes MAGE = new  PrimaryAttributes(1,1,8,5);
    PrimaryAttributes RANGER = new  PrimaryAttributes(1,7,1,8);
    PrimaryAttributes ROUGE = new  PrimaryAttributes(2,6,1,8);

    // returns a string of primary and secondary attributes
    public String attributesToString(){
        return "Strength: " + getPrimary().getStrength() +" Dexterity: " + getPrimary().getDexterity()
                +" Intelligence: "+ getPrimary().getIntelligence() +" Vitality: "+ getPrimary().getVitality() +
                " Health: " + getHealth() +" Armor Rating: "+ getArmorRating()
                +" Elemental Resistance: " + getElementalResistance() + " Character Dps: " +getCharacterDps()
                + " Level: " + getLevel();

    }
    //sets secondary attributes based upon primary attributes
    public void setSecondaryAttributes(int vit, int str, int dex, int intl ){
        setHealth(vit*10);
        setArmorRating(str + dex);
        setElementalResistance(intl);
    }

    //Equips armor to specified slot on character, if allowed (within level requirements and acceptable player class type).
    public boolean equipArmor(Slot slot, Armor armor) throws InvalidArmorException {
       try{
           if (armor.getLevelRequired() > getLevel()){
                  throw new InvalidArmorException("");
           }else if(!armorClassCheck(getPlayerClass(), armor.getArmorType())){
               throw new InvalidArmorException("Invalid Armor Selection, "+ getPlayerClass() + " may not equip "
                                                + armor.getArmorType());
           }else{
               if (slot == Slot.HEAD){
                   equippedArmor.put(Slot.HEAD, armor);
                   setPrimary(new PrimaryAttributes((getPrimary().getStrength() + armor.getPrimary().getStrength()) ,
                           (getPrimary().getDexterity() + armor.getPrimary().getDexterity()) ,
                           (getPrimary().getIntelligence() + armor.getPrimary().getIntelligence()) ,
                           (getPrimary().getVitality() + armor.getPrimary().getVitality())));
                   setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());
                   return true;

               }else if (slot == Slot.BODY){
                   equippedArmor.put(Slot.BODY, armor);
                   setPrimary(new PrimaryAttributes((getPrimary().getStrength() + armor.getPrimary().getStrength()) ,
                           (getPrimary().getDexterity() + armor.getPrimary().getDexterity()) ,
                           (getPrimary().getIntelligence() + armor.getPrimary().getIntelligence()) ,
                           (getPrimary().getVitality() + armor.getPrimary().getVitality())));
                   setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());
                   return true;
               }else if (slot == Slot.LEGS){
                   equippedArmor.put(Slot.LEGS, armor);
                   setPrimary(new PrimaryAttributes((getPrimary().getStrength() + armor.getPrimary().getStrength()) ,
                           (getPrimary().getDexterity() + armor.getPrimary().getDexterity()) ,
                           (getPrimary().getIntelligence() + armor.getPrimary().getIntelligence()) ,
                           (getPrimary().getVitality() + armor.getPrimary().getVitality())));
                   setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());
                   return true;
               }else
                   System.out.println( armor.getName() +" cannot be placed in the " + slot +" slot." );
                    return false;
                              }
           } catch(InvalidArmorException e){
           throw new InvalidArmorException("Invalid armor selection, level too high. Level required: " + armor.getLevelRequired()
                   + ", current player level:  " + getLevel());

       }


    }
    //shows armor in a specified slot, if slot is allowed
    public void showArmor(Slot slot) {

        try {
            if (slot == Slot.HEAD) {
                System.out.println(equippedArmor.get(Slot.HEAD).toString());
            } else if (slot == Slot.BODY) {
                System.out.println(equippedArmor.get(Slot.BODY).toString());
            } else if (slot == Slot.LEGS) {
                System.out.println(equippedArmor.get(Slot.LEGS).toString());
            } else
                System.out.println("Armor cannot be worn in that slot.");
        } catch(NullPointerException e){
            System.out.println(e);
        }

    }
    //Equips weapon in specified slot, if that slot is legal, and the player class may equip a weapon of that type
    public  boolean equipWeapon(Slot slot, Weapon weapon) throws InvalidWeaponException {

        try{
            if (weapon.getLevelRequired() > getLevel()){
               throw new InvalidWeaponException("");
            }else if(!weaponClassCheck(getPlayerClass(), weapon.getWeaponType())){
                throw new InvalidWeaponException("Invalid Weapon Selection, "+ getPlayerClass()+ " may not equip "+
                        weapon.getWeaponType());
            }
            else{
                if (slot == Slot.WEAPON){
                    equippedWeapon.put(Slot.WEAPON, weapon);
                    setWeaponDps(equippedWeapon.get(Slot.WEAPON).getDamage(), equippedWeapon.get(Slot.WEAPON).getAttackSpeed());
                    return true;
                }else
                    System.out.println("Weapon cannot be place in that slot.");
                return false;
            }
        }catch(InvalidWeaponException e){
            throw new InvalidWeaponException("Invalid Weapon Selection, level requirement too high. Level required: " + weapon.getLevelRequired()
                    + ", current player level:  " + getLevel());

        }
    }
    //checks if the weapon type being equipped is compatible with the current player class type
    public boolean weaponClassCheck(RpgClassType classType, WeaponType weapon){

        if((weapon.equals(WeaponType.AXE) || weapon.equals(WeaponType.HAMMER)) && !classType.equals(RpgClassType.WARRIOR)){
            return false;
        }else if((weapon.equals(WeaponType.WAND) || weapon.equals(WeaponType.STAFF)) && !classType.equals(RpgClassType.MAGE)){
            return false;
        }else if(weapon.equals(WeaponType.BOW) && !classType.equals(RpgClassType.RANGER)){
            return false;
        }else if(weapon.equals(WeaponType.DAGGER) && !classType.equals(RpgClassType.ROGUE)){
            return false;
        }else if(weapon.equals(WeaponType.SWORD)&& (!classType.equals(RpgClassType.WARRIOR)|| !classType.equals(RpgClassType.ROGUE))){
            return false;
        }else{
            return true;
        }
    }
    // checks if the armor type being equipped is compatible with the current player class
    public boolean armorClassCheck(RpgClassType classType, ArmorType armor){

        if(armor.equals(ArmorType.PLATE)  && !classType.equals(RpgClassType.WARRIOR)){
            return false;
        }else if(armor.equals(ArmorType.CLOTH) && !classType.equals(RpgClassType.MAGE)){
            return false;
        }else if(armor.equals(ArmorType.LEATHER) && (!classType.equals(RpgClassType.RANGER) || !classType.equals(RpgClassType.ROGUE))){
            return false;
        }else if(armor.equals(ArmorType.MAIL) && (classType.equals(RpgClassType.MAGE))){
            return false;
        }else{
            return true;
        }
    }
    //Checks whether the player has a weapon equipped, returning a boolean
    public boolean hasWeaponEquipped(Slot slot){

        if (slot == null){
            return false;
        }return true;
    }
    //prints out information on the currently equipped weapon in the specified slot
    public void showWeapon(Slot slot){

        if(!hasWeaponEquipped(Slot.WEAPON)){
            System.out.println("No weapon equipped.");
        }else if(slot == Slot.WEAPON){
            System.out.println(equippedWeapon.get(Slot.WEAPON).toString());
        }

    }//Increases the player level by "levelUp" times, and raises primary attributes, characterDps and secondary attributes based upon class specifications
    public void levelUp(RpgClassType rpgClass, int levelUp) throws  IllegalArgumentException{

        try{
            if(levelUp < 1){
                throw new IllegalArgumentException("Level increased cannot be zero or less.");
            }else
                for (int i = 0; i < levelUp; i++) {
                    if (rpgClass.equals(RpgClassType.WARRIOR)){
                        setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 3, getPrimary().getDexterity() + 2, getPrimary().getIntelligence()+1, getPrimary().getVitality()+5));
                        setCharacterDamageBonus(RpgClassType.WARRIOR);
                        setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
                        setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());

                    }else if (rpgClass.equals(RpgClassType.MAGE)){
                        setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 1, getPrimary().getDexterity() + 1, getPrimary().getIntelligence()+5, getPrimary().getVitality()+3));
                        setCharacterDamageBonus(RpgClassType.MAGE);
                        setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
                        setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());

                    }else if (rpgClass.equals(RpgClassType.RANGER)){
                        setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 1, getPrimary().getDexterity() + 5, getPrimary().getIntelligence()+1, getPrimary().getVitality()+2));
                        setCharacterDamageBonus(RpgClassType.RANGER);
                        setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
                        setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());

                    }else if (rpgClass.equals(RpgClassType.ROGUE)){
                        setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 1, getPrimary().getDexterity() + 4, getPrimary().getIntelligence()+1, getPrimary().getVitality()+3));
                        setCharacterDamageBonus(RpgClassType.ROGUE);
                        setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
                        setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());
                    }
                }setLevel(getLevel() + levelUp);

        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }
    //Initializes the players primary attributes, characterDps, and secondary attributes, based upon RpgClassType.
    public void setClassAttribute(PrimaryAttributes rpgClassAttributes){
        setPrimary(rpgClassAttributes);
        setSecondaryAttributes(getPrimary().getVitality(), getPrimary().getStrength(),getPrimary().getDexterity(),getPrimary().getIntelligence());
        setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
    }
    //Sets class attributes based upon class and level, with checks for illegal inputs.
    public void classAttributes(RpgClassType rpgClassType ,int level){
        try{
            if(level < 1){
                throw new IllegalArgumentException("Level increased cannot be zero or less.");
            }else{
                if(level > 1){
                    if (rpgClassType.equals(RpgClassType.WARRIOR)){
                        setClassAttribute(WARRIOR);
                        setLevel(level);

                    }else if(rpgClassType.equals(RpgClassType.MAGE)){
                        setClassAttribute(MAGE);
                        setLevel(level);

                    }else if(rpgClassType.equals(RpgClassType.ROGUE)){
                        setClassAttribute(ROUGE);
                        setLevel(level);

                    }else if(rpgClassType.equals(RpgClassType.RANGER)){
                        setClassAttribute(RANGER);
                        setLevel(level);

                    }

                    for (int i = 0; i <= level ; i++) {
                        levelUp(rpgClassType, 1);
                    }
                }else{
                    if (rpgClassType.equals(RpgClassType.WARRIOR)){
                        setClassAttribute(WARRIOR);
                        setLevel(level);

                    }else if(rpgClassType.equals(RpgClassType.MAGE)){
                        setClassAttribute(MAGE);
                        setLevel(level);

                    }else if(rpgClassType.equals(RpgClassType.ROGUE)){
                        setClassAttribute(ROUGE);
                        setLevel(level);

                    }else if(rpgClassType.equals(RpgClassType.RANGER)){
                        setClassAttribute(RANGER);
                        setLevel(level);

                    }
                }
            }

            }catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }

    }
    public PrimaryAttributes getPrimary() {
        return primary;
    }

    public void setPrimary(PrimaryAttributes primary) {
        this.primary = primary;
    }

    public RpgClassType getPlayerClass() {
        return rpgClassType;
    }

    public void setPlayerClass(RpgClassType rpgClassType) {
        this.rpgClassType = rpgClassType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getCharacterDps() {
        return characterDps;
    }
    //Sets the character dps based upon primary attributes and weapon dps
    public void setCharacterDps(double totalPrimary, double weaponDps) {
        if(!hasWeaponEquipped(Slot.WEAPON)){
            this.characterDps = 1;
        }else{
            this.characterDps = (1+(totalPrimary/100) + characterDamageBonus) * weaponDps;
        }
    }

    public double getCharacterDamageBonus() {
        return characterDamageBonus;
    }
    //Sets Character bonus damage in percent based upon the current player class
    public void setCharacterDamageBonus(RpgClassType rpgClass) {
        if (rpgClass.equals(RpgClassType.WARRIOR)){
            this.characterDamageBonus = (double) getPrimary().getStrength() /100;
        }else if (rpgClass.equals(RpgClassType.MAGE)){
            this.characterDamageBonus = (double) getPrimary().getIntelligence() /100;
        }else if (rpgClass.equals(RpgClassType.RANGER)){
            this.characterDamageBonus = (double) getPrimary().getDexterity() /100;
        }else if (rpgClass.equals(RpgClassType.ROGUE)){
            this.characterDamageBonus = (double) getPrimary().getDexterity() /100;
        }
    }


    public double getWeaponDps() {
        return weaponDps;
    }
    //Sets the weaponDps based upon the weaponDamage and weaponAttackSpeed
    public void setWeaponDps(double damage, double attackSpeed) {
        if(hasWeaponEquipped(Slot.WEAPON)){
            this.weaponDps = damage * attackSpeed;
        }else{
            this.weaponDps = 1;
        }

    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmorRating() {
        return armorRating;
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = armorRating;
    }

    public int getElementalResistance() {
        return elementalResistance;
    }

    public void setElementalResistance(int elementalResistance) {
        this.elementalResistance = elementalResistance;
    }
}

