package defaultconstructor;

public class SimpleDateFormatter {

    public String formatDateString(SimpleDate simpleDate) {
        String year = Integer.toString(simpleDate.getYear());
        String month = Integer.toString(simpleDate.getMonth());
        String day = Integer.toString(simpleDate.getDay());

        return year + "-" + month + "-" + day;
    }

    public String formatDateStringByCountryCode(CountryCode countryCode, SimpleDate simpleDate) {
        String[] date = {Integer.toString(simpleDate.getYear()),Integer.toString(simpleDate.getMonth()),Integer.toString(simpleDate.getDay())};
        if(countryCode == CountryCode.EN){
            return date[2] + "-" + date[1] + "-" + date[0];
        }
        if(countryCode == CountryCode.US){
            return date[1] + "-" + date[2] + "-" + date[0];
        }
        if(countryCode == CountryCode.HU){
            return formatDateString(simpleDate);
        }
        throw new IllegalArgumentException("CountryCode not found " + countryCode);
    }


}
