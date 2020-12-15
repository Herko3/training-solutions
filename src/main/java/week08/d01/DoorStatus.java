package week08.d01;

public enum DoorStatus {

    OPEN{
        @Override
        DoorStatus next() {
            return DoorStatus.CLOSED;
        }
    },CLOSED{
        @Override
        DoorStatus next() {
            return DoorStatus.OPEN;
        }
    };

    abstract DoorStatus next();
}
