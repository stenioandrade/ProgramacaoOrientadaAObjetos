package clock;

public class Main {

    public static void main(String[] args) {
        Clock clk = new Clock(02,59,57);
        clk.timeTick();
        System.out.println(clk.getTime());
        clk.timeTick();
        System.out.println(clk.getTime());
        clk.timeTick();
        System.out.println(clk.getTime());
        clk.timeTick();
        System.out.println(clk.getTime());
        
    }
    
}
