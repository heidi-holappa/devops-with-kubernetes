package fi.holappa.pong.metric;

public class PongMetric {

    private int pongMetric;

    public PongMetric() {
        this.pongMetric = 0;
    }

    public void increment() {
        this.pongMetric += 1;
    }

    public int getPongMetric() {
        return this.pongMetric;
    }

    public String toString() {
        return "Pong: " + this.pongMetric;
    }
}
