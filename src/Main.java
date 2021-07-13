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
        testMailBody.setLevelRequired(3);
        testMailBody.setSlot(Slot.BODY);
        testMailBody.setArmorType(ArmorType.MAIL);
        testMailBody.setPrimary(new PrimaryAttributes(1,1,0,0));
        System.out.println("=============================");

        Armor testClothHead = new Armor();
        testClothHead.setName("Common Cloth Head Armor");
        testClothHead.setLevelRequired(2);
        testClothHead.setSlot(Slot.HEAD);
        testClothHead.setArmorType(ArmorType.CLOTH);
        testClothHead.setPrimary(new PrimaryAttributes( 0, 0, 5, 1));
        System.out.println("=============================");

        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(2);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.NONE);
        testAxe.setDamage(20);
        testAxe.setAttackSpeed(0.5);
        testAxe.setDamagePerSecond(20,0.5);

        //Setting values
        Character Neil = new Character();
        Neil.setPlayerClass(RpgClassType.WARRIOR);
        Neil.setPrimary(Neil.WARRIOR);
        Neil.setSecondary(Neil.WARRIORSEC);
        Neil.setLevel(4);
        Neil.setCharacterDamageBonus(RpgClassType.WARRIOR);
        Neil.setHead(testClothHead);
        Neil.equipArmor(Slot.HEAD, testClothHead);
        Neil.equipArmor(Slot.BODY, testMailBody);
        Neil.equipWeapon(Slot.WEAPON, testAxe);
        Neil.setCharacterDps(Neil.getPrimary().getTotalPrimaryAttributes(), Neil.equippedWeapon.get(Slot.WEAPON).getDamagePerSecond() );

        //Getting Values
        try{
            System.out.println(Neil.getPlayerClass());
            System.out.println("=============================");
            System.out.println(Neil.attributesToString());

            Neil.showArmor(Slot.HEAD);
            System.out.println("Character DPS: " + Neil.getCharacterDps());
            System.out.println("Character DPS: " + Neil.getCharacterDps());
            System.out.println(Neil.getCharacterDamageBonus());
      //  }catch (NullPointerException e){System.out.println(e);
        }catch(InvalidArmorException e){
            System.out.println(e);
        }
    }
}
