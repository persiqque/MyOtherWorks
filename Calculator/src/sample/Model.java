package sample;

public class Model {

    public int calculation(int a, int b, String operation) {
        switch (operation) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    return 0;
                }
                return a / b;
            default:
                System.out.println("Неизвестный оператор " + operation);

        }
        return 0;
    }
}
