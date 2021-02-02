package GenerateTestcases;

import TestCase.*;
import TestFrame.GetFrame;
import _Constant.Constant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

import static java.io.File.separator;

/**
 * @author RoFire
 * @date 2021/1/25
 **/
public class GenerateTestcases {
    public static CompleteTC4ACMS[] generate4ACMS(int tcnum) {
        Random random = new Random(0);
        int[] frameset = new int[tcnum];
        for (int i = 0; i < frameset.length; i++) {
            frameset[i] = random.nextInt(Constant.numberofacmsframes);
        }
        TestCase4ACMS[] tc = createTestSuite4ACMS(tcnum, frameset);
        CompleteTC4ACMS[] finaltc = new CompleteTC4ACMS[tcnum];
        int partitionindex = -1;
        int partition[] = new int[Constant.getPartitionNumber("ACMS")];
        for (int i = 0; i < finaltc.length; i++) {
            partitionindex = new Partition().partition4ACMS(tc[i]);
            partition[partitionindex]++;
            finaltc[i] = new CompleteTC4ACMS(i, partitionindex, tc[i], frameset[i]);
        }
        writePartitionStat("ACMS", tcnum, Arrays.toString(partition));
        return finaltc;
    }

    public static CompleteTC4CUBS[] generate4CUBS(int tcnum) {
        Random random = new Random(0);
        int[] frameset = new int[tcnum];
        for (int i = 0; i < frameset.length; i++) {
            frameset[i] = random.nextInt(Constant.numberofcubsframes);
        }
        TestCase4CUBS[] tc = createTestSuite4CUBS(tcnum, frameset);
        CompleteTC4CUBS[] finaltc = new CompleteTC4CUBS[tcnum];
        int partitionindex = -1;
        int partition[] = new int[Constant.getPartitionNumber("CUBS")];
        for (int i = 0; i < finaltc.length; i++) {
            partitionindex = new Partition().partition4CUBS(tc[i]);
            partition[partitionindex]++;
            finaltc[i] = new CompleteTC4CUBS(i, partitionindex, tc[i], frameset[i]);
        }
        writePartitionStat("CUBS", tcnum, Arrays.toString(partition));
        return finaltc;
    }

    public static CompleteTC4ERS[] generate4ERS(int tcnum) {
        Random random = new Random(0);
        int[] frameset = new int[tcnum];
        for (int i = 0; i < frameset.length; i++) {
            frameset[i] = random.nextInt(Constant.numberofersframes);
        }
        TestCase4ERS[] tc = createTestSuite4ERS(tcnum, frameset);
        CompleteTC4ERS[] finaltc = new CompleteTC4ERS[tcnum];
        int partitionindex = -1;
        int partition[] = new int[Constant.getPartitionNumber("ERS")];
        for (int i = 0; i < finaltc.length; i++) {
            partitionindex = new Partition().partition4ERS(tc[i]);
            partition[partitionindex]++;
            finaltc[i] = new CompleteTC4ERS(i, partitionindex, tc[i], frameset[i]);
        }
        writePartitionStat("ERS", tcnum, Arrays.toString(partition));
        return finaltc;
    }

    public static TestCase4ACMS[] createTestSuite4ACMS(int tcnum, int[] frameset) {
        TestCase4ACMS[] testcases = new TestCase4ACMS[tcnum];
        Random random = new Random(0);
//        Boolean[] ISSTUDENT = {true, false};
//        for (int i = 0; i < tcnum; i++) {
//            boolean isStudent = ISSTUDENT[random.nextInt(2)];
//            int airClass = 0;
//            if (isStudent) {
//                airClass = 2;
//            } else {
//                airClass = random.nextInt(4);
//            }
//            int area = random.nextInt(2);
//
//            double luggage = random.nextDouble() * 80;
//            double economicfee = random.nextDouble() * 5000 + 500;
//            TestCase4ACMS tc = new TestCase4ACMS(airClass, area, isStudent, luggage, economicfee);
//            testcases[i] = tc;
//        }
        GetFrame frame = new GetFrame();
        for (int i = 0; i < testcases.length; i++) {
            testcases[i] = new GenerateTestcases().acmsgenerateTestCase(frame.getframe("ACMS", frameset[i]));
        }
        return testcases;
    }

    public static TestCase4CUBS[] createTestSuite4CUBS(int tcnum, int[] frameset) {
        TestCase4CUBS[] testcases = new TestCase4CUBS[tcnum];
//        Random random = new Random(0);
//        String[] types = {"A", "B", "a", "b"};
//        int[] Achoices = {46, 96, 286, 886};
//        int[] Bchoices = {46, 96, 126, 186};
//        for (int i = 0; i < tcnum; i++) {
//            String planType = types[random.nextInt(4)];
//            int planFee = 0;
//            if (planType == "A" || planType == "a") {
//                planFee = Achoices[random.nextInt(4)];
//            } else {
//                planFee = Bchoices[random.nextInt(4)];
//            }
//            int talkTime = random.nextInt(4000);
//            int flow = random.nextInt(4000);
//
//            TestCase4CUBS tc = new TestCase4CUBS(planType, planFee, talkTime, flow);
//            testcases[i] = tc;
//        }
        GetFrame frame = new GetFrame();
        for (int i = 0; i < testcases.length; i++) {
            testcases[i] = new GenerateTestcases().cubsgenerateTestCase(frame.getframe("CUBS", frameset[i]));
        }
        return testcases;
    }

    public static TestCase4ERS[] createTestSuite4ERS(int tcnum, int[] frameset) {
        TestCase4ERS[] testcases = new TestCase4ERS[tcnum];
        Random random = new Random(0);
//        String[] levels = {"seniormanager", "manager", "supervisor"};
//        for (int i = 0; i < tcnum; i++) {
//            String stafflevel = levels[random.nextInt(3)];
//            double actualmonthlymileage = random.nextDouble() * 8000;
//            double monthlysalesamount = random.nextDouble() * 150000;
//            double airfareamount = random.nextDouble() * 10000;
//            double otherexpensesamount = random.nextDouble() * 10000;
//            TestCase4ERS tc = new TestCase4ERS(stafflevel, actualmonthlymileage,
//                    monthlysalesamount, airfareamount, otherexpensesamount);
//            testcases[i] = tc;
//        }
        GetFrame frame = new GetFrame();
        for (int i = 0; i < testcases.length; i++) {
            testcases[i] = new GenerateTestcases().ersgenerateTestCase(frame.getframe("ERS", frameset[i]));
        }
        return testcases;
    }

    /**
     * generate concrete test cases based on the test frame
     *
     * @param testFrame that is used to generate test cases
     * @return a test case
     */
    public static TestCase4ACMS acmsgenerateTestCase(String testFrame) {
        int airClass = 0;
        int area = 0;
        boolean isStudent = true;
        double luggage = 0;
        double economicfee = 0;
        //delate the braces
        testFrame = testFrame.replace("{", "").replace("}", "");
        String[] choices = testFrame.split(",");
        // instantiate the choices
        switch (choices[0]) {
            case "I-1a":
                airClass = 0;
                break;
            case "I-1b":
                airClass = 1;
                break;
            case "I-1c":
                airClass = 2;
                break;
            case "I-1d":
                airClass = 3;
                break;
        }

        switch (choices[1]) {
            case "I-2a":
                area = 0;
                break;
            case "I-2b":
                area = 1;
                break;
        }

        switch (choices[2]) {
            case "I-3a":
                isStudent = false;
                break;
            case "I-3b":
                isStudent = true;
                airClass = 2;
                break;
        }
        int benchmark = 0;
        if (airClass == 0)
            benchmark = 40;
        else if (airClass == 1)
            benchmark = 30;
        else if (airClass == 2 && isStudent == true)
            benchmark = 30;
        else if (airClass == 2 && isStudent == false)
            benchmark = 20;
        else
            benchmark = 0;

        switch (choices[3]) {
            case "I-4a":
                int temp = new Random().nextInt(80);
                while (temp > benchmark) {
                    temp = new Random().nextInt(80);
                }
                luggage = temp;
                break;
            case "I-4b":
                int tempb = new Random().nextInt(80);
                while (tempb <= benchmark) {
                    tempb = new Random().nextInt(80);
                }
                luggage = tempb;
                break;
        }

        switch (choices[4]) {
            case "I-5a":
                economicfee = 0;
                break;
            case "I-5b":
                economicfee = new Random().nextDouble() * 3000;
                break;
        }
        TestCase4ACMS tc = new TestCase4ACMS(airClass, area, isStudent, luggage, economicfee);
        return tc;
    }

    public static TestCase4CUBS cubsgenerateTestCase(String testFrame) {
        String planType = null;
        int planFee = 0;
        int talkTime = 0;
        int flow = 0;

        //delate the braces
        testFrame = testFrame.replace("{", "").replace("}", "");
        String[] choices = testFrame.split(",");

        if (choices[0].equals("I-1a")) {
            planType = "A";
            switch (choices[1]) {
                case "I-2a":
                    planFee = 46;
                    break;
                case "I-2b":
                    planFee = 96;
                    break;
                case "I-2e":
                    planFee = 286;
                    break;
                case "I-2f":
                    planFee = 886;
                    break;
            }
        }

        if (choices[0].equals("I-1b")) {
            planType = "B";
            switch (choices[1]) {
                case "I-2a":
                    planFee = 46;
                    break;
                case "I-2b":
                    planFee = 96;
                    break;
                case "I-2c":
                    planFee = 126;
                    break;
                case "I-2d":
                    planFee = 186;
                    break;
            }
        }
        int talkTimeBench = 0;
        int flowBench = 0;
        if (planType.equals("A") && planFee == 46) {
            talkTimeBench = 50;
            flowBench = 150;
        } else if (planType.equals("A") && planFee == 96) {
            talkTimeBench = 96;
            flowBench = 240;
        } else if (planType.equals("A") && planFee == 286) {
            talkTimeBench = 286;
            flowBench = 900;
        } else if (planType.equals("A") && planFee == 886) {
            talkTimeBench = 3000;
            flowBench = 3000;
        } else if (planType.equals("B") && planFee == 46) {
            talkTimeBench = 120;
            flowBench = 40;
        } else if (planType.equals("B") && planFee == 96) {
            talkTimeBench = 450;
            flowBench = 80;
        } else if (planType.equals("B") && planFee == 126) {
            talkTimeBench = 680;
            flowBench = 100;
        } else if (planType.equals("B") && planFee == 186) {
            talkTimeBench = 1180;
            flowBench = 150;
        }

        switch (choices[2]) {
            case "I-3a":
                talkTime = talkTimeBench - new Random().nextInt(20);
                break;
            case "I-3b":
                talkTime = talkTimeBench + new Random().nextInt(20);
                break;
        }

        switch (choices[3]) {
            case "I-4a":
                flow = flowBench - new Random().nextInt(20);
                break;
            case "I-4b":
                flow = flowBench + new Random().nextInt(20);
                break;
        }
        TestCase4CUBS tc = new TestCase4CUBS(planType, planFee, talkTime, flow);
        return tc;
    }

    public static TestCase4ERS ersgenerateTestCase(String testFrame) {
        String stafflevel = "";
        double actualmonthlymileage = 0;
        double monthlysalesamount = 0;
        double airfareamount = 0;
        double otherexpensesamount = 0;

        //delate the braces
        testFrame = testFrame.replace("{", "").replace("}", "");
        String[] choices = testFrame.split(",");

        switch (choices[0]) {
            case "I-1a":
                stafflevel = "seniormanager";
                break;
            case "I-1b":
                stafflevel = "manager";
                break;
            case "I-1c":
                stafflevel = "supervisor";
                break;
            case "*":
                stafflevel = new String[]{"seniormanager", "manager", "supervisor"}[new Random().nextInt(3)];
                break;
        }

        switch (choices[1]) {
            case "I-2a":
                actualmonthlymileage = new Random().nextDouble() * 3000;
                break;
            case "I-2b":
                actualmonthlymileage = new Random().nextDouble() * 1000 + 3000;
                break;
            case "I-2c":
                actualmonthlymileage = new Random().nextDouble() * 1000 + 4000;
                break;
            case "*":
                actualmonthlymileage = new Random().nextDouble() * 6000;
                break;
        }


        switch (choices[2]) {
            case "I-3a":
                monthlysalesamount = new Random().nextDouble() * 50000;
                break;
            case "I-3b":
                monthlysalesamount = new Random().nextDouble() * 30000 + 50000;
                break;
            case "I-3c":
                monthlysalesamount = new Random().nextDouble() * 20000 + 80000;
                break;
            case "I-3d":
                monthlysalesamount = new Random().nextDouble() * 10000 + 100000;
                break;
            case "*":
                monthlysalesamount = new Random().nextDouble() * 130000;
                break;
        }

        switch (choices[3]) {
            case "I-4a":
                airfareamount = 0;
                break;
            case "I-4b":
                airfareamount = new Random().nextDouble() * 10000;
                break;
            case "*":
                airfareamount = new Random().nextDouble() * 10000;
                break;
        }

        switch (choices[4]) {
            case "I-5a":
                otherexpensesamount = 0;
                break;
            case "I-5b":
                otherexpensesamount = new Random().nextDouble() * 10000;
                break;
            case "*":
                otherexpensesamount = new Random().nextDouble() * 10000;
                break;
        }
        TestCase4ERS tc = new TestCase4ERS(stafflevel, actualmonthlymileage, monthlysalesamount,
                airfareamount, otherexpensesamount);
        return tc;
    }

    public static void writeInfo(String Objectname, int num, String content) {
        String content_path = Constant.testcaseinfo + separator + Objectname + "#" + String.valueOf(num);

        File file = new File(content_path);

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.write(content + "\n");
        printWriter.close();
    }

    public static void writePartitionStat(String Objectname, int num, String stat) {
        String partition_path = Constant.testcaseinfo + separator + "_PartitionInfo";

        File file = new File(partition_path);

        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.write(Objectname + "#" + String.valueOf(num) + "\t\t");
        printWriter.write(stat + "\n");
        printWriter.close();
    }

    public static void main(String[] args) {
        int tcnum = 500;

        CompleteTC4ACMS[] tc = generate4ACMS(tcnum);
        for (CompleteTC4ACMS t : tc) {
            writeInfo("ACMS", tcnum, t.toString());
        }
        CompleteTC4CUBS[] tc2 = generate4CUBS(tcnum);
        for (CompleteTC4CUBS t : tc2) {
            writeInfo("CUBS", tcnum, t.toString());
        }
        CompleteTC4ERS[] tc3 = generate4ERS(tcnum);
        for (CompleteTC4ERS t : tc3) {
            writeInfo("ERS", tcnum, t.toString());
        }
    }
}
