package lab6;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        System.out.println("Enter number of vertices in graph: ");
        int vertices = key.nextInt();
        GraphMatrix matrix = new GraphMatrix(vertices);
        matrix.printMatrix();
        matrix.computeBipartite();
        matrix.printColors();
    }
}
