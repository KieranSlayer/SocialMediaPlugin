package me.kieranslayer.sm.updater;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Updater {
    private static Updater instance = new Updater();
    private static String BASE_URL = "https://api.spiget.org/v1/resources/";

    public Updater() {
    }

    /** @deprecated */
    @Deprecated
    public static boolean getResource(String name, double currentversion) {
        String url = BASE_URL + name;
        String content = "";
        double version = 0.0D;

        try {
            HttpURLConnection con = createConnection(url);

            BufferedReader br;
            String input;
            for(br = new BufferedReader(new InputStreamReader(con.getInputStream())); (input = br.readLine()) != null; content = content + input) {
                ;
            }

            br.close();
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        new JsonObject();
        JsonParser parser = new JsonParser();
        JsonObject statistics = (JsonObject)parser.parse(content);

        try {
            version = statistics.get("version").getAsDouble();
        } catch (Exception var11) {
            ;
        }

        return version > currentversion;
    }

    public static boolean getResource(int ID, double currentversion) {
        String url = BASE_URL + ID;
        String content = "";
        double version = 0.0D;

        try {
            HttpURLConnection con = createConnection(url);

            BufferedReader br;
            String input;
            for(br = new BufferedReader(new InputStreamReader(con.getInputStream())); (input = br.readLine()) != null; content = content + input) {
                ;
            }

            br.close();
        } catch (Exception var12) {
            var12.printStackTrace();
        }

        new JsonObject();
        JsonParser parser = new JsonParser();
        JsonObject statistics = (JsonObject)parser.parse(content);

        try {
            version = statistics.get("version").getAsDouble();
        } catch (Exception var11) {
            ;
        }

        return version > currentversion;
    }

    private static HttpURLConnection createConnection(String s) throws Exception {
        URL url = new URL(s);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.setUseCaches(true);
        connection.addRequestProperty("User-Agent", "Mozilla/4.76");
        connection.setDoOutput(true);
        return connection;
    }
}
