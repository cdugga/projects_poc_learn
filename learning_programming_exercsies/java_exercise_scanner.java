import java.util.*;
import java.util.stream.*;


public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        IntStream.range(0, 3).map(i -> scan.nextInt()).forEach(e->System.out.println(e));
    }
}
