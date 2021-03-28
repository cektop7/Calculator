import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Введите выражение арабскими или римскими цифрами.");
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();

        Pattern decPattern = Pattern.compile("(\\d+)\\s?([-+*/])\\s?(\\d+)");
        Pattern romPattern = Pattern.compile("([IVXLCDM]+)\\s?([-+*/])\\s?([IVXLCDM]+)");

        Matcher m = decPattern.matcher(expression);

        if (m.find()) {
            int result = 0;
            int a = Integer.parseInt(m.group(1));
            int b = Integer.parseInt(m.group(3));

            switch (m.group(2)) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                case "/":
                    result = a / b;
                    break;
            }
            System.out.println(result);

            return;
        } else {
            m = romPattern.matcher(expression);

            if (m.find()) {
                RomanNum a = new RomanNum(m.group(1));
                RomanNum b = new RomanNum(m.group(3));

                RomanNum result = null;

                switch (m.group(2)) {
                    case "+":
                        result = a.add(b);
                        break;
                    case "-":
                        result = a.sub(b);
                        break;
                    case "*":
                        result = a.mul(b);
                        break;
                    case "/":
                        result = a.div(b);
                        break;
                }
                System.out.println(result.getValue());

                return;
            }
        }
        
        throw new RuntimeException("Error. Invalid expression.");
    }
}
