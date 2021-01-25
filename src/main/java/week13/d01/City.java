package week13.d01;

public class City implements Comparable<City> {

    private int zipCode;
    private String city;
    private String cityPart;

    public City(int zipCode, String city, String cityPart) {
        this.zipCode = zipCode;
        this.city = city;
        this.cityPart = cityPart;
    }

    public City(int zipCode, String city) {
        this.zipCode = zipCode;
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCityPart() {
        return cityPart;
    }

    @Override
    public int compareTo(City o) {
        if (city.compareTo(o.city) == 0) {
            return zipCode-o.zipCode;
        }
        return city.compareTo(o.city);
    }
}
