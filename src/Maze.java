import java.io.*;
import java.util.Arrays;

public class Maze {

    private int m;
    private int n;

    private int[][] a;

    private static final int OPEN=0, WALL=1, TRIED=2,PATH=3;

    public Maze(String file) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            m = Integer.parseInt(reader.readLine());
            n = Integer.parseInt(reader.readLine());

            a = new int[m][n];

            StringBuilder sequenceBuilder = new StringBuilder();
            for (int i = 0; i < m; i++) {
                sequenceBuilder.append(reader.readLine());
            }
            String sequence = sequenceBuilder.toString();

            int index = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char valueChar = sequence.charAt(index++);
                    a[i][j] = Character.getNumericValue(valueChar);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isOpen(Location location)
    {
        return (a[location.getY()][location.getX()]==OPEN);
    }
    public void markMoved(Location location)
    {
        a[location.getY()][location.getX()]=PATH;
    }

    public void markTried(Location location)
    {
        a[location.getY()][location.getX()]=TRIED;
    }
    public int getWidht(){
        return n;
    }
    public int getHeight(){
        return m;
    }

    public void print()
    {
        char[] chars={' ','#','?','o'};
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++)
            {
                System.out.print(chars[a[i][j]]);
            }
            System.out.println();
        }
    }

}
