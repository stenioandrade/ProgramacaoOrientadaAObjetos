public class RandomTesterMain {
    public static void main(String[] args){
       RandomTester rt = new RandomTester();
        System.out.println("oneRandom(1000)");
          rt.printOneRandom();
          System.out.println("multiRandom(1000)*5");
          rt.printMultiRandom(5);
          System.out.println("throwMinMax(1,6)");
          rt.throwMinMax(1, 6);
          System.out.println("throwMax(6)");
         rt.throwMax(6);
         System.out.println("throwMax2(10)");
         rt.throwMax2(10);
    }
}