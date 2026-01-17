package search;

import java.util.Scanner;

class PrimeNumber {
    public static void main(String[] args) {
        int counter = 0; // 나눗셈의 횟수
        int ptr = 0;
        int[] prime = new int[500];

        Scanner stdIn = new Scanner(System.in);
        System.out.println("어디까지 셀까 : ");
        int n = stdIn.nextInt();
        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for (int p = 5; p <= n; p += 2) {
            boolean flag = false;
            for (int q = 1; prime[q] * prime[q] <= p; q++) {
                counter += 2;
                if (p % prime[q] == 0)
                    flag = true; //나누어떨어짐
                    break;
            }
            if (!flag) {
                prime[ptr++] = p;
                counter++;
            }
        }
        for(int i = 0; i < ptr; i++) {
            System.out.println(prime[i]);
        }
        System.out.println("곱셈과 나눗셈을 수행한 횟수 : " + counter);
    }
}

