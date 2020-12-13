package exceptionmulticatch.converter;

public class AnswerStat {

    private BinaryStringConverter binaryStringConverter;

    public AnswerStat(BinaryStringConverter binaryStringConverter) {
        this.binaryStringConverter = binaryStringConverter;
    }

    public boolean[] convert (String s){
        try {
           return binaryStringConverter.binaryStringToBooleanArray(s);
        } catch (NullPointerException | IllegalArgumentException e){
            throw new InvalidBinaryStringException("Not valid input", e);
        }
    }

    public int answerTruePercent(String answers){
        boolean[] booleans = binaryStringConverter.binaryStringToBooleanArray(answers);
        int values = 0;
        int trues = 0;
        for(boolean bol : booleans){
            if(bol){
                trues++;
            }
            values++;
        }
        return trues*100/values;
    }
}
