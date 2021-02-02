package _Constant;

import static java.io.File.separator;

/**
 * describe:
 *
 * @author phantom
 * @date 2019/04/19
 */
public class Constant {

    /**
     * this is the number of generating test cases
     */
    public static final int number = 10000;

    /**
     * source dir
     */
    public static final String acmssource = "ACMS.sourceCode.AirlinesBaggageBillingService";

    public static final String cubssource = "CUBS.sourceCode.BillCalculation";

    public static final String erssource = "ERS.sourceCode.ExpenseReimbursementSystem";

    /**
     * this is the number of testframes
     */
    public static final int numberofacmsframes = 40;
    public static final int numberofcubsframes = 32;
    public static final int numberofersframes = 54;
    /**
     * TCnum for each partition [used for RAPT]
     */
    public static final int[] acms500 = {50, 48, 41, 50, 93, 108, 54, 56};
    public static final int[] cubs500 = {118, 151, 105, 126};
    public static final int[] ers500 = {54, 44, 49, 87, 50, 37, 44, 50, 14, 18, 20, 33};
    public static final int[] acms1000 = {};
    public static final int[] cubs1000 = {};
    public static final int[] ers1000 = {};
    public static final int[] acms1500 = {};
    public static final int[] cubs1500 = {};
    public static final int[] ers1500 = {};
    public static final int[] acms2000 = {};
    public static final int[] cubs2000 = {};
    public static final int[] ers2000 = {};
    /**
     * the number of repeating times for testing
     */
    public static final int repeatNumber = 30;
    /**
     * dir
     */
    public static final String resultPath = System.getProperty("user.dir") + separator + "src" + separator + "Result";
    public static final String killedmutantinfo = System.getProperty("user.dir") + separator + "src" + separator + "GetMutants";
    public static final String testcaseinfo = System.getProperty("user.dir") + separator + "src" + separator + "GenerateTestcases";
    /**
     * the path of the dir that includes testcases of each object
     */
    public static final String tcpath = System.getProperty("user.dir") + separator + "src" + separator + "GenerateTestcases" + separator;

    public static int[] getAcms500() {
        return acms500;
    }

    public static int[] getCubs500() {
        return cubs500;
    }

    public static int[] getErs500() {
        return ers500;
    }

    public static int[] getAcms1000() {
        return acms1000;
    }

    public static int[] getCubs1000() {
        return cubs1000;
    }

    public static int[] getErs1000() {
        return ers1000;
    }

    public static int[] getAcms1500() {
        return acms1500;
    }

    public static int[] getCubs1500() {
        return cubs1500;
    }

    public static int[] getErs1500() {
        return ers1500;
    }

    public static int[] getAcms2000() {
        return acms2000;
    }

    public static int[] getCubs2000() {
        return cubs2000;
    }

    public static int[] getErs2000() {
        return ers2000;
    }

    public static String getTcpath() {
        return tcpath;
    }

    /**
     * 返回不同测试对象的分区数目
     *
     * @param objectName 测试对象名字 ACMS CUBS ERS
     * @return 分区的数目
     */
    public static int getPartitionNumber(String objectName) {
        if (objectName.equals("ACMS"))
            return 8;
        else if (objectName.equals("CUBS"))
            return 4;
        else if (objectName.equals("ERS"))
            return 12;
        else
            return -1;
    }


    /**
     * 返回不同测试对象的变异体数目
     *
     * @param objectName 测试对象的名字：ACMS CUBS ERS
     * @return 变异体的数目
     */
    public static int getMutantsNumber(String objectName) {
        if (objectName.equals("ACMS"))
            return 2;
        else if (objectName.equals("CUBS"))
            return 1;
        else if (objectName.equals("ERS"))
            return 1;
        else
            return -1;
    }

    public static int getNumber() {
        return number;
    }

    public static String getAcmssource() {
        return acmssource;
    }

    public static String getCubssource() {
        return cubssource;
    }

    public static String getErssource() {
        return erssource;
    }

    public static int getRepeatNumber() {
        return repeatNumber;
    }


    public static String getResultPath() {
        return resultPath;
    }

    public static String getKilledmutantinfo() {
        return killedmutantinfo;
    }
}
