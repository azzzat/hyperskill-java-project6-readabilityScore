class Problem {
    public static void main(String[] args) {
        boolean found = false;
        for (int i = 0; i < args.length; i++) {

            if (args[i].equals("test")) {
                System.out.println(i);
                found = true;
            }

        }

        if (!found) {
            System.out.print("-1");
        }
    }
}