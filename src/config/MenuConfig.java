package config;

import menu.*;

import java.util.List;

public class MenuConfig {
    public static List<Menu> setMenu() {
        //커피 메뉴
        Menu americano = new Menu(Category.COFFEE, "Americano", 4500, "/Users/jinwoo/Desktop/kiosk-image/americano.jpeg");
        Menu cafeLatte = new Menu(Category.COFFEE, "CafeLatte", 5000, "/Users/jinwoo/Desktop/kiosk-image/cafeLatte.jpeg");
        Menu caramelMacchiato = new Menu(Category.COFFEE, "CarmelMacchiato", 5000, "/Users/jinwoo/Desktop/kiosk-image/caramelMacchiato.jpeg");
        Menu icecreamLatte = new Menu(Category.COFFEE, "IcecreamLatte", 6000, "/Users/jinwoo/Desktop/kiosk-image/icecreamLatte.jpeg");

        //음료 메뉴
        Menu grapefruitAde = new Menu(Category.DRINKS, "GrapefruitAde", 5800, "/Users/jinwoo/Desktop/kiosk-image/grapefruitAde.jpeg");
        Menu orangeAde = new Menu(Category.DRINKS, "OrangeAde", 5800, "/Users/jinwoo/Desktop/kiosk-image/orangeAde.jpeg");
        Menu chocolateLatte = new Menu(Category.DRINKS, "GrapeFruitAde", 6000, "/Users/jinwoo/Desktop/kiosk-image/chocolateLatte.jpeg");
        Menu milkTeaShake = new Menu(Category.DRINKS, "GrapeFruitAde", 6000, "/Users/jinwoo/Desktop/kiosk-image/milkTeaShake.jpeg");

        //케이크
        Menu strawberryCake = new Menu(Category.CAKE, "StrawberryCake", 5500, "/Users/jinwoo/Desktop/kiosk-image/strawberryCake.jpeg");
        Menu redvelvetCake = new Menu(Category.CAKE, "RedvelvetCake", 5500, "/Users/jinwoo/Desktop/kiosk-image/redvelvetCake.jpeg");
        Menu cheeseCake = new Menu(Category.CAKE, "CheeseCake", 5500, "/Users/jinwoo/Desktop/kiosk-image/cheeseCake.jpeg");

        return List.of(americano, cafeLatte, caramelMacchiato, icecreamLatte,
                grapefruitAde, orangeAde, chocolateLatte, milkTeaShake,
                strawberryCake, redvelvetCake, cheeseCake);
    }
}
