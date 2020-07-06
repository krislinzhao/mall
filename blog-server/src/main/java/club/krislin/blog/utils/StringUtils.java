package club.krislin.blog.utils;

import java.util.Random;

/**
 * @Package club.krislin.blog.utils
 * @ClassName StringUtils
 * @Description TODO
 * @Date 20/7/3 13:19
 * @Author krislin
 * @Version V1.0
 */
public class StringUtils {
    public static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
