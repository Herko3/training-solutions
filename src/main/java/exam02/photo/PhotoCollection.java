package exam02.photo;

import java.util.ArrayList;
import java.util.List;

public class PhotoCollection {

    private List<Photo> photos = new ArrayList<>();

    public void addPhoto(String... photoName) {
        for (String str : photoName) {
            photos.add(new Photo(str));
        }
    }

    public void starPhoto(String name, Quality quality) {
        for (Photo photo : photos) {
            if (photo.getName().equalsIgnoreCase(name)) {
                photo.setQuality(quality);
                return;
            }
        }
        throw new PhotoNotFoundException("No Photo with such name: " + name);
    }

    public int numberOfStars() {
        int sum = 0;
        for (Photo photo : photos) {
            sum += photo.getQuality().getValue();
        }
        return sum;
    }


    public List<Photo> getPhotos() {
        return new ArrayList<>(photos);
    }
}
