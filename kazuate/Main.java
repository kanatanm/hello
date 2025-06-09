import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int target = 57;//設定値
        int maxAttempts = 5;
        Scanner scanner = new Scanner(System.in);

        System.out.println("数あてゲーム：正の整数を当ててください．");
        System.out.println("5回まで予想できるよ．");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print(attempt + "回目の予想：");
            int guess = scanner.nextInt();

            if (guess == target) {
                System.out.println("当たり！");
                break;
            } else {
                int diff = guess - target;
                if (Math.abs(diff) >= 20) {
                    System.out.println("全然違うよ．");
                }
                if (diff > 0) {
                    System.out.println("もっと小さいです．");
                } else {
                    System.out.println("もっと大きいです．");
                }
            }

            if (attempt == maxAttempts) {
                System.out.println("残念，正解は " + target + " でした．");
            }
        }

        scanner.close();
    }
}