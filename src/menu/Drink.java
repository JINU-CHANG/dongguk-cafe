package menu;

import menu.option.Cup;
import menu.option.Size;
import menu.option.Temperature;

import java.util.List;

public class Drink extends Menu{
    private final List<Temperature> temperatures;
    private final List<Size> sizes;
    private final List<Cup> cups;

    public Drink(String name, int price, String imgUrl, List<Temperature> temperatures, List<Size> sizes, List<Cup> cups) {
        super(name, price, imgUrl);
        this.temperatures = temperatures;
        this.sizes = sizes;
        this.cups = cups;
    }
}
