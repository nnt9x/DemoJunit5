package hinhhoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class HinhVuongTest {

    @DisplayName("Test chu vi hình vuông")
    @ParameterizedTest(name = "{index} => Hình vuông có canh la {0} có chu vi {1} ")

    @CsvSource({"1,4","2,8","1.234,4.94","2.345,9.38","23.432123,93.73","4.2,16.8","12.33,49.32","23,92"})
    void testChuVi(String input, String expected){
        double mInput = Double.parseDouble(input);
        double mExpected = Double.parseDouble(expected);

        HinhVuong hinhVuong = new HinhVuong();
        hinhVuong.setCanh(mInput);

        double actual = hinhVuong.chuVi();

        Assertions.assertEquals(mExpected, actual);
    }


    @DisplayName("Nem ra Exception khi canh khong hop le")
    @ParameterizedTest(name = "{index} => Hình vuông có cạnh {0} là không hợp lệ")
    @CsvSource({"0","-3.2848"})
    void nemRaException(String input){
        double canh = Double.parseDouble(input);
        Exception e = Assertions.assertThrows(RuntimeException.class,
                new Executable() {
                    @Override
                    public void execute() throws Throwable {
                        HinhVuong hv = new HinhVuong(canh);
                    }
                });
        String expected = "Cạnh phải là số dương";
        Assertions.assertEquals(expected, e.getMessage());
    }

}