public class Launcher {
    public static void main(String[] args) {
        PseudoRandomGenerator prng = new PseudoRandomGenerator();
        double value = 0.0;
        for (int i = 0; i < 10; i++) {
            value = prng.random();
            System.out.println(value);
        }

        long myTime = System.nanoTime();
        for(int i=0; i<10000000; i++) {
            value = prng.random();
        }

        myTime = System.nanoTime() - myTime;
        System.out.println("execution time = " + Long.toString(myTime) + " nsec ");
    }
}