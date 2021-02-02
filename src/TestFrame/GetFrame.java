package TestFrame;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.io.File.separator;

/**
 * @author RoFire
 * @date 2021/1/30
 **/
public class GetFrame {
    public static String getframe(String Objectname, int index) {
        if (Objectname.equalsIgnoreCase("ACMS")) {
            List<String> testframes = new ArrayList<>();
            String Path = System.getProperty("user.dir") + separator + "src" + separator + "TestFrame" + separator + "ACMS";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(Path));
                String tempStr = "";
                while ((tempStr = bufferedReader.readLine()) != null) {
                    testframes.add(tempStr.split(";")[0]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return testframes.get(index);
        } else if (Objectname.equalsIgnoreCase("CUBS")) {
            List<String> testframes = new ArrayList<>();
            String Path = System.getProperty("user.dir") + separator + "src" + separator + "TestFrame" + separator + "CUBS";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(Path));
                String tempStr = "";
                while ((tempStr = bufferedReader.readLine()) != null) {
                    testframes.add(tempStr.split(";")[0]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return testframes.get(index);
        } else if (Objectname.equalsIgnoreCase("ERS")) {
            List<String> testframes = new ArrayList<>();
            String Path = System.getProperty("user.dir") + separator + "src" + separator + "TestFrame" + separator + "ERS";
            BufferedReader bufferedReader = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(Path));
                String tempStr = "";
                while ((tempStr = bufferedReader.readLine()) != null) {
                    testframes.add(tempStr.split(";")[0]);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return testframes.get(index);
        } else return "";
    }
}
