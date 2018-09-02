package utilclass;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hg_yi on 17-6-2.
 *
 * @Description: MD5压缩算法
 */

public class MD5 {
    public static Set<String> getMD5Urls(Set<String> preUrls) {
        String s;
        Set<String> lastUrls = new HashSet<String>();

        //用来将字节转换为成16进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest md = MessageDigest.getInstance("MD5");

            for (String url : preUrls) {
                byte[] source = url.getBytes();
                md.update(source);

                //MD5的运算结果是一个128位的长整数，用字节来表示就是16字节
                byte tmp[] = md.digest();

                //每个字节用16进制表示，使用两个字符，将结果完全表示为16进制则需要32字节
                char str[] = new char[16 * 2];

                int k = 0;
                //从第一个字节开始，将MD5中的每个字节转换成十六进制字符
                for (int i = 0; i < 16; i++) {
                    byte byte0 = tmp[i];

                    //取字节高4位的数字进行转换，“>>>”为逻辑右移，将符号位一起右移（忽略符号位）
                    str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                    //取字节中低4位的的数字进行转换
                    str[k++] = hexDigits[byte0 & 0xf];
                }

                s = new String(str);
                lastUrls.add(s);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return lastUrls;
    }

    public static Set<String> getUrls(Set<String> urlsMD5) {
        Set<String> urls = new HashSet<String>();

        for (String url : urlsMD5) {
            byte[] a = url.getBytes();

            for (int i = 0; i < a.length; i++) {
                a[i] = (byte) (a[i] ^ 't');
            }

            String k = new String(a);
            urls.add(k);
        }

        return  urls;
    }
}