package application;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] matriz = new int[m][n];

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j ++){
                matriz[i][j] = sc.nextInt();
            }
        }

        int x = sc.nextInt();

        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                if(matriz[i][j] == x){
                    Integer up = getUp(matriz,i,j);
                    Integer down = getDown(matriz,i,j);
                    Integer left = getLeft(matriz,i,j);
                    Integer right = getRight(matriz,i,j);

                    System.out.println("Position: " + i + "," + j);
                    if(left != null)
                        System.out.println("Left: " + left);
                    if(right != null)
                        System.out.println("Right: " + right);
                    if(up != null)
                        System.out.println("Up: " + up);
                    if(down != null)
                        System.out.println("Down: " + down);
                }
            }
        }
        sc.close();
    }

    public static Integer getUp(int[][] matriz, int i, int j){
        if( i - 1 < 0){
            return null;
        }
        return matriz[i - 1][j];
    }

    public static Integer getDown(int[][] matriz, int i, int j){
        if( i + 1 > matriz[i].length){
            return null;
        }
        return matriz[i + 1][j];
    }

    public static Integer getLeft(int[][] matriz, int i, int j){
        if( j - 1 < 0){
            return null;
        }
        else {
            return matriz[i][j - 1];
        }
    }

    public static Integer getRight(int[][] matriz, int i, int j){
        if( j + 1 >= matriz.length){
            return null;
        }
        return matriz[i][j + 1];
    }
}
