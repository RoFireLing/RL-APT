package TestCase;

/**
 * @author RoFire
 * @date 2021/1/26
 **/
public class CompleteTC4ERS {
    private int no;
    private int partition;
    private TestCase4ERS tc;
    private int frameindex;

    public CompleteTC4ERS(int no, int partition, TestCase4ERS tc, int frameindex) {
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

    public TestCase4ERS getTc() {
        return tc;
    }

    public void setTc(TestCase4ERS tc) {
        this.tc = tc;
    }
}
