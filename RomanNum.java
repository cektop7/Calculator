import java.util.*;

public class RomanNum {

    protected int value;

    protected Map<String, Integer> romanNumbers = getRomanMap();

    private static Map<String, Integer> getRomanMap() {
        Map<String, Integer> result = new HashMap<>();
        result.put("I", 1);
        result.put("V", 5);
        result.put("X", 10);
        result.put("L", 50);
        result.put("C", 100);
        result.put("D", 500);
        result.put("M", 1000);
        return result;
    }

    protected boolean isRoman(String romanNum) {
        romanNum = romanNum.toUpperCase();

        String alphabet = "^[IVXLCDM]+$";

        return romanNum.matches(alphabet);
    }

    protected int romanToInt(String romanNum) {
        romanNum = romanNum.toUpperCase();
        int value = 0;
        int prev = 0, curr = 0;
        for (int pos = 1; pos < romanNum.length(); pos++) {
            prev = romanNumbers.get(Character.toString(romanNum.charAt(pos - 1)));
            curr = romanNumbers.get(Character.toString(romanNum.charAt(pos)));
            if (prev >= curr) value += prev; else value -= prev;
        }

        return value + curr;
    }

    protected String intToRoman(int num) {
        if (num > 3999) return "";

        String roman = "";
        while (num > 0) {
            int dig = Character.getNumericValue(Integer.toString(num).charAt(0));
            int pow = Integer.toString(num).length() - 1;
            char[] letters = {'M'};

            switch (pow) {
                case 2:
                    letters = new char[] {'C', 'D', 'M'};
                    break;
                case 1:
                    letters = new char[] {'X', 'L', 'C'};
                    break;
                case 0:
                    letters = new char[] {'I', 'V', 'X'};
                    break;
            }

            switch (dig) {
                case 1, 2, 3:
                    for (int i = 0; i < dig; i++) roman += letters[0];
                    break;
                case 4:
                    roman += letters[0] + letters[1];
                    break;
                case 5:
                    roman += letters[1];
                    break;
                case 6, 7, 8:
                    roman += letters[1];
                    for (int i = 0; i < dig - 5; i++) roman += letters[0];
                    break;
                case 9:
                    roman += letters[0] + letters[2];
            }

            num -= Math.pow(10, pow) * Character.getNumericValue(dig);
        }
        return roman;
    }

    public RomanNum(int initValue) {
        this.value = initValue;
    }

    public RomanNum(String initValue) {
        this.value = this.romanToInt(initValue);
    }

    public int toInt() {
        return this.value;
    }

    public String value() {
        return intToRoman(this.value);
    }
}