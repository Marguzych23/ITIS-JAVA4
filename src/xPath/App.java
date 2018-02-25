package xPath;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import org.htmlcleaner.HtmlCleaner;
import org.htmlcleaner.TagNode;
import org.htmlcleaner.XPatherException;

import javax.xml.xpath.*;

public class App {

    private static String path;
    private static String reg;

    public static void main(String[] args) {
        getData();
        parseAndShow(path, reg);
    }

    private static void parseAndShow(String Url, String xpath)  {
        URL site = null;
        try {
            site = new URL(Url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String inputLine;
        StringBuilder outputLine = new StringBuilder();
        try(BufferedReader in = new BufferedReader(new InputStreamReader(site.openStream()))) {
            while ((inputLine = in.readLine()) != null) {
                outputLine.append(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String page = outputLine.toString();
        System.out.println(page);
        HtmlCleaner cleaner = new HtmlCleaner();
        TagNode html = cleaner.clean(page);

        Object[] myNodes = new Object[0];
        try {
            myNodes = html.evaluateXPath(xpath);
        } catch (XPatherException e) {
            e.printStackTrace();
            System.out.println("Неверный expression");
        }

        for (Object myNode : myNodes) {
            TagNode tg = (TagNode) myNode;
            System.out.println(tg.getAttributeByName("title"));
        }
    }


    private static void getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите адрес сайта");
        path = scanner.next();
        System.out.println("Введите xPath выражение");
        reg = scanner.next();
        System.out.println(path + "\n" + reg);
    }

}

//package xPath;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.NodeList;
//import org.xml.sax.SAXException;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.parsers.ParserConfigurationException;
//import javax.xml.xpath.*;
//import java.io.IOException;
//
//public class App {
//
//    public static void main(String[] args) {
//
//        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
//        DocumentBuilder builder = null;
//        try {
//            builder = factory.newDocumentBuilder();
//            Document doc1 = builder.parse("D:\\Studing\\FourthSemestr\\src\\xPath\\books.xml");
//            XPathFactory xPathfactory = XPathFactory.newInstance();
//            XPath xpath = xPathfactory.newXPath();
//            XPathExpression allBooks = xpath.compile("//book/title");
//            XPathExpression allBooksWithPrice = xpath.compile("//book[price>30]/title");
//            XPathExpression allBooksWithLang = xpath.compile("//book/title[@lang=\"en\"]");
//
//            NodeList nodeList = (NodeList) allBooks.evaluate(doc1, XPathConstants.NODESET);
//            System.out.println("//book/title");
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                System.out.println(nodeList.item(i).getTextContent());
//            }
//
//            nodeList = (NodeList) allBooksWithPrice.evaluate(doc1, XPathConstants.NODESET);
//            System.out.println("//book[price>30]/title");
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                System.out.println(nodeList.item(i).getTextContent());
//            }
//
//            nodeList = (NodeList) allBooksWithLang.evaluate(doc1, XPathConstants.NODESET);
//            System.out.println("//book/title[@lang=\"en\"]");
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                System.out.println(nodeList.item(i).getTextContent());
//            }
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (XPathExpressionException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
////        System.out.println(allBooks);
//    }
//}
