package TestFrame;

/**
 * @author RoFire
 * @date 2021/1/30
 **/
public class _CompleteTestFrame {
    private int no;
    private int partition;
    private int frameindex;
    private String frame;

    public _CompleteTestFrame(int no, int partition, int frameindex, String frame) {
        this.no = no;
        this.partition = partition;
        this.frameindex = frameindex;
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "CompleteTestFrame{" +
                "no=" + no +
                ", partition=" + partition +
                ", frameindex=" + frameindex +
                ", frame='" + frame + '\'' +
                '}';
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

    public int getFrameindex() {
        return frameindex;
    }

    public void setFrameindex(int frameindex) {
        this.frameindex = frameindex;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }
}
