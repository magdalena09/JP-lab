public class Main{
    public static void main(String[] args) {
       int max = 10, multi;
        for (int i = 1; i <= max; i++) {
            for (int j = 1; j <= max; j++) {
                multi = i * j;
                if (multi<10) {
                    System.out.print(multi + "   ");
                }else
                    System.out.print(multi + "  ");
            }
            System.out.println();
        }
    }
}
