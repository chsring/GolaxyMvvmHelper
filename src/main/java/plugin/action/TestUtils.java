package plugin.action;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestUtils {
    public static void main(String[] args) {
        System.out.println(new SimpleDateFormat("yy年MM月dd日").format(new Date()));
        System.out.println(new SimpleDateFormat("yyy-MM-dd").format(new Date()));
    }
}
