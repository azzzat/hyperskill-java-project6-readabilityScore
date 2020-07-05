class Problem {

    public static void main(String[] args) {
        String operat = args[0];

        int num1 = Integer.parseInt(args[1]);
        int num2 = Integer.parseInt(args[2]);

        switch (operat) {
            case "+":
                System.out.println(num1 + num2);
                break;
            case "-":
                System.out.println(num1 - num2);
                break;
            case "*":
                System.out.println(num1 * num2);
                break;
            default:
                System.out.println("Unknown operator");
        }
    }
}