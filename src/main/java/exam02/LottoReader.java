package exam02;

import java.io.InputStream;

public class LottoReader {

    private int[] numbers = new int[90];

    public LottoReader(InputStream is) {
    }

    public int getNumber(int number) {
        return numbers[number - 1];
    }
}
