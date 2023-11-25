package panel;

import javax.swing.*;
import java.awt.*;

public class ImageSizeConvertor {
    public static ImageIcon adjustSize(ImageIcon icon, int width, int height) {
        // ImageIcon 객체에서 Image 추출
        Image img = icon.getImage();
        // 추출된 Image의 크기를 조절하여 새로운 Image 객체 생성
        Image scaledImg = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledImg);
    }
}
