package Executor;

/**
 * @author RoFire
 * @date 2021/2/1
 **/
public class executor {
    public static void main(String[] args) {
        String ObjectName = "ACMS";
        int tcnum = 500;

        RLAPT_rpt rpt = new RLAPT_rpt();
        RLAPT_drt drt = new RLAPT_drt();
        RLAPT_mapt mapt = new RLAPT_mapt();
        RLAPT_rapt rapt = new RLAPT_rapt();
        RLAPT_rlaptq q = new RLAPT_rlaptq();
        RLAPT_rlapts s = new RLAPT_rlapts();

        for (int i = 0; i < 100; i++) {
            rpt.testing(ObjectName, tcnum, i);
            drt.testing(ObjectName, tcnum, i);
            mapt.testing(ObjectName, tcnum, i);
            rapt.testing(ObjectName, tcnum, i);
            q.testing(ObjectName, tcnum, i);
            s.testing(ObjectName, tcnum, i);
        }
    }
}
