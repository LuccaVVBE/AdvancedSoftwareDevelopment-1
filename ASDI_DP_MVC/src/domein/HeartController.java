package domein;

public class HeartController implements IController {

    private final IHeartModel heart;

    public HeartController() {
        heart = new HeartModel();
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public int getBPM() {
        return heart.getHeartRate();
    }

    @Override
    public void setBPM(int bpm) {
    }

    @Override
    public void addObserver(BeatObserver o) {
        heart.addObserver(o);
    }

    @Override
    public void addObserver(BPMObserver o) {
        heart.addObserver(o);
    }

    @Override
    public void decreaseBPM() {
    }

    @Override
    public void increaseBPM() {
    }
}
