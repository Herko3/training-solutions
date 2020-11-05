package intromethods;

public class Todo {
    private String caption;
    private boolean finished;

    public Todo(String caption) {
        this.caption = caption;
    }

    public String getCaption() {
        return caption;
    }

    public boolean isFinished() {
        return finished;
    }

    public void finish(){
        finished = true;
    }

    @Override
    public String toString() {
        String befejezve;
        if (finished){
            befejezve = "Befejezve";
        } else {
            befejezve = "Folyamatban";
        }

        return caption + " (" + befejezve +")";
    }

//    public static void main(String[] args) {
//        Todo test = new Todo("Takarítás");
//
//        System.out.println(test.isFinished());
//        System.out.println(test.toString());
//        test.finish();
//        System.out.println(test.toString());
//    }
}
