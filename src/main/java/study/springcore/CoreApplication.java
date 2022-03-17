package study.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Stack;

@SpringBootApplication
public class CoreApplication {
    {

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        ArrayList<Stack<Integer>> list = new ArrayList<>();

        for (int i=0 ; i<board.length ; i++) {
            Stack<Integer> yPosStack = new Stack<>();
            for(int j=board.length-1 ; j>=0 ; j--) {
                int y = board[j][i];
                if (y == 0) {
                    continue;
                }
                yPosStack.push(y);
            }
            list.add(yPosStack);
        }

        Stack<Integer> result = new Stack<>();
        Integer rr = 0;
        for (int i=0 ; i<moves.length ; i++) {
            int tmp = list.get(moves[i]-1).isEmpty() ? 0 : list.get(moves[i]-1).pop();
            if (!result.isEmpty() && result.peek() == tmp) {
                rr += 2;
                result.pop();
                continue;
            }
            result.push(tmp);
        }
    }

    public static void main(String[] args) { SpringApplication.run(CoreApplication.class, args); }

}


