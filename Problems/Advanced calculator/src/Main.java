/* Please, do not rename it */
class Problem {

    public static void main(String[] args) {
        String operator = args[0];
        int num1 = Integer.parseInt(args[1]);
        if (operator.equals("MAX")) {
            for (int i = 1; i < args.length; i++) {
                int num2 = Integer.parseInt(args[i]);
                if(num1 < num2) {
                    num1 = num2;
                }
            }
        }
        if (operator.equals("MIN")) {
            for (int i = 1; i < args.length; i++) {
                int num2 = Integer.parseInt(args[i]);
                if(num1 > num2) {
                    num1 = num2;
                }
            }
        }
        if (operator.equals("SUM")) {
            for (int i = 2; i < args.length; i++) {
                int num2 = Integer.parseInt(args[i]);
                num1 += num2;
            }
        }
        System.out.print(num1);
    }
}