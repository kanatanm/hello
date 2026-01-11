import java.util.Scanner;

public class KazuateGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int answer = 77; // 正解の数
        int maxAttempts = 5;
        boolean guessed = false;

        System.out.println("１０～９９の正の整数を当ててください。");
        System.out.println("5回まで予想できます。");

        int attempt = 1;
        while (attempt <= maxAttempts) {
            System.out.print(attempt + "回目の予想を入力してください: ");
            int guess = scanner.nextInt();

            if (guess < 10 || guess > 99) {
                System.out.println("範囲外の数字でした。もう一度やってね！");
                continue; // 試行回数に含めず再入力させる
            }

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
                attempt++; // 正しい範囲の入力だった場合のみ回数を進める
            }
        }

        if (!guessed) {
            System.out.println("残念！正解は " + answer + " でした。");
        }

        scanner.close();
    }
}
