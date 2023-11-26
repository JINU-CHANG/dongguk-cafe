package menu;

import menu.option.CoffeeBeans;
import menu.option.Cup;
import menu.option.Size;
import menu.option.Temperature;

import java.util.List;

public class Coffee extends Drink{
    private final List<CoffeeBeans> coffeeBeans;

    public Coffee(Category category, String name, int price, String imgUrl, List<Temperature> temperatures, List<Size> sizes, List<Cup> cups, List<CoffeeBeans> coffeeBeans) {
        super(category, name, price, imgUrl, temperatures, sizes, cups);
        this.coffeeBeans = coffeeBeans;
    }
}
