package search;

import java.util.Scanner;
/*
    보초법 : 현재 if문에서는 값을 찾으면 return i, 못 찾으면 return -1로 두 번 판단하고 있다.
    하지만 보초법은 무조건 찾으면. 이라는 조건 하나만 만들도록 한다. 그러니까 무조건 찾는다는 것이다.
    방식은, 내가 검색하려는 값을 배열 맨 마지막에 저장한다. 이러면, 이 배열에는 내가 찾는 값이 2개, 혹은 적어도 1개는 무조건 있게 된다.
    이제 검색한다. 무조건 찾을 것이다. 하지만 그 값의 인덱스가 맨 마지막이라면 못 찾은 것이 될 것이다.
    그런데, 인덱스가 맨 마지막인지 판별하려면 또 if else 써야 되는데 뭔 차이냐고?
    반복문에서의 if else의 반복을 딱 한 번으로 줄였다.

class search.SeqSearch {
    static int seqSearch(int[] a, int n, int key) {
        for (int i = 0; i < n; i++) {
            if (a[i] == key)
                return i;
        }
        return -1;
    }

 */
class SeqSearch {
    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        a[n] = key; // 보초를 추가. n개의 크기 배열을 선언하면 인덱스는 n - 1까지니까 옳다.

        while (true) {
            if (a[i] == key) // 맨 마지막에서 찾으면 찾아도 찾은 게 아니다.
                break;
            i++;
        }
        return i == n ? -1 : i; // 맨 마지막에서 찾았으면 -1 반환, 그렇지 않으면 index값 반환
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);


        System.out.print("요소의 개수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num + 1]; // 보초 하나 추가

        for(int i = 0; i < num; i++) {
            x[i] = stdIn.nextInt();
        }
        System.out.print("검색할 값: ");
        int ky = stdIn.nextInt();
        int result = seqSearch(x, num, ky);
        if (result == -1)
            System.out.println("찾는 값은 존재하지 않습니다.");
        else
            System.out.println("그 값은 x[" + result + "]에 있습니다.");
    }
}