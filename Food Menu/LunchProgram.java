import java.util.ArrayList;
import java.util.Scanner;

public class LunchProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Menu-ndee hool oruulna.

        ArrayList<Food> menu = new ArrayList<>();
        menu.add(new Tsuivan());
        menu.add(new Khuushuur());
        menu.add(new Buuz());

        // Hoolnii songoltuudaa haruulna.

        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i).getName());
        }

        System.out.print("Doorh 3 hoolnoos negiig ni songono uu? (1-" + menu.size() + "): ");
        int choice = scanner.nextInt();
        while (choice < 1 || choice > menu.size()) {
            System.out.print("1-" + menu.size() + " hoorond too oruulna uu");
            choice = scanner.nextInt();
        }

        Food selectedFood = menu.get(choice - 1);

        System.out.print(selectedFood.getName() + ": ");
        int amount = scanner.nextInt();

        LunchOrder order = new LunchOrder();
        order.addFood(selectedFood, amount);

        System.out.println("- Niit calorie: " + order.getTotalCalories());
        System.out.println("- Niit une: " + order.getTotalPrice());
    }
}

 
abstract class Food {
    private String name;
    private int caloriesPerGram;
    private double pricePerGram;
 
    public Food(String name, int caloriesPerGram, double pricePerGram) {
        this.name = name;
        this.caloriesPerGram = caloriesPerGram;
        this.pricePerGram = pricePerGram;
    }
 
    public String getName() {
        return name;
    }
 
    public int getCaloriesPerGram() {
        return caloriesPerGram;
    }
 
    public double getPricePerGram() {
        return pricePerGram;
    }
 
    public abstract double getUnitSize();
}
 
class Mah extends Food {
    public Mah() {
        super("Mah", 2, 0.05);
    }
 
    public double getUnitSize() {
        return 12350*0.2;
    }
}
 
class Guril extends Food {
    public Guril() {
        super("Guril", 3, 0.01);
    }
 
    public double getUnitSize() {
        return 2595*0.2;
    }
}
 
class Tums extends Food {
    public Tums() {
        super("Tums", 1, 0.02);
    }
 
    public double getUnitSize() {
        return 1690*0.2;
    }
}
 
class Songino extends Food {
    public Songino() {
        super("Songino", 1, 0.02);
    }
 
    public double getUnitSize() {
        return 3708*0.2;
    }
}

class Tsuivan extends Food {
    private Mah Mah;
    private Guril Guril;
    private Songino Songino;
 
    public Tsuivan() {
        super("Tsuivan", 4, 0.08);
        this.Mah = new Mah();
        this.Guril = new Guril();
        this.Songino = new Songino();
    }
 
    public double getUnitSize() {
        return Mah.getUnitSize() + Guril.getUnitSize() + Songino.getUnitSize();
    }
}
 
class Khuushuur extends Food {
    private Mah Mah;
    private Guril Guril;
 
    public Khuushuur() {
        super("Khuushuur", 5, 0.05);
        this.Mah = new Mah();
        this.Guril = new Guril();
    }
 
    public double getUnitSize() {
        return Mah.getUnitSize() + Guril.getUnitSize();
    }
}
 
class Buuz extends Food {
    private Mah Mah;
    private Guril Guril;
    private Songino Songino;
 
    public Buuz() {
        super("Buuz", 6, 0.08);
        this.Mah = new Mah();
        this.Guril = new Guril();
    }

    public double getUnitSize() {
        return Mah.getUnitSize() + Guril.getUnitSize();
    }
}

class LunchOrder{
    private ArrayList<Food> foods;
    private ArrayList<Integer> amounts;

    public LunchOrder() {
        this.foods = new ArrayList<>();
        this.amounts = new ArrayList<>();
    }
     
    public void addFood(Food food, int amount) {
        foods.add(food);
        amounts.add(amount);
    }
     
    public int getTotalCalories() {
        int totalCalories = 0;
        for (int i = 0; i < foods.size(); i++) {
            totalCalories += amounts.get(i) * foods.get(i).getCaloriesPerGram();
        }
        return totalCalories;
    }
     
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (int i = 0; i < foods.size(); i++) {
            totalPrice += amounts.get(i) * foods.get(i).getPricePerGram() * foods.get(i).getUnitSize();
        }
        return totalPrice;
    }
}