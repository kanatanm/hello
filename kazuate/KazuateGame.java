import java.util.Scanner;

public class KazuateGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int answer = 77; // 設定値
        int maxAttempts = 5;
        boolean guessed = false;

        System.out.println("１～１００の正の整数を当ててください。");
        System.out.println("5回まで予想できます。");

        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print(attempt + "回目の予想を入力してください: ");
            int guess = scanner.nextInt();

            if (guess == answer) {
                System.out.println("当たり！");
                guessed = true;
                break;
            } else {
                int diff = guess - answer;
                if (Math.abs(diff) >= 20) {
                    System.out.println("かなり違います。");
                }
                if (diff > 0) {
                    System.out.println("もっと小さい数字です。");
                } else {
                    System.out.println("もっと大きい数字です。");
                }
            }
        }

        if (!guessed) {
            System.out.println("残念！正解は " + answer + " でした。");
        }

        scanner.close();
    }
}
