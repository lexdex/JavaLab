package perform_comp_task;

import performance_comparison.io.FileLineReader;

public class Main {

    public static void main(String[] args) {
        long timeBefore = System.currentTimeMillis();
        FileLineReader.read("lor.txt");
        long timeAfter = System.currentTimeMillis();
        System.out.println(timeAfter - timeBefore); 

        long timeBefore2 = System.currentTimeMillis();
        FileLineReader.readBuffered("lor.txt", 8192);
        long timeAfter2 = System.currentTimeMillis();
        System.out.println(timeAfter2 - timeBefore2); 

        long timeBefore3 = System.currentTimeMillis();
        FileLineReader.readBuffered("lor.txt", 4096);
        long timeAfter3 = System.currentTimeMillis();
        System.out.println(timeAfter3 - timeBefore3); 

        long timeBefore4 = System.currentTimeMillis();
        FileLineReader.readBuffered("lor.txt", 2048);
        long timeAfter4 = System.currentTimeMillis();
        System.out.println(timeAfter4 - timeBefore4); 
    }
}
