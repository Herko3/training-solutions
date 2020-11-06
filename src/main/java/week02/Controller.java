package week02;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Office office = new Office();

    public void readOffice(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mennyi tárgyalót akar felvenni?");
        int numberOfMeetingRooms= scanner.nextInt();
        scanner.nextLine();
        String name;
        int length;
        int width;
        List<MeetingRoom> meetingRooms = new ArrayList<>();
        for (int i = 0; i<numberOfMeetingRooms;i++){
            System.out.println("Adja meg a(z) " + (i+1) + ". tárgyaló nevét" );
            name = scanner.nextLine();
            System.out.println("Adja meg a(z) " + (i+1) + ". tárgyaló hosszúságát méterben" );
            length = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Adja meg a(z) " + (i+1) + ". tárgyaló szélességét méterben" );
            width = scanner.nextInt();
            scanner.nextLine();
            meetingRooms.add(new MeetingRoom(name,length,width));
        }
        office.addMeetingRoom(meetingRooms);
    }

    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.readOffice();

    }


}
