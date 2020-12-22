package week05.d05;

public class Song {

    String name;
    long lengthInSeconds;
    String artist;

    public Song(String name, long lengthInSeconds, String artist) {
        isEmpty(name);
        isEmpty(artist);
        if(lengthInSeconds<=0){
            throw new IllegalArgumentException("Length must be bigger than 0");
        }

        this.name = name;
        this.lengthInSeconds = lengthInSeconds;
        this.artist = artist;
    }

    private boolean isEmpty(String s){
        if(s == null || s.isBlank()){
            throw new IllegalArgumentException("Name and Artist must be something!");
        }
        return false;
    }

    @Override
    public String toString() {
        return artist + " - " + name + "(" + lengthInSeconds + " seconds)";
    }
}
