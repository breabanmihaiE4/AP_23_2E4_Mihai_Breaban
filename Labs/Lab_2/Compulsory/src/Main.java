public class Main {
    public static void main(String[] args) {
        Location location1 = new Location("Casa", LocationType.AIRPORT, 5, 9);
        Location location2 = new Location("Iasi", LocationType.CITY, 12, 31);
        Road road1 = new Road(RoadType.EXPRESS, 120, 120, location1, location2);
        System.out.println(location2);
        System.out.println(road1);
    }
}
