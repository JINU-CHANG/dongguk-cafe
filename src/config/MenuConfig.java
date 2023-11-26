package config;

import menu.*;
import menu.option.CoffeeBeans;
import menu.option.Cup;
import menu.option.Size;
import menu.option.Temperature;

import java.util.List;

public class MenuConfig {
    public static List<Menu> setMenu() {

        List<Temperature> onlyIce = List.of(Temperature.ICE);
        List<Temperature> allTemperature = List.of(Temperature.HOT, Temperature.ICE);
        List<Size> allSize = List.of(Size.REGULAR, Size.LARGE, Size.MAX);
        List<Cup> allCup = List.of(Cup.STORE_CUP, Cup.PERSONAL_CUP);
        List<CoffeeBeans> allCoffeeBeans = List.of(CoffeeBeans.블랙그라운드, CoffeeBeans.아로마노트, CoffeeBeans.디카페인);

        //커피 메뉴
        Menu americano = new Coffee(Category.COFFEE, "Americano", 4500, "/Users/jinwoo/Desktop/kiosk-image/americano.jpeg", allTemperature, allSize, allCup, allCoffeeBeans);
        Menu cafeLatte = new Coffee(Category.COFFEE, "CafeLatte", 5000, "/Users/jinwoo/Desktop/kiosk-image/cafeLatte.jpeg", allTemperature, allSize, allCup, allCoffeeBeans);
        Menu caramelMacchiato = new Coffee(Category.COFFEE, "CarmelMacchiato", 5000, "/Users/jinwoo/Desktop/kiosk-image/caramelMacchiato.jpeg", allTemperature, allSize, allCup, allCoffeeBeans);
        Menu icecreamLatte = new Coffee(Category.COFFEE, "IcecreamLatte", 6000, "/Users/jinwoo/Desktop/kiosk-image/icecreamLatte.jpeg", allTemperature, allSize, allCup, allCoffeeBeans);

        //음료 메뉴
        Menu grapefruitAde = new Drink(Category.DRINKS, "GrapefruitAde", 5800, "/Users/jinwoo/Desktop/kiosk-image/grapefruitAde.jpeg", onlyIce, allSize, allCup);
        Menu orangeAde = new Drink(Category.DRINKS, "OrangeAde", 5800, "/Users/jinwoo/Desktop/kiosk-image/orangeAde.jpeg", onlyIce, allSize, allCup);
        Menu chocolateLatte = new Drink(Category.DRINKS, "GrapeFruitAde", 6000, "/Users/jinwoo/Desktop/kiosk-image/chocolateLatte.jpeg", onlyIce, allSize, allCup);
        Menu milkTeaShake = new Drink(Category.DRINKS, "GrapeFruitAde", 6000, "/Users/jinwoo/Desktop/kiosk-image/milkTeaShake.jpeg", onlyIce, allSize, allCup);

        //케이크
        Menu strawberryCake = new Cake(Category.CAKE, "StrawberryCake", 5500, "/Users/jinwoo/Desktop/kiosk-image/strawberryCake.jpeg");
        Menu redvelvetCake = new Cake(Category.CAKE, "RedvelvetCake", 5500, "/Users/jinwoo/Desktop/kiosk-image/redvelvetCake.jpeg");
        Menu cheeseCake = new Cake(Category.CAKE, "CheeseCake", 5500, "/Users/jinwoo/Desktop/kiosk-image/cheeseCake.jpeg");

        return List.of(americano, cafeLatte, caramelMacchiato, icecreamLatte,
                grapefruitAde, orangeAde, chocolateLatte, milkTeaShake,
                strawberryCake, redvelvetCake, cheeseCake);
    }
}
