import java.util.Random;
public class RandomTester{
    private Random randgenerator;
    public RandomTester(){
        randgenerator = new Random();
    }
    public void printOneRandom(){
        System.out.println(randgenerator.nextInt(5)+1);
    }
    public void printMultiRandom(int many){
        for(int i=0;i<many;i++){
            System.out.println(randgenerator.nextInt(1000));
        }
    }
    public void throwDice(){
        System.out.println(randgenerator.nextInt(6)+1);
    }
    public void throwMax(int max){
       System.out.println(randgenerator.nextInt(max)+1);
    }
    public void throwMinMax(int min, int max){
        System.out.println(randgenerator.nextInt(max-min+1)+min);
    }
    public void throwMax2(int max){
        throwMinMax(1, max);
    }
}
