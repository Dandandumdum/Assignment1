package Items;

public abstract class Item{ //Make enum with stats
        private String name;
        private Slot slot;
        private int levelRequired;


        public Item(String name, int levelRequired, Slot slot){
            this.setName(name);
            this.setLevelRequired(levelRequired);
            this.setSlot(slot);
        }
        public Item(){//Blank constructor

        }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Slot getSlot() {
        return slot;
    }
    public void setSlot(Slot slot) {
        this.slot = slot;
    }
    public int getLevelRequired() {
        return levelRequired;
    }

    public void setLevelRequired(int levelRequired) {
        this.levelRequired = levelRequired;
    }
}
