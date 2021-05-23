package pizzeria.main.model;

public class Pizza {
    private int type;
    private int size;
    private int quantity;
    private int cost;
    private int originalCost;
    private boolean choosed;

    public Pizza(int type, int size, int quantity, int originalCost, boolean choosed) {
        this.type = type;
        this.size = size;
        this.quantity = quantity;
        this.originalCost = originalCost;
        this.cost = quantity * originalCost;
        this.choosed = choosed;
    }

    public int getType() {
        return type;
    }

    public String getTypeName() {
        switch (type) {
            case 1:
                return "Пицца Пепперони";
            case 2:
                return "Пицца Барбекю";
            case 3:
                return "Пицца Жульетта";
            case 4:
                return "Пицца 4 сыра";
            case 5:
                return "Пицца Мясное Ассорти";
            case 6:
                return "Пицца Маргарита";
            case 7:
                return "Пицца Чизбургер";
            case 8:
                return "Пицца 4 вкуса";
            default:
                return "Null Pizza";
        }
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
        cost = quantity * originalCost;
        return cost;
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
