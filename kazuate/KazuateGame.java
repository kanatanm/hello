import java.util.Scanner;
import java.util.Random;

public class KazuateGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int answer = random.nextInt(100) + 1; // 1～100の乱数
        int guess = 0;
        int attempts = 0;

        System.out.println("1から100までの数字を当ててください！");

        while (guess != answer) {
            System.out.print("数字を入力してください: ");
            guess = scanner.nextInt();
            attempts++;

            if (guess < answer) {
                System.out.println("もっと大きい数字です。");
            } else if (guess > answer) {
                System.out.println("もっと小さい数字です。");
            } else {
                System.out.println("正解です！" + attempts + "回目で当てました。");
            }
        }

        scanner.close();
    }
}
