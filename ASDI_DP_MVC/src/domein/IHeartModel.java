package domein;

public interface IHeartModel {

    int getHeartRate();

    void addObserver(BeatObserver o);

    void addObserver(BPMObserver o);
}
