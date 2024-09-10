import java.util.Scanner;

public class DungeonsQn4 {
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

        System.out.print("Enter position of Trigger :");
        int rowT = scanner.nextInt();
        int colT = scanner.nextInt();

        System.out.print("Enter position of Gold :");
        int rowG = scanner.nextInt();
        int colG = scanner.nextInt();

        boolean[][] visited = new boolean[m][n];
        Dungeons dun = new Dungeons();
        int findPathAdventurer = dun.findPath(visited, rowA-1, colA-1, rowG-1, colG-1, 0);
        int findPathMonster = dun.findPath(visited, rowM-1, colM-1, rowG-1, colG-1, 0);
        if(findPathMonster < findPathAdventurer){
            // find trigger
            int triggerLen = dun.findPath(visited, rowA-1, colA-1, rowT-1, colT-1, 0);
            int triggerToGoldLen =  dun.findPath(visited, rowT-1, colT-1, rowG-1, colG-1, 0);
            System.out.println("Minimum number of steps :"+(triggerLen+triggerToGoldLen));
        }else {
            System.out.println("Minimum number of steps :"+findPathAdventurer);
        }
    }
}
