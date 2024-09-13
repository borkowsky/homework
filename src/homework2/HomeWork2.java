package homework2;

public class HomeWork2 {
    public static void main(String[] args) {
        // Произведение чисел
        int a1 = 2;
        int b1 = 3;
        System.out.println("Произведение чисел: " + (a1 * b1));

        // Вычисление примера
        int a2 = 20;
        int b2 = -3;
        int c2 = 5;
        int d2 = 8;
        System.out.println("Вычисление примера: " + (a2 + b2 * c2 / d2));

        // Последняя цифра числа
        int a3 = 5849;
        String b3 = String.valueOf(a3);
        char c3 = b3.charAt(3);
        System.out.println("Последняя цифра числа: " + c3);

        // Третья цифра пятизначного числа
        int a4 = 47654;
        String b4 = String.valueOf(a4);
        char c4 = b4.charAt(2);
        System.out.println("Третья цифра числа 47654: " + c4);

        // Сумма цифр ab cd числа abcd
        int abcd = 6438;
        String stringValue = String.valueOf(abcd);
        String abString = stringValue.substring(0, 2);
        String cdString = stringValue.substring(2);
        int abStr = Integer.parseInt(abString);
        int cdStr = Integer.parseInt(cdString);
        System.out.println("Сумма цифр ab cd числа abcd (через деление строки): " + (abStr + cdStr)); // 64 + 38 = 102
        int abInt = abcd / 100;
        int cdInt = abcd % 100;
        System.out.println("Сумма цифр ab cd числа abcd (через деление числа): " + (abInt + cdInt)); // 64 + 38 = 102

        // Площадь и периметр круга, R = 7.5, формула площади - pi * (r * r), периметра - 2 * pi * r
        float radius = 7.5F;
        double roundArea = Math.PI * (radius * radius);
        double roundPerimeter = 2 * Math.PI * radius;
        System.out.println("Площадь круга: " + roundArea + ", периметр: " + roundPerimeter);

        // Среднее арифметическое пяти чисел
        float i1 = 46.0F, i2 = 4987.0F, i3 = 64.0F, i4 = 3765.0F, i5 = 26254.0F;
        float sum = i1 + i2 + i3 + i4 + i5;
        float mean = sum / 5;
        System.out.println("Среднее арифметическое пяти чисел: " + mean);
    }
}
