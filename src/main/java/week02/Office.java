package week02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Office {

    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    public void addMeetingRoom(List<MeetingRoom> meetingRoom) {
        for (MeetingRoom room : meetingRoom) {
            meetingRooms.add(room);
        }
    }

    public void printNames(){
        for (MeetingRoom room : meetingRooms){
            System.out.println(room.getName());
        }
    }

    public void printNamesReverse(){
        for (int i = meetingRooms.size()-1;i>=0;i--){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printEvenNames(){
        for (int i = 1;i< meetingRooms.size();i+=2){
            System.out.println(meetingRooms.get(i).getName());
        }
    }

    public void printAreas(){
        for (MeetingRoom room : meetingRooms){
            System.out.println(room);
        }
    }

    public void printMeetingRoomsWithName(String name){
        for (MeetingRoom room : meetingRooms){
            if(room.getName().equals(name)){
                System.out.println("A tárgyaló szélesség: " + room.getLength() + "m");
                System.out.println("A tárgyaló hosszúsága: " + room.getWidth() + "m");
                System.out.println("A tárgyaló területe: " + room.getArea() + "m^2");
            }
        }
    }
    public void printMeetingRoomsContains(String part){
        for (MeetingRoom room : meetingRooms){
            if(room.getName().toLowerCase().contains(part.toLowerCase())){
                System.out.println("A tárgyaló szélesség: " + room.getLength());
                System.out.println("A tárgyaló hosszúsága: " + room.getWidth());
                System.out.println("A tárgyaló területe: " + room.getArea());
            }
        }
    }
    public void printMeetingRoomsFirstContains(String part){
        List<MeetingRoom> match = new ArrayList<>();
        for (MeetingRoom room : meetingRooms){
            if(room.getName().toLowerCase().contains(part.toLowerCase())){
               match.add(room);
            }
        }
        System.out.println("A tárgyaló szélesség: " + match.get(0).getLength());
        System.out.println("A tárgyaló hosszúsága: " + match.get(0).getWidth());
        System.out.println("A tárgyaló területe: " + match.get(0).getArea());

    }

    public void printAreasLargerThan (int area){
        System.out.println("A következő tárgyalóknak nagyobb a területe:");
        for (MeetingRoom room : meetingRooms){
            if (room.getArea()>area){
                System.out.println(room);
            }
        }
    }

}

