package search;

import java.util.Scanner;

class Binary_Search {
    static int binarySearch(int[] a, int n, int key) {
        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key)
                return pc;
            else if (a[pc] < key) {
                pl = pc + 1;
            }
            else {
                pr = pc - 1;
            }
        } while (pl <= pr);
        return -1;
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("몇 개까지 입력할거니 : ");
        int n = stdIn.nextInt();

        int[] list = new int[n];
        System.out.print("list[0] : ");
        list[0] = stdIn.nextInt();
        for (int i = 1; i < n; i++) {
            do {
                System.out.print("list[" + i + "] : ");
                list[i] = stdIn.nextInt();
            } while (list[i] < list[i - 1]); // 오름차순 위배하면 다시 입력받기
        }
        System.out.print("원하는 값을 입력하세요. : ");
        int key = stdIn.nextInt();
        int index = binarySearch(list, n, key);
        if (index == -1)
            System.out.println("값이 없습니다.");
        else
            System.out.println("찾는 값은 list[" + index + "]에 있습니다.");

    }

}