package study.algolithm;

import java.util.ArrayList;
import java.util.Stack;

public class PickedDoll {

    public static void main(String[] args) {
        // m보다 n이 더 큰 경우기 때문에 자료 변환 후 서치가 좋다고 생각합니다.

        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        ArrayList<Stack<Integer>> list = new ArrayList<>();

        for (int i=0 ; i<board.length ; i++) {
            Stack<Integer> yPosStack = new Stack<>();
            for(int j=board.length-1 ; j>=0 ; j--) {
                int y = board[j][i];
                if (y == 0) {
                    break;
                }
                yPosStack.push(y);
            }
            list.add(yPosStack);
        }

        Stack<Integer> result = new Stack<>();
        Integer answer = 0;
        for (int i=0 ; i<moves.length ; i++) {
            int tmp = list.get(moves[i]-1).isEmpty() ? 0 : list.get(moves[i]-1).pop();
            if (!result.isEmpty() && result.peek() == tmp) {
                if (tmp == 0) {
                    continue;
                }
                answer += 2;
                result.pop();
                continue;
            }
            result.push(tmp);
        }
    }

    public void solution() {
        int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        Stack<Integer> stack = new Stack<Integer>();

        int answer = 0;

        for (int i=0 ; i<moves.length ; i++) {
            for(int j=0 ; j<board.length ; j++) {
                int move = board[j][moves[i]-1];
                if (move == 0) {
                    continue;
                }
                board[j][moves[i]-1] = 0;
                if(!stack.isEmpty() && stack.peek() == move) {
                    stack.pop();
                    answer += 2;
                    break;
                }
                stack.push(move);
                break;
            }
        }

        System.out.println("result : " + answer);
    }
}
