import java.util.Scanner;

public class Main {
    public static int getMaxValue(int[] array) {
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    public static int getMinValue(int[] array) {
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                if (array[i] != 0) {
                    minValue = array[i];
                }
            }
        }
        return minValue;
    }
    private static boolean isPrime(int num) {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }

    static boolean isDistancePrime(int x, int y){
        if (isPrime(y-x) == true){
            return true;
        } else {
            return false;
        }
    }
    public static int choose(int total, int choose){
        if(total < choose)
            return 0;
        if(choose == 0 || choose == total)
            return 1;
        return choose(total-1,choose-1)+choose(total-1,choose);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfNodes;
        numOfNodes = scanner.nextInt();
        int[] firstNode;
        int[] secondNode;
        int[] primeDistances;
        int maxArray;
        int minArray;
        primeDistances = new int[100];
        firstNode = new int[100];
        secondNode = new int[100];
        int count = 0;
        int combinationCount = 0;

        for (int i = 0; i < numOfNodes - 1; i++){
            firstNode[i] = scanner.nextInt();
            secondNode[i] = scanner.nextInt();
        }
        for (int x = 0; x < numOfNodes - 1; x++){
          for (int y = 0; y < numOfNodes - 1; y++){
              combinationCount++;
                if (isDistancePrime(firstNode[x],secondNode[y]) == true){

                        primeDistances[count] = secondNode[y] - firstNode[x];
                        count++;

                }
            }
        }
        maxArray = getMaxValue(secondNode);
        if (getMinValue(firstNode) == 1){
            minArray = getMinValue(firstNode) + 1;
        }else{ minArray = getMinValue(firstNode);}
        int comb = choose(maxArray,minArray);
        float prob = ((float) count/comb);

        System.out.println(prob);

    }

}
