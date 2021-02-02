package TestCase;

/**
 * @author RoFire
 * @date 2021/1/25
 **/
public class CompleteTC4ACMS {
    private int no;
    private int partition;
    private TestCase4ACMS tc;
    private int frameindex;

    public CompleteTC4ACMS(int no, int partition, TestCase4ACMS tc, int frameindex) {
        this.no = no;
        this.partition = partition;
        this.tc = tc;
        this.frameindex = frameindex;
    }

    public int getFrameindex() {
        return frameindex;
    }

    public void setFrameindex(int frameindex) {
        this.frameindex = frameindex;
    }

    @Override
    public String toString() {
        return no + ";" + partition + ";" + tc.toString() + ";" + frameindex;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public TestCase4ACMS getTc() {
        return tc;
    }

    public void setTc(TestCase4ACMS tc) {
        this.tc = tc;
    }
}
