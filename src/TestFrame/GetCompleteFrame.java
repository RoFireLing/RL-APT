package TestFrame;

import _Constant.Constant;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author RoFire
 * @date 2021/1/30
 **/
public class GetCompleteFrame {
    public static List<_CompleteTestFrame> getcompleteframe(String Objectname, int num) {
        String path = Constant.getTcpath();
        if (num == 500) {
            path += Objectname + "#500";
        } else if (num == 1000) {
            path += Objectname + "#1000";
        } else if (num == 1500) {
            path += Objectname + "#1500";
        } else if (num == 2000) {
            path += Objectname + "#2000";
        } else path = "";

        File file = new File(path);

        List<_CompleteTestFrame> finalframes = new ArrayList<>();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            String tempStr = "";
            int index = 0;
            while ((tempStr = bufferedReader.readLine()) != null) {
                int no = Integer.parseInt(tempStr.split(";")[0]);
                int partition = Integer.parseInt(tempStr.split(";")[1]);
                int frameindex = -1;
                String frame = "";
                switch (Objectname) {
                    case "ACMS":
                        frameindex = Integer.parseInt(tempStr.split(";")[7]);
                        frame = new GetFrame().getframe("ACMS", frameindex);
                        break;
                    case "CUBS":
                        frameindex = Integer.parseInt(tempStr.split(";")[6]);
                        frame = new GetFrame().getframe("CUBS", frameindex);
                        break;
                    case "ERS":
                        frameindex = Integer.parseInt(tempStr.split(";")[7]);
                        frame = new GetFrame().getframe("ERS", frameindex);
                        break;
                }
                _CompleteTestFrame f = new _CompleteTestFrame(no, partition, frameindex, frame);
                finalframes.add(f);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return finalframes;
    }
}
