package by.it_academy.homework.task8.money;

import by.it_academy.homework.utils.Utils;

public class Money {
    private int dollars;
    private int cents;

    public Money(int dollars, int cents) {
        this.dollars = dollars;
        this.cents = cents;
    }

    public Money(int cents) {
        injectCents(cents);
    }

    public String toString() {
        return dollars + "," + cents;
    }

    public String toStringPretty(String locale) {
        String[] dollarLabels = locale.equals("ru") ?
                new String[]{"доллар", "доллара", "долларов"} :
                new String[]{"dollar", "dollars", "dollars"};
        String[] centsLabels = locale.equals("ru") ?
                new String[]{"цент", "цента", "центов"} :
                new String[]{"cent", "cents", "cents"};
        return dollars + " " + Utils.declOfNum(dollars, dollarLabels)
                + ", " + ((cents < 10) ? "0" + cents : cents) + " "
                + Utils.declOfNum(cents, centsLabels);
    }

    public void add(int dollars, int cents) {
        injectCents(convertToCents() + convertToCents(dollars, cents));
    }

    public void add(int cents) {
        injectCents(convertToCents() + cents);
    }

    public void subtract(int dollars, int cents) {
        injectCents(convertToCents() - convertToCents(dollars, cents));
    }

    public void subtract(int cents) {
        injectCents(convertToCents() - cents);
    }

    public int getDollars() {
        return dollars;
    }

    public int getCents() {
        return cents;
    }

    private int convertToCents() {
        return (dollars * 100) + cents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money money = (Money) o;
        return dollars == money.dollars && cents == money.cents;
    }

    private int convertToCents(int dollars, int cents) {
        return (dollars * 100) + cents;
    }

    private void injectCents(int cents) {
        this.dollars = cents / 100;
        this.cents = cents % 100;
    }
}
