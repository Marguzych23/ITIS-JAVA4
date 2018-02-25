import config.Config;
import convert.CurrencyConverter;
import currency.MyCurrency;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConsoleApp {

    private static double count;
    private static MyCurrency myCurrency1;
    private static MyCurrency myCurrency2;
    private static ApplicationContext context;
    private static ApplicationContext javaContext;

    public static void main(String[] args) {
        context = new ClassPathXmlApplicationContext("spring-config.xml");
        javaContext = new AnnotationConfigApplicationContext(Config.class);
        console();
        convertAndPrintResult();
    }

    private static void convertAndPrintResult() {
        System.out.println(count + " " + myCurrency1.getCurrencySymbol() + " = " + CurrencyConverter.convert(count, myCurrency1, myCurrency2) + " " + myCurrency2.getCurrencySymbol());
    }

    private static void console() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select first currency:" + getCurrencyTypes());
        int currency = scanner.nextInt();
        switch (currency) {
            case 1: {
                myCurrency1 = (MyCurrency) context.getBean("rub");
                myCurrency1 = (MyCurrency) javaContext.getAutowireCapableBeanFactory().getBean("rub");
                break;
            }
            case 2: {
                myCurrency1 = (MyCurrency) context.getBean("usd");
                break;
            }
            case 3: {
                myCurrency1 = (MyCurrency) context.getBean("eur");
                break;
            }
            case 4: {
                myCurrency1 = (MyCurrency) context.getBean("gbp");
                break;
            }
            default: {
            }
        }
        System.out.println("Enter count of currency: ");
        count = scanner.nextDouble();
        System.out.println("Select second currency:" + getCurrencyTypes());
        currency = scanner.nextInt();
        switch (currency) {
            case 1:
                myCurrency2 = (MyCurrency) context.getBean("rub");
                break;
            case 2:
                myCurrency2 = (MyCurrency) context.getBean("usd");
                break;
            case 3:
                myCurrency2 = (MyCurrency) context.getBean("eur");
                break;

            case 4:
                myCurrency2 = (MyCurrency) context.getBean("gbp");
                break;
            default:
        }

    }

    private static String getCurrencyTypes() {
        return "\n1. RUB" +
                "\n2. USD" +
                "\n3. EUR" +
                "\n4. GBP";
    }
}
