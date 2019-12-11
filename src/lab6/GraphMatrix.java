package lab6;

import java.util.Arrays;
import java.util.Scanner;

public class GraphMatrix {
    private int setLength;
    private int[][] adjacencyMatrix;
    private int[] colorArray;

    public GraphMatrix(int x){
        setLength = x;
        adjacencyMatrix = createMatrix();
        colorArray = new int[x];
    }

    //Prints the adjacency matrix
    public void printMatrix() {
        String out = "";
        for (int i = 0; i < setLength; i++) {
            out += "[";
            for (int j = 0; j < this.adjacencyMatrix[i].length; j++) {
                if (this.adjacencyMatrix[i][j] == 1) {
                    out += j == adjacencyMatrix.length - 1 ? "1" : "1, ";
                } else {
                    out += j == adjacencyMatrix.length - 1 ? "0" : "0, ";
                }
            }
            out = out + "] \n";
        }
        System.out.println(out);
    }

    // Prints the colors array
    public void printColors(){
        System.out.println(Arrays.toString(colorArray));
    }

    public void computeBipartite(){
        colorArray[0] = 1;
        for(int i = 1; i < adjacencyMatrix[0].length; i++){
            colorArray[i] = adjacencyMatrix[0][i] == 1 ? 2 : 0;
        }
        for(int i = 1; i < colorArray.length; i++){
            int tempColor = colorArray[i];
            for(int j = 0; j < adjacencyMatrix[i].length; j++){
                if(adjacencyMatrix[i][j] == 1){
                    if(colorArray[j] == tempColor){
                        System.out.println("Graph is not bipartite");
                        return;
                    } else {
                        colorArray[j] = tempColor == 1 ? 2 : 1;
                    }
                }
            }
        }
        System.out.println("Graph is bipartite, bi-partition below: ");
        printColors();
    }


    private int[][] createMatrix(){
        int[][] ret = new int[setLength][setLength];
        Scanner key = new Scanner(System.in);
        System.out.println("Enter each row of the matrix one row at a time.");
        for (int i = 0; i < setLength; i++) {
            String temp = key.nextLine();
            int[] toPush = new int[setLength];
            int count = 0;
            for (int j = 0; j < temp.length(); j++) {
                if (temp.charAt(j) == '1') {
                    toPush[count] = 1;
                    count++;
                } else if (temp.charAt(j) == '0') {
                    toPush[count] = 0;
                    count++;
                } else {

                }

            }
            for (int k = 0; k < toPush.length; k++) {
                ret[i][k] = toPush[k];
            }
        }
        return ret;
    }

}
