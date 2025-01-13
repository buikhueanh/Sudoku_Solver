import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Helper {
    public static final int N = 9;
    private Map<Integer, String> getDictionary() {
        Map<Integer, String> dic = new HashMap<Integer, String>();
        dic.put(1, "mode/easy.txt");
        dic.put(2, "mode/medium.txt");
        dic.put(3, "mode/hard.txt");
        dic.put(4, "mode/very_hard.txt");

        return dic;
    }

    private int chooseFile() {
        int fileMode;
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("There are 4 different levels:");
            System.out.println("1. Easy");
            System.out.println("2. Medium");
            System.out.println("3. Hard");
            System.out.println("4. Very Hard");
            System.out.println("Please input the corresponding number to choose your file:");
            try {
                fileMode = s.nextInt();
                switch (fileMode) {
                    case 1:
                        System.out.println("You chose Easy.");
                        return 1;

                    case 2:
                        System.out.println("You chose Medium.");
                        return 2;

                    case 3:
                        System.out.println("You chose Hard");
                        return 3;

                    case 4:
                        System.out.println("You chose Very Hard");
                        return 4;

                    default:
                        System.out.println("Incorrect Input.");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Please re-enter a valid number");
                continue;
            }
        }
    }

    public String getInput() {
        Map<Integer, String> dic = getDictionary();
        int fileMode = chooseFile();
        String fileName = dic.get(fileMode);
        try {
            File file = new File (fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("Cannot find the file");
        }
        return fileName;
    }

    public int[][] getGrid(String fileName) {
        int[][] grid = new int[N][N];
        int skippedLine = 0;
        try {
            for (int row = 0; row < N; row++) {
                String line = Files.readAllLines(Paths.get(fileName)).get(skippedLine);
                for (int i = 0; i < N; i++) {
                    String[] line1 = line.trim().split(" ");
                    grid[row][i] = Integer.parseInt(line1[i]);
                }
                skippedLine++;
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
        return grid;
    }


}
