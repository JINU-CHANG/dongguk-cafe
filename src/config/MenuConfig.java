package config;

import menu.Coffee;
import menu.Menu;
import menu.option.CoffeeBeans;
import menu.option.Cup;
import menu.option.Size;
import menu.option.Temperature;

import java.util.List;

public class MenuConfig {
    public static List<Menu> setMenu() {

        List<Temperature> possibleTemperature = List.of(Temperature.HOT, Temperature.ICE);
        List<Size> possibleSize = List.of(Size.REGULAR, Size.LARGE, Size.MAX);
        List<Cup> possibleCup = List.of(Cup.STORE_CUP, Cup.PERSONAL_CUP);
        List<CoffeeBeans> possibleCoffeeBeans = List.of(CoffeeBeans.블랙그라운드, CoffeeBeans.아로마노트, CoffeeBeans.디카페인);


        Menu americano = new Coffee("Americano", 4500, "/Users/jinwoo/Desktop/kiosk-image/americano.jpeg", possibleTemperature,
                possibleSize, possibleCup, possibleCoffeeBeans);

        Menu cafeLatte = new Coffee("CafeLatte", 5000, "/Users/jinwoo/Desktop/kiosk-image/cafeLatte.jpeg", possibleTemperature,
                possibleSize, possibleCup, possibleCoffeeBeans);

        Menu caramelMacchiato = new Coffee("CarmelMacchiato", 5000, "/Users/jinwoo/Desktop/kiosk-image/caramelMacchiato.jpeg", possibleTemperature,
                possibleSize, possibleCup, possibleCoffeeBeans);

        Menu icecreamLatte = new Coffee("IcecreamLatte", 6000, "/Users/jinwoo/Desktop/kiosk-image/icecreamLatte.jpeg", possibleTemperature,
                possibleSize, possibleCup, possibleCoffeeBeans);

        return List.of(americano, cafeLatte, caramelMacchiato, icecreamLatte);
    }
}
