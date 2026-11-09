import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Backpack inventory = new Backpack("Adventurer Inventory");
        Backpack supplies = new Backpack("Supplies Pouch");

        supplies.add(new Item("Potion", 1));
        supplies.add(new Item("Rope", 3));

        inventory.add(new Item("Sword", 5));
        inventory.add(new Item("Shield", 4));
        inventory.add(supplies);

        inventory.display("");

        // Type the live challenge code here while recording.
    }
}

abstract class InventoryComponent {
    protected String name;

    public InventoryComponent(String name) {
        this.name = name;
    }

    public void add(InventoryComponent component) {
        throw new UnsupportedOperationException(
            "Cannot add items to a single item."
        );
    }

    public abstract int getWeight();

    public abstract void display(String indent);
}

class Item extends InventoryComponent {
    private int weight;

    public Item(String name, int weight) {
        super(name);
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + name + " (" + weight + " kg)");
    }
}

class Backpack extends InventoryComponent {
    private ArrayList<InventoryComponent> contents = new ArrayList<>();

    public Backpack(String name) {
        super(name);
    }

    @Override
    public void add(InventoryComponent component) {
        contents.add(component);
    }

    @Override
    public int getWeight() {
        int total = 0;

        for (InventoryComponent component : contents) {
            total += component.getWeight();
        }

        return total;
    }

    @Override
    public void display(String indent) {
        System.out.println(
            indent + name + " (total: " + getWeight() + " kg)"
        );

        for (InventoryComponent component : contents) {
            component.display(indent + "  ");
        }
    }
}
