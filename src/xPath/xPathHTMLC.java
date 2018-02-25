package xPath;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class xPathHTMLC {


    private static String path;
    private static String xPathExpression;
    private static String data;

    public static void main(String[] args) {
        getData();
        parseData();
        showData();
    }

    private static void showData() {
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode html = cleaner.clean(data);

        Object[] myNodes = new Object[0];
        try {
            myNodes = html.evaluateXPath(xPathExpression);
        } catch (XPatherException e) {
            System.out.println("Неверный expression");
        }

        for (Object myNode : myNodes) {
            TagNode tg = (TagNode) myNode;
            System.out.println(tg.getText());
        }


    }

    private static void parseData() {
        URL url = null;
        try {
            url = new URL(path);
        } catch (MalformedURLException e) {
            System.out.println("Неправильный адрес сайта");
        }

        StringBuilder outputLine = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                outputLine.append(inputLine);
            }
        } catch (IOException e) {
            System.out.println("Неправильный адрес сайта");
        }

        data = outputLine.toString();

    }

    private static void getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес сайта");
        path = scanner.next();
        System.out.println("Введите xPath выражение");
        xPathExpression = scanner.next();
    }
}
