import org.milestone1.Program1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.io.File;

public class Program1RuntimeAnalysis {
    public static int[] arrayBuilder(String inputPath){
        ArrayList<Integer> base = new ArrayList<>();
        try{
            Scanner readPath = new Scanner(new File(inputPath));
            while(readPath.hasNext()){
                int data = Integer.parseInt(readPath.next());
                base.add(data);
            }

            int[] arr = new int[base.size()];
            for(int i = 0; i < base.size(); i++){
                arr[i] = base.get(i);
            }
            return arr;
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        System.out.println("=== PROGRAM 1 RUNTIME ANALYSIS ===");
        Random r = new Random();

        //Test 1
        int[] first = arrayBuilder("./src/main/java/testFiles_program1/input_2k.txt");
        System.out.println("Test 1 -> n=" + (first.length - 1));
        long start_1 = System.nanoTime();
        Program1.program1(first.length - 1, r.nextInt(1, first.length), first);
        System.out.println("Test 1 Elapsed Time: " + (System.nanoTime() - start_1));
        System.out.println();

        //Test 2
        int[] second = arrayBuilder("./src/main/java/testFiles_program1/input_4k.txt");
        System.out.println("Test 2 -> n=" + (second.length - 1));
        long start_2 = System.nanoTime();
        Program1.program1(second.length - 1, r.nextInt(1, second.length), second);
        System.out.println("Test 2 Elapsed Time: " + (System.nanoTime() - start_2));
        System.out.println();

        //Test 3
        int[] third = arrayBuilder("./src/main/java/testFiles_program1/input_6k.txt");
        System.out.println("Test 3 -> n=" + (third.length - 1));
        long start_3 = System.nanoTime();
        Program1.program1(third.length - 1, r.nextInt(1, third.length), third);
        System.out.println("Test 3 Elapsed Time: " + (System.nanoTime() - start_3));
        System.out.println();

        //Test 4
        int[] fourth = arrayBuilder("./src/main/java/testFiles_program1/input_8k.txt");
        System.out.println("Test 4 -> n=" + (fourth.length - 1));
        long start_4 = System.nanoTime();
        Program1.program1(fourth.length - 1, r.nextInt(1, fourth.length), fourth);
        System.out.println("Test 4 Elapsed Time: " + (System.nanoTime() - start_4));
        System.out.println();

        //Test 5
        int[] fifth = arrayBuilder("./src/main/java/testFiles_program1/input_10k.txt");
        System.out.println("Test 5 -> n=" + (fifth.length - 1));
        long start_5 = System.nanoTime();
        Program1.program1(fifth.length - 1, r.nextInt(1, fifth.length), fifth);
        System.out.println("Test 5 Elapsed Time: " + (System.nanoTime() - start_5));
        System.out.println();
    }
}
