package by.it_academy.homework.practice9;

public enum Colors {
    YELLOW("Желтый"),
    RED("Красный"),
    BLUE("Синий"),
    PINK("Розовый"),
    WHITE("Белый"),
    BLACK("Черный");

    private final String localizedName;

    Colors(String localizedName) {
        this.localizedName = localizedName;
    }
}
