package menu;

public class Menu {
    private final Category category;
    private final String name;
    private final int price;
    private final String imgUrl;

    public Menu(Category category, String name, int price, String imgUrl) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public boolean isTypeOf(String category) {
        return category.toUpperCase().equals(this.category.name());
    }
}
