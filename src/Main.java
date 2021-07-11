import Items.Armor;
import Items.ArmorType;
import Items.Slot;
import Items.WeaponType;
import attributes.RpgClassType;

public class Main {

    public static void main(String[] args) {
        test();


    }

    public static void test(){
       /* Character Ben = new Character(RpgClassType.MAGE,1, WeaponType.WAND, Armor.CLOTH, ArmorType.CLOTH, ArmorType.CLOTH);//Need Item head, body, arm, and legs
        System.out.println(Ben.getPlayerClass() + " " + Ben.getLevel() + " " + Ben.getAttributes());
        System.out.println(Ben.getSecondary());//Null pointer exeptions
        System.out.println(RpgClassType.MAGE.getSecondary().toString()); */

        Armor testClothHead = new Armor();
        testClothHead.setName("Common Cloth Head Armor");
        testClothHead.setLevelRequired(2);
        testClothHead.setSlot(Slot.HEAD);
        testClothHead.setArmorType(ArmorType.CLOTH);
        System.out.println(testClothHead.getArmorType());
        System.out.println(testClothHead.getLevelRequired());
        System.out.println("=============================");
        //Setting values
        Character Neil = new Character();
        Neil.setPlayerClass(RpgClassType.WARRIOR);
        Neil.setSecondary(Neil.WARRIOR);
        Neil.setHead(testClothHead);
        Neil.setBody(testClothHead);//Must give error, slot wrong
        //Getting Values
        System.out.println(Neil.getSecondary().getStrength());
        System.out.println(Neil.getSecondary().getHealth());
        System.out.println(Neil.getPlayerClass());
        System.out.println(Neil.getAttributes());
        System.out.println(Neil.getHead().getName());
        System.out.println(Neil.getBody().getName());//Should not allow Head items
    }
}
