import java.util.Scanner;

public class DungeonsQn5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter dimensions of dungeon :");
        int m = scanner.nextInt();
        int n = scanner.nextInt();

        System.out.print("Enter position of the adventurer :");
        int rowA = scanner.nextInt();
        int colA = scanner.nextInt();

        System.out.print("Enter position of Gold :");
        int rowG = scanner.nextInt();
        int colG = scanner.nextInt();

        System.out.print("Enter number of pits :");
        int count = scanner.nextInt();
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<count;i++){
            System.out.print("Position of pit "+(i+1)+" :");
            int rowP =scanner.nextInt();
            int colP = scanner.nextInt();
            visited[rowP-1][colP-1] = true;
        }
        Dungeons dun = new Dungeons();
        int findPathAdventurer = dun.findPath(visited, rowA-1, colA-1, rowG-1, colG-1, 0);
        if(findPathAdventurer == Integer.MAX_VALUE){
            System.out.println("Fell into the pit");
        }else{

        System.out.println("Min number of steps :"+findPathAdventurer);
        }
    }
}
