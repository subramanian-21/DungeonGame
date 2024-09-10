import java.util.Scanner;

public class Dungeons {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dimensions of dungeon :");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.print("Enter position of the adventurer :");
        int rowA = scanner.nextInt();
        int colA = scanner.nextInt();

        System.out.print("Enter position of gold :");
        int rowG = scanner.nextInt();
        int colG = scanner.nextInt();

        boolean[][] visited = new boolean[m][n];
        Dungeons dun = new Dungeons();
        // qn1
        System.out.println(dun.findPath(visited, rowA-1, colA-1, rowG-1, colG-1, 0));
    }
    public int findPath(boolean[][] visited, int row, int col, int rowEnd, int colEnd, int count){
        if(row == rowEnd && col == colEnd){
            return count;
        };
        if(!isValidPath(row, col, visited)){
            return Integer.MAX_VALUE;
        }
        visited[row][col] = true;

        int l = findPath(visited, row-1, col, rowEnd, colEnd, count+1);
        int r = findPath(visited, row+1, col, rowEnd, colEnd, count+1);
        int t = findPath(visited, row, col-1, rowEnd, colEnd, count+1);
        int b = findPath(visited, row, col+1, rowEnd, colEnd, count+1);

        visited[row][col] = false;
        return Math.min(Math.min(l, r), Math.min(t, b));
    }
    public boolean isValidPath(int row, int col, boolean[][] arr){
        return row>=0 && col >=0 && row<arr.length && col < arr[row].length && !arr[row][col];
    }
}
