import Items.*;
import attributes.PrimaryAttributes;
import attributes.RpgClassType;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Armor testMailBody = new Armor();
        testMailBody.setName("Shiny Mail Body Armor");
        testMailBody.setLevelRequired(4);
        testMailBody.setSlot(Slot.BODY);
        testMailBody.setArmorType(ArmorType.MAIL);
        testMailBody.setPrimary(new PrimaryAttributes(1,1,0,0));

        Armor testClothHead = new Armor();
        testClothHead.setName("Common Mail Head Armor");
        testClothHead.setLevelRequired(1);
        testClothHead.setSlot(Slot.HEAD);
        testClothHead.setArmorType(ArmorType.MAIL);
        testClothHead.setPrimary(new PrimaryAttributes( 3, 0, 0, 2));

        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(1);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.AXE);
        testAxe.setDamage(20);
        testAxe.setAttackSpeed(0.5);

        //Setting values
        Character Neil = new Character();
        Neil.setPlayerClass(RpgClassType.WARRIOR);
        Neil.setPrimary(Neil.WARRIOR);
        Neil.setSecondary(Neil.WARRIORSEC);
        Neil.setLevel(1);
        Neil.setCharacterDamageBonus(RpgClassType.WARRIOR);
        Neil.equipArmor(Slot.HEAD, testClothHead);
        Neil.equipArmor(Slot.BODY, testMailBody);
        Neil.equipWeapon(Slot.WEAPON, testAxe);


        //Getting Values
        try{
            System.out.println(Neil.getPlayerClass());
            System.out.println("=============================");
            System.out.println(Neil.attributesToString());
            Neil.levelUp(RpgClassType.WARRIOR);
            Neil.showArmor(Slot.HEAD);
            System.out.println("Character DPS: " + Neil.getCharacterDps());
            System.out.println(Neil.getWeaponDps());


           // Character John = new Character(RpgClassType.ROGUE, 3);


      //  }catch (NullPointerException e){System.out.println(e);
        }catch(InvalidArmorException e){
            System.out.println(e);
        }
    }
}
