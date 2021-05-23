package pizzeria.main.model;

public class Pizza {
    private int type;
    private int size;
    private int quantity;
    private int cost;
    private int originalCost;
    private boolean choosed;

    public Pizza(int type, int size, int quantity, int cost, int originalCost, boolean choosed) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.cost = cost;
        this.originalCost = originalCost;
        this.choosed = choosed;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getOriginalCost() {
        return originalCost;
    }

    public void setOriginalCost(int originalCost) {
        this.originalCost = originalCost;
    }

    public boolean isChoosed() {
        return choosed;
    }

    public void setChoosed(boolean choosed) {
        this.choosed = choosed;
    }
}
