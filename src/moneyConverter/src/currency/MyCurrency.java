package currency;

public class MyCurrency {

    private double courseRelativeToGold;
    private char currencySymbol;

    public MyCurrency(double courseRelativeToGold, char currencySymbol) {
        this.courseRelativeToGold = courseRelativeToGold;
        this.currencySymbol = currencySymbol;
    }

    public MyCurrency() {}

    public MyCurrency myCurrency() {
        return new MyCurrency();
    }

    public void setCourseRelativeToGold(double course) {
        courseRelativeToGold = course;
    }

    public double getCourseRelativeToGold() {
        return courseRelativeToGold;
    }

    public char getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(char symbol) {
        currencySymbol = symbol;
    }
}
