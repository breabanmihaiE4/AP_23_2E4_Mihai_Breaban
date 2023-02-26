public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] languages = new String[]{"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        String number = "10101";
        n = n + Integer.parseInt(number, 2);
        number = "FF";
        n = n + Integer.parseInt(number, 16);
        n = n * 6;
        System.out.println(n);
        System.out.println(n % 9);
        if(n % 9 == 0){
            n = 9;
        } else {
            n = n % 9;
        }
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}