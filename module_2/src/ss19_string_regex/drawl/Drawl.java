package ss19_string_regex.drawl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Drawl {
    public static void main(String[] args) {
        URL url = null;
        URLConnection urlConnection = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuffer = new StringBuilder();
        try {
            url = new URL("https://dantri.com.vn/the-gioi.htm");
            urlConnection = url.openConnection();
            bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                stringBuffer.append(line);
            }
        } catch (MalformedURLException e) {
            System.out.println("MalformedURL");
        } catch (IOException e) {
            System.out.println("IOE");
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.out.println("IOE");
            }
        }

        String regex1 = "\\<h[1-6].*?\\</h[1-6]\\>";
        Pattern pattern1 = Pattern.compile(regex1);
        Matcher matcher1 = pattern1.matcher(stringBuffer);

        List<String> list = new ArrayList<>();
        while (matcher1.find()) {
            String stringMatch = matcher1.group();
            list.add(stringMatch);
        }

        List<String> listAnalyze = new ArrayList<>();
        String regex2 = "\\<a.*?\\</a\\>";
        Pattern pattern2 = Pattern.compile(regex2);
        for (String string : list) {
            Matcher matcher2 = pattern2.matcher(string);
            if (matcher2.find()) {
                String stringMatch = matcher2.group();
                listAnalyze.add(stringMatch);
            }
        }

        List<String> listAnalyzeFinal = new ArrayList<>();
        for (String string : listAnalyze) {
            String[] stringList = string.split("[\\>\\<\\;]");
            String title = stringList[2];
            title = title.replaceAll("\\&quot", "\"").trim();
            System.out.println();
            listAnalyzeFinal.add(title);

            System.out.println(title);
        }
    }
}
