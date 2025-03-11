public class UlohaCyklus {
    public static void main(String[] args) {
        int cislo = 1;
        int stlpce = 5;
        int riadky = 5;

        System.out.println("+----+----+----+----+----+");

        for (int i = 0; i < riadky; i++) {
            for (int j = 0; j < stlpce; j++) {
                System.out.printf("| %2d ", cislo);
                cislo++;
            }
            System.out.println("|");

            System.out.println("+----+----+----+----+----+");
        }
    }
}
