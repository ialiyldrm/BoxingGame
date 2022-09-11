public class BoxingGame {
    public static void main(String[] args) {
        Fighter marc = new Fighter("Marc" ,30, 100, 90, 20);
        Fighter alex = new Fighter("Alex" ,30, 90, 100, 10);
        Match match = new Match(marc,alex , 90 , 100);
        match.run();       
    }
}
