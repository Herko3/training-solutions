package week08.d01;

public class Sultan {

    private final int NUMBER_OF_DAYS;
    private final int NUMBER_OF_CELLS;
    private DoorStatus[] doorStatuses;

    public Sultan(int NUMBER_OF_DAYS, int NUMBER_OF_CELLS) {
        this.NUMBER_OF_DAYS = NUMBER_OF_DAYS;
        this.NUMBER_OF_CELLS = NUMBER_OF_CELLS;
        initDoorStatus();
    }

    public DoorStatus[] openDoors() {
        for (int i = 1; i <= NUMBER_OF_DAYS; i++) {
            for (int j = 1; j <= NUMBER_OF_CELLS; j++) {
                if (j % i == 0) {
                    doorStatuses[j - 1] = doorStatuses[j - 1].next();
                }
            }
        }

        return doorStatuses;
    }

    private void initDoorStatus() {
        doorStatuses = new DoorStatus[NUMBER_OF_CELLS];
        for (int i = 0; i < NUMBER_OF_CELLS; i++) {
            doorStatuses[i] = DoorStatus.CLOSED;
        }
    }

    public DoorStatus[] getDoorStatuses() {
        return doorStatuses;
    }

    public static void main(String[] args) {
        Sultan sultan = new Sultan(100, 100);
        sultan.openDoors();
        for (int i = 0; i < sultan.NUMBER_OF_CELLS; i++){
            System.out.println(sultan.getDoorStatuses()[i]);
        }
    }
}
