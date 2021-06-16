package meetingrooms;

import java.util.Scanner;

public class MeetingRoomsController {

    private Scanner scanner = new Scanner(System.in);

    private MeetingRoomsService meetingRoomsService =
            new MeetingRoomsService(new InMemoryMeetingRoomsRepository());

//    private MeetingRoomsService meetingRoomsService =
//    new MeetingRoomsService(new MariadbMeetingRoomsRepository());

    public static void main(String[] args) {
        new MeetingRoomsController().start();

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
                meetingRoomsService.save(savingMeetingRoom());
                break;
            case 1:
                System.out.println("1. Tárgyalók névsorrendben:");
                System.out.println(meetingRoomsService.findAll());
                break;
            case 2:
                System.out.println("2. Tárgyalók név alapján visszafele sorrendben:");
                System.out.println(meetingRoomsService.findAllReverseOrder());
                break;
            case 3:
                System.out.println("3. Minden második tárgyaló:");
                System.out.println(meetingRoomsService.everySecondRoom());
                break;
            case 4:
                System.out.println("4. Területek:");
                System.out.println(meetingRoomsService.findAllWithAreaReverseOrderByArea());
                break;
            case 5:
                System.out.println("5. Keresés pontos név alapján:");
                System.out.println(findByName());
                break;
            case 6:
                System.out.println("6. Keresés névtöredék alapján:");
                System.out.println(findByPartitionalName());
                break;
            case 7:
                System.out.println("7. Keresés terület alapján:");
                System.out.println(findByArea());
                break;
            case 9:
                System.out.println("Kilépés!");
                break;
            default:
                System.out.println("Nincs ilyen menüpont!");
        }
    }

    private MeetingRoom savingMeetingRoom() {
        System.out.println("Kérem, adja meg a tárgyaló:");
        System.out.println("nevét: ");
        String name = scanner.nextLine();
        System.out.println("szélességét (méterben):");
        int width = Integer.parseInt(scanner.nextLine());
        System.out.println("hosszát (méterben):");
        int length = Integer.parseInt(scanner.nextLine());
        return new MeetingRoom(name, width, length);
    }

    private MeetingRoom findByName() {
        System.out.println("Kérem, adja meg a tárgyaló nevét!");
        String name = scanner.nextLine();
        return meetingRoomsService.findMeetingRoomByName(name);
    }

    private MeetingRoom findByPartitionalName() {
        System.out.println("Kérem, adja meg a tárgyaló nevének ismert töredékét!");
        String name = scanner.nextLine();
        return meetingRoomsService.findMeetingRoomByAPieceOfTheName(name);
    }

    private MeetingRoom findByArea() {
        System.out.println("Kérem, adja meg annak a területnek a méretét, melynél nagyobb tárgyalókat keres!");
        int area = Integer.parseInt(scanner.nextLine());
        return meetingRoomsService.findMeetingRoomByArea(area);
    }
}
