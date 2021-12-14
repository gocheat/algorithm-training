package com.gocheat.recursion;

// Q. 퀸이 움직일 수 있는 경로 구하기
// 상태 공간 트리를 활용하여 모든 경우의 수를 깊이우선탐색 방식으로 서치
public class NQueensProblem {

    // N값은 행의 길이
    // level값은 현재 열의 위치
    private final int N = 4;

    // 각 열에 들어간 queen 위치
    int []cols = new int[N+1];
    int result = 0;

    public boolean queens(int level) {
        //현재 level 에서 queen 을 놓을수 있을지 판단
        if(!promising(level))
            return false;
        else if(level == N) {
            result++;
            System.out.println(result+"번째 Queens ");
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (cols[i] == j) {
                        System.out.print("1 ");
                    }else{
                        System.out.print("0 ");
                    }
                }
                System.out.println("");
            }
            System.out.println("");
            return true;
        }else {
            for (int i = 1; i <= N; i++) {
                cols[level + 1] = i;
                queens(level + 1);
            }
        }
        return false;
    }

    private boolean promising(int level){
        for (int i = 1; i < level; i++){
            //현재 level에서 놓은 queen 의 행값이 동일한지 체크
            if(cols[i] == cols[level]){
                return false;
            // 놓인 좌표간의 깊이와 대각선 깊이 체크
            }else if (Math.abs(cols[level] - cols[i]) == level-i) {
                return false;
            }
        }
        // 그외는 모두 OK
        return true;
    }

    public static void main(String[] args) {
        // 퀸이 움직일 수 있는 경로 구하기
        NQueensProblem nQueensProblem = new NQueensProblem();
        nQueensProblem.queens(1);
    }
}

