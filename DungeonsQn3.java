import java.util.Scanner;

public class DungeonsQn3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dimensions of dungeon :");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.print("Enter position of the adventurer :");
        int rowA = scanner.nextInt();
        int colA = scanner.nextInt();

        System.out.print("Enter position of monster :");
        int rowM = scanner.nextInt();
        int colM = scanner.nextInt();

        System.out.print("Enter position of Gold :");
        int rowG = scanner.nextInt();
        int colG = scanner.nextInt();

        boolean[][] visited = new boolean[m][n];
        visited[rowM-1][colM-1] = true;
        DungeonsQn3 dun = new DungeonsQn3();
        String findPathAdventurer = dun.findPath(visited, rowA-1, colA-1, rowG-1, colG-1, "");
        System.out.println(findPathAdventurer);
    }
    public String findPath(boolean[][] visited, int row, int col, int rowEnd, int colEnd, String paths){
        if(row == rowEnd && col == colEnd){
            return paths+"("+(row+1)+","+(col+1)+")";
        };
        if(!isValidPath(row, col, visited)){
            return "000000000".repeat(visited.length*visited.length);
        }
        visited[row][col] = true;
        String t = findPath(visited, row-1, col, rowEnd, colEnd, paths+"("+(row+1)+","+(col+1)+") -> ");
        String b = findPath(visited, row+1, col, rowEnd, colEnd, paths+"("+(row+1)+","+(col+1)+") -> ");
        String l = findPath(visited, row, col-1, rowEnd, colEnd, paths+"("+(row+1)+","+(col+1)+") -> ");
        String r = findPath(visited, row, col+1, rowEnd, colEnd, paths+"("+(row+1)+","+(col+1)+") -> ");

        visited[row][col] = false;
        String min = t;

        if(b.length() < min.length()){
            min = b;
        }
        if( l.length() < min.length()){
            min = l;
        }
        if(r.length() < min.length()){
            min = r;
        }
        return min;
    }
    public boolean isValidPath(int row, int col, boolean[][] arr){
        return row>=0 && col >=0 && row<arr.length && col < arr[row].length && !arr[row][col];
    }
}
