import java.util.Scanner;

public class DungeonsQn6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dungeons dun = new Dungeons();
        System.out.print("Enter dimensions of dungeon :");
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        boolean[][] visited = new boolean[m][n];

        System.out.print("Enter position of the adventurer :");
        int rowA = scanner.nextInt();
        int colA = scanner.nextInt();

        System.out.print("Enter position of monster :");
        int rowM = scanner.nextInt();
        int colM = scanner.nextInt();

        System.out.print("Enter position of Gold :");
        int rowG = scanner.nextInt();
        int colG = scanner.nextInt();
        int findMonsterPath = dun.findPath(visited, rowM-1, colM-1, rowG-1, colG-1, 0);

        System.out.print("Enter number of pits :");
        int count = scanner.nextInt();

        for(int i = 0;i<count;i++){
            System.out.print("Position of pit "+(i+1)+" :");
            int rowP =scanner.nextInt();
            int colP = scanner.nextInt();
            visited[rowP-1][colP-1] = true;
        }
        int findPathAdventurer = dun.findPath(visited, rowA-1, colA-1, rowG-1, colG-1, 0);
        if(findPathAdventurer == Integer.MAX_VALUE){
            System.out.println("fell into the pit");
        }else if(findPathAdventurer > findMonsterPath){
            System.out.println("Monster kills you");
        }else {
            System.out.println("Minimum number of steps :"+findPathAdventurer);
        }
    }
}
