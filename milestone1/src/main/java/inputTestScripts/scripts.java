/*
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Random;

public void P1writeInputSize2000(){
    int[] thousand_array = new int[2001];
    Random r = new Random();
    thousand_array[0] = 0;
    thousand_array[1] = r.nextInt(1, Integer.MAX_VALUE);

    for(int i = 2 ; i < 2001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_2k.txt"));
        for(int i = 0; i < 2001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 2000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P1writeInputSize4000(){
    int[] thousand_array = new int[4001];
    Random r = new Random();
    thousand_array[0] = 0;
    thousand_array[1] = r.nextInt(1, Integer.MAX_VALUE);

    for(int i = 2 ; i < 4001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_4k.txt"));
        for(int i = 0; i < 4001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 4000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P1writeInputSize6000(){
    int[] thousand_array = new int[6001];
    Random r = new Random();
    thousand_array[0] = 0;
    thousand_array[1] = r.nextInt(1, Integer.MAX_VALUE);

    for(int i = 2 ; i < 6001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_6k.txt"));
        for(int i = 0; i < 6001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 6000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P1writeInputSize8000(){
    int[] thousand_array = new int[8001];
    Random r = new Random();
    thousand_array[0] = 0;
    thousand_array[1] = r.nextInt(1, Integer.MAX_VALUE);

    for(int i = 2 ; i < 8001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_8k.txt"));
        for(int i = 0; i < 8001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 8000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P1writeInputSize10000(){
    int[] thousand_array = new int[10001];
    Random r = new Random();
    thousand_array[0] = 0;
    thousand_array[1] = r.nextInt(1, Integer.MAX_VALUE);

    for(int i = 2 ; i < 10001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_10k.txt"));
        for(int i = 0; i < 10001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 10000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P2writeInputSize2000(){
    int[] thousand_array = new int[2001];
    Random r = new Random();
    Random peakIndex = new Random();
    int peak = peakIndex.nextInt(1, 2001);
    thousand_array[0] = 0;
    thousand_array[peak] = new Random().nextInt(Integer.MAX_VALUE);

    for(int i = peak - 1; i >= 1; i--){
        thousand_array[i] = r.nextInt(1, thousand_array[i + 1] + 1);
    }

    for(int i = peak + 1; i < 2001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_2k.txt"));
        for(int i = 0; i < 2001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 2000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P2writeInputSize4000(){
    int[] thousand_array = new int[4001];
    Random r = new Random();
    Random peakIndex = new Random();
    int peak = peakIndex.nextInt(1, 4001);
    thousand_array[0] = 0;
    thousand_array[peak] = new Random().nextInt(Integer.MAX_VALUE);

    for(int i = peak - 1; i >= 1; i--){
        thousand_array[i] = r.nextInt(1, thousand_array[i + 1] + 1);
    }

    for(int i = peak + 1; i < 4001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_4k.txt"));
        for(int i = 0; i < 4001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 4000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P2writeInputSize6000(){
    int[] thousand_array = new int[6001];
    Random r = new Random();
    Random peakIndex = new Random();
    int peak = peakIndex.nextInt(1, 6001);
    thousand_array[0] = 0;
    thousand_array[peak] = new Random().nextInt(Integer.MAX_VALUE);

    for(int i = peak - 1; i >= 1; i--){
        thousand_array[i] = r.nextInt(1, thousand_array[i + 1] + 1);
    }

    for(int i = peak + 1; i < 6001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_6k.txt"));
        for(int i = 0; i < 6001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 6000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P2writeInputSize8000(){
    int[] thousand_array = new int[8001];
    Random r = new Random();
    Random peakIndex = new Random();
    int peak = peakIndex.nextInt(1, 8001);
    thousand_array[0] = 0;
    thousand_array[peak] = new Random().nextInt(Integer.MAX_VALUE);

    for(int i = peak - 1; i >= 1; i--){
        thousand_array[i] = r.nextInt(1, thousand_array[i + 1] + 1);
    }

    for(int i = peak + 1; i < 8001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_8k.txt"));
        for(int i = 0; i < 8001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 8000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public void P2writeInputSize10000(){
    int[] thousand_array = new int[10001];
    Random r = new Random();
    Random peakIndex = new Random();
    int peak = peakIndex.nextInt(1, 10001);
    thousand_array[0] = 0;
    thousand_array[peak] = new Random().nextInt(Integer.MAX_VALUE);

    for(int i = peak - 1; i >= 1; i--){
        thousand_array[i] = r.nextInt(1, thousand_array[i + 1] + 1);
    }

    for(int i = peak + 1; i < 10001; i++) {
        thousand_array[i] = r.nextInt(1, thousand_array[i - 1] + 1);
    }

    try{
        BufferedWriter output = new BufferedWriter(new FileWriter("./input_10k.txt"));
        for(int i = 0; i < 10001; i++){
            output.write(Integer.toString(thousand_array[i]));
            if(i != 10000){
                output.write(' ');
            }
        }
        output.flush();
    }
    catch (Exception e) {
        throw new RuntimeException("Error writing to file.");
    }
}

public static void main() {
    //Program I
    P1writeInputSize2000();
    System.out.println();
    System.out.println("First file complete -> n = 2000");

    P1writeInputSize4000();
    System.out.println();
    System.out.println("First file complete -> n = 4000");

    P1writeInputSize6000();
    System.out.println();
    System.out.println("First file complete -> n = 6000");

    P1writeInputSize8000();
    System.out.println();
    System.out.println("First file complete -> n = 8000");

    P1writeInputSize10000();
    System.out.println();
    System.out.println("First file complete -> n = 10000");


    //Program II
    P2writeInputSize2000();
    System.out.println();
    System.out.println("Second file complete -> n = 2000");

    P2writeInputSize4000();
    System.out.println();
    System.out.println("Second file complete -> n = 4000");

    P2writeInputSize6000();
    System.out.println();
    System.out.println("Second file complete -> n = 6000");

    P2writeInputSize8000();
    System.out.println();
    System.out.println("Second file complete -> n = 8000");

    P2writeInputSize10000();
    System.out.println();
    System.out.println("Second file complete -> n = 10000");
}
*/