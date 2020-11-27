package week05d05;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private List<Song> songs = new ArrayList<>();

    public Playlist(List<Song> songs) {
        this.songs = songs;
    }

    public List<Song> findByLengthGreaterThan(int minutes) {
        long seconds = minutes * 60;
        List<Song> greater = null;
        for (Song song : songs) {
            if (song.lengthInSeconds > seconds) {
                greater.add(song);
            }
        }
        return greater;
    }



}
