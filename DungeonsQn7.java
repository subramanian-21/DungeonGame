import java.util.Scanner;

public class DungeonsQn7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Dungeons dun = new Dungeons();
        DungeonsQn3 dun3 = new DungeonsQn3();
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

        System.out.print("Enter position of Trigger :");
        int rowT = scanner.nextInt();
        int colT = scanner.nextInt();

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
            System.out.println("No possible solutions.");
        }else if(findPathAdventurer > findMonsterPath){
            // find trigger
            System.out.println("path :");
            int findTrigger = dun.findPath(visited, rowA-1, colA-1, rowT-1, colT-1, 0);
            System.out.println("Finding trigger :");
            System.out.println(dun3.findPath(visited, rowA-1, colA-1, rowT-1, colT-1, ""));
            // find gold
            System.out.println("Finding gold :");
            int findGold =  dun.findPath(visited, rowT-1, colT-1, rowG-1, colG-1, 0);
            System.out.println(dun3.findPath(visited, rowT-1, colT-1, rowG-1, colG-1,""));

            System.out.println("Minimum number of steps :"+(findTrigger+findGold));
        }else {
            System.out.println("path :");
            System.out.println(dun3.findPath(visited, rowA-1, colA-1, rowG-1, colG-1, ""));
            System.out.println("Minimum number of steps :"+findPathAdventurer);
        }
    }
}
