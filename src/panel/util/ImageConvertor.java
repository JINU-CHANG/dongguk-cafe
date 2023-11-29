package panel.util;

import javax.swing.*;
import java.awt.*;

public class ImageConvertor {
    public static ImageIcon adjustSize(String imgUrl, int width, int height) {
        //이미지 추출
        Image image = new ImageIcon(imgUrl).getImage();
        //추출된 Image의 크기를 조절하여 새로운 Image 객체 생성
        Image scaledImg = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
