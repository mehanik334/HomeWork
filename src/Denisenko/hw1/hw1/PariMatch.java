package denisenko.hw1.hw1;

import java.util.Scanner;

public class PariMatch {


    static int basedMatch(int firstTeam, int secondTeam, int matchFirst, int matchSecond) {

        boolean compareMatchTeam = (firstTeam == matchFirst) && (secondTeam == matchSecond);
        boolean compareTeams1 = firstTeam > secondTeam;
        boolean compareTeams2 = secondTeam > firstTeam;
        boolean compareMatch1 = matchFirst > matchSecond;
        boolean compareMatch2 = matchSecond > matchFirst;

        return compareMatchTeam ? 2 :
                ((compareTeams1 && compareMatch1) ||
                        (compareTeams2 && compareMatch2) ? 1 : 0);
    }

    public static void main(String[] args) {
        System.out.println("Enter the result and what the user has set. Example 0,2,1,1");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String arr[] = s.split(",");
        int result = basedMatch(Integer.valueOf(arr[0]), Integer.valueOf(arr[1]), Integer.valueOf(arr[2]), Integer.valueOf(arr[3]));
        System.out.println(result);
    }

}
