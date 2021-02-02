package TestCase;

/**
 * @author RoFire
 * @date 2021/1/26
 **/
public class CompleteTC4CUBS {
    private int no;
    private int partition;
    private TestCase4CUBS tc;
    private int frameindex;

    public CompleteTC4CUBS(int no, int partition, TestCase4CUBS tc, int frameindex) {
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

    public TestCase4CUBS getTc() {
        return tc;
    }

    public void setTc(TestCase4CUBS tc) {
        this.tc = tc;
    }
}
