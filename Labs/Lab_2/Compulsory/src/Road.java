import static java.lang.Math.sqrt;

public class Road {
    private RoadType type;
    private int length, speedLimit;
    private Location location1, location2;

    public Road(RoadType type, int length, int speedLimit, Location location1, Location location2) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
        this.location1 = location1;
        this.location2 = location2;
    }


    public RoadType getType() {
        return type;
    }

    public void setType(RoadType type) {
        this.type = type;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        if (getDistance() <= length) {
            this.length = length;
        }
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public Location getLocation1() {
        return location1;
    }

    public void setLocation1(Location location1) {
        this.location1 = location1;
    }

    public Location getLocation2() {
        return location2;
    }

    public void setLocation2(Location location2) {
        this.location2 = location2;
    }

    private int getDistance() {
        return (int) sqrt(
                (location2.getX() - location1.getX()) *
                        (location2.getX() - location1.getX()) +
                        (location2.getY() - location1.getY()) *
                                (location2.getY() - location1.getY())
        );
    }

    @Override
    public String toString() {
        return String.format(
                "ROAD( TYPE: %s, LENGHT: %d, SPEEDLIMIT: %d, LOCATION1: %s, LOCATION2: %s)",
                this.type,
                this.length,
                this.speedLimit,
                this.location1.toString(),
                this.location2.toString()
        );
    }
}
