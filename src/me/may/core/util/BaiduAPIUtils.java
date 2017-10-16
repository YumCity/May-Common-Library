package me.may.core.util;

import org.bukkit.configuration.file.FileConfiguration;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Create By IDEA
 *
 * @author May_Speed
 * @since 2017-09-10
 */
public class BaiduAPIUtils {

    public static String getIPInformation(String ip, String apiKey) {
        BufferedReader reader = null;
        String result = null;
        StringBuffer sbf = new StringBuffer();
        StringBuilder http = new StringBuilder("http://apis.baidu.com/bdyunfenxi/intelligence/ip?ip=");
        http.append(ip);

        try {
            URL url = new URL(http.toString());
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            // 设置请求方法
            connection.setRequestMethod("GET");
            // 填入apikey
            connection.setRequestProperty("apikey",  apiKey);
            connection.connect();

            InputStream is = connection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String strRead = null;
            while ((strRead = reader.readLine()) != null) {
                sbf.append(strRead);
                sbf.append("\r\n");
            }
            reader.close();
            result = sbf.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
