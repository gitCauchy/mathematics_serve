package org.math.utils;

import com.alibaba.druid.util.Base64;
import org.math.entity.ValidateImage;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * <p>验证码工具类</p>
 *
 * @author Wuchunlei
 * @date 2023/5/5 9:45
 */
@Component
public class ValidateUtil {
    /**
     * Random 对象，用于产生随机数
     */
    private static final Random RANDOM = new Random();
    /**
     * 验证码图片宽度
     */
    private static final int CODE_PIC_WIDTH = 40;
    /**
     * 验证码图片高度
     */
    private static final int CODE_PIC_HEIGHT = 20;
    /**
     * 随机字符范围字符串
     */
    private static final String RANDOM_CHAR_SEQUENCE = "ABCDEFGHJKMNPQRSTUVWXYZabcdefghjkmnpqrstuvwxyz23456789";
    /**
     * 字体列表
     */
    private static final String[] FONT_NAMES = {"Dialog", "DialogInput", "SansSerif", "Serif", "Monospaced"};
    /**
     * 字体大小
     */
    private static final int FONT_SIZE = 25;
    /**
     * ValidateCode 对象，不需要每次都创建一个
     */
    private static ValidateImage validateImage;

    /**
     * 获得一个随机的字符
     *
     * @return 随机字符
     */
    private static char getRandomChar() {
        return RANDOM_CHAR_SEQUENCE.charAt(RANDOM.nextInt(RANDOM_CHAR_SEQUENCE.length() + 1));
    }

    private static Font getRandomFont() {
        return new Font(FONT_NAMES[RANDOM.nextInt(FONT_NAMES.length + 1)], Font.ITALIC, FONT_SIZE);
    }

    private static Color getRandomColor() {
        int red = RANDOM.nextInt(255);
        int green = RANDOM.nextInt(255);
        int blue = RANDOM.nextInt(255);
        return new Color(red, green, blue);
    }

    private static String drawImage(ByteArrayOutputStream output) {
        String value = "";
        BufferedImage bufferedImage = new BufferedImage(CODE_PIC_WIDTH, CODE_PIC_HEIGHT, BufferedImage.TYPE_3BYTE_BGR);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        // 设置背景颜色
        graphics2D.setBackground(getRandomColor());
        graphics2D.clearRect(0, 0, CODE_PIC_WIDTH, CODE_PIC_HEIGHT);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            char c = getRandomChar();
            stringBuilder.append(c);
            // 定义字符的坐标
            float x = i * 1.0F * CODE_PIC_WIDTH / 4;
            graphics2D.setFont(getRandomFont());
            graphics2D.setColor(getRandomColor());
            graphics2D.drawString(String.valueOf(c), x, CODE_PIC_HEIGHT - 5);
        }
        value = stringBuilder.toString();
        // 释放资源
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static ValidateImage getValidateImage() {
        // 检查内存中是否已经存在，存在直接使用，不存在创建一个对象
        validateImage = validateImage == null ? new ValidateImage() : validateImage;
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream()) {
            String value = drawImage(byteArrayOutputStream);
            String base64Str = Base64.byteArrayToBase64(byteArrayOutputStream.toByteArray());
            validateImage.setValue(value);
            validateImage.setBase64Str(base64Str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return validateImage;
    }
}
