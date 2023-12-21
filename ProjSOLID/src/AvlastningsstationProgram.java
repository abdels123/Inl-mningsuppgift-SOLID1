import java.util.Scanner;

public class AvlastningsstationProgram {
    public static void main(String[] args) {
        Avlastningsstation avlastningsstation = new Avlastningsstation();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nVälj en tjänst:");
            System.out.println("1. Visa dockade lastbilar");
            System.out.println("2. Registrera en ny lastbil");
            System.out.println("3. Avsluta programmet");

            int val = scanner.nextInt();

            switch (val) {
                case 1:
                    avlastningsstation.visaDockadeLastbilar();
                    break;
                case 2:
                    System.out.print("Ange lastbilens typ (Skåpbil, Lätt lastbil, Tung lastbil): ");
                    String typ = scanner.next();
                    System.out.print("Ange lastbilens vikt i ton: ");
                    double vikt = scanner.nextDouble();
                    avlastningsstation.registreraLastbil(typ, vikt);
                    break;
                case 3:
                    System.out.println("Programmet avslutas.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Ogiltigt val. Försök igen.");
            }
        }
    }
}


