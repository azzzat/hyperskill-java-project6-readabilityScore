//import java.io.File;

class Siblings {

    public static boolean areSiblings(File f1, File f2) {

        boolean same = false;


            String str1 = new String(f1.getParent());
            String str2 = new String(f2.getParent());

            if(str1.equals(str2)) {
                same = true;
            }


        return same;
    }
}