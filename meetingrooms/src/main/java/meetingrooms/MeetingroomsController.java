package meetingrooms;

import java.util.Scanner;

public class MeetingroomsController {

    private Scanner scanner = new Scanner(System.in);

//    private MeetingroomsServce meetingroomsServce = new MeetingroomsServce(new InMemoryMeetingroomsRepository());

//    private MeetingroomsServce meetingroomsServce = new MeetingroomsServce(new MariadbMeetingroomsRepository());

    public static void main(String[] args) {
        new MeetingroomsController().start();

    }

    public void start() {
        int menu = 0;
        System.out.println("Hello! itt lesz a menü!");
        while (menu != 9) {
            System.out.println("0. Tárgyaló rögzítése");
            System.out.println("1. Tárgyalók névsorrendben");
            System.out.println("2. Tárgyalók név alapján visszafele sorrendben");
            System.out.println("3. Minden második tárgyaló");
            System.out.println("4. Tárgyalók területei");
            System.out.println("5. Tárgyaló keresése pontos név alapján");
            System.out.println("6. Tárgyaló keresése névtöredék alapján");
            System.out.println("7. Tárgyaló keresése terület alapján");
            System.out.println("9. Kilépés");
            menu = Integer.parseInt(scanner.nextLine());
            executeMenuPoint(menu);
        }
    }

    public void executeMenuPoint(int numberOfMenu) {
        switch (numberOfMenu) {
            case 0:
                System.out.println("A tárgyalók rögzítése menüpontot választotta");
                break;
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            case 6:
                System.out.println("6");
                break;
            case 7:
                System.out.println("7");
                break;
            case 9:
                System.out.println("Kilépés!");
                break;
            default:
                System.out.println("Nincs ilyen menüpont!");
        }
    }
}
