public class Calculator {
    public static void main(String[] args) {
        RomanNum rn = new RomanNum("MMMM");
        System.out.println(rn.getValue() + " = " + rn.getIntValue());
    }
}
