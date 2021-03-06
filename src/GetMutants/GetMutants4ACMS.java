package GetMutants;

import ACMS.sourceCode.AirlinesBaggageBillingService;
import GenerateTestcases.GetTestcases;
import Method.Methods4Testing;
import Mutants.Mutant;
import Mutants.MutantsSet;
import TestCase.CompleteTC4ACMS;
import TestCase.TestCase4ACMS;
import _Constant.Constant;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.io.File.separator;

/**
 * @author RoFire
 * @date 2021/1/26
 **/
public class GetMutants4ACMS {
    public static void main(String[] args) throws IllegalAccessException, IOException, InvocationTargetException {
        GetMutants4ACMS acms = new GetMutants4ACMS();
        acms.getKilledInfo(500);
    }

    public void getKilledInfo(int num) throws IOException, InvocationTargetException, IllegalAccessException {
        MutantsSet mutantsSet = new MutantsSet("ACMS");
        Map<String, Mutant> mutantMap = mutantsSet.getMutants();
        String methodName = new Methods4Testing("ACMS").getMethodName();

        for (Map.Entry<String, Mutant> entry : mutantMap.entrySet()) {
            //逐个遍历每一个变异体
            List<Integer> indexs = new ArrayList<>();
            int counter = 0;

            Mutant mutant = entry.getValue();
            Object mutantInstance = null;
            Method mutantMethod = null;
            double sourceResult = 0;
            double expectedResult = 0;
            Class mutantClazz = null;
            try {
                mutantClazz = Class.forName(mutant.getFullName());
                Constructor mutantConstructor = mutantClazz.getConstructor();
                mutantInstance = mutantConstructor.newInstance();
                mutantMethod = mutantClazz.getMethod(methodName, int.class, int.class,
                        boolean.class, double.class, double.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            List<CompleteTC4ACMS> tcs = new ArrayList<>();
            tcs = GetTestcases.gettestcases4ACMS(num);

            // 储存每个分区内能杀死变异体的测试用例个数，用于计算分区失效率
            int[] partition = new int[Constant.getPartitionNumber("ACMS")];

            for (int i = 0; i < tcs.size(); i++) {
                TestCase4ACMS sourceTestCase = tcs.get(i).getTc();

                sourceResult = (double) mutantMethod.invoke(mutantInstance,
                        sourceTestCase.getAirClass(), sourceTestCase.getArea(),
                        sourceTestCase.isStudent(), sourceTestCase.getLuggage(),
                        sourceTestCase.getEconomicfee());

                expectedResult = new AirlinesBaggageBillingService().feeCalculation(sourceTestCase.getAirClass(), sourceTestCase.getArea(),
                        sourceTestCase.isStudent(), sourceTestCase.getLuggage(),
                        sourceTestCase.getEconomicfee());

                if (sourceResult != expectedResult) {
                    counter++;
                    indexs.add(tcs.get(i).getNo());
                    partition[tcs.get(i).getPartition()]++;
                }
            }// We went through each mutant

            if (counter != 0 && counter < num * 0.1)
                writeInfo(num, entry.getKey(), counter, indexs, partition);
        }
    }

    private void writeInfo(int num, String mutantName, int counter, List<Integer> index, int[] partition) {
        //cal partition failurerate
        double[] partition_failurerate = new double[Constant.getPartitionNumber("ACMS")];
        int[] tcnum_partition = Constant.getAcms500();
//        int[] tcnum_partition = Constant.getAcms1000();
//        int[] tcnum_partition = Constant.getAcms1500();
//        int[] tcnum_partition = Constant.getAcms2000();
        for (int i = 0; i < partition_failurerate.length; i++) {
            partition_failurerate[i] = (double) partition[i] / tcnum_partition[i];
        }

        String path = Constant.killedmutantinfo + separator + "ACMS#" + String.valueOf(num);
        File file = new File(path);
        PrintWriter printWriter = null;

        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.write(mutantName + ":" + counter + ":" + String.valueOf((double) counter / num) + "\n");
        printWriter.write(index.toString() + "\n");
        printWriter.write(Arrays.toString(partition) + "\n");
        printWriter.write(Arrays.toString(partition_failurerate) + "\n");
        printWriter.write("\n");
        printWriter.close();
    }
}
