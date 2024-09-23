package 資料庫管理;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class Member {
    String name; 
    double chineseScore;
    double englishScore;
    double mathScore;
    double averageScore;

    public Member(String name, double chineseScore, double englishScore, double mathScore) {
        this.name = name;
        this.chineseScore = chineseScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
        this.averageScore = (chineseScore + englishScore + mathScore) / 3;
    }
}

public class W1 {

    public static void main(String[] args) {
        ArrayList<Member> members = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("輸入成員數量: ");
        int score = scanner.nextInt();
        scanner.nextLine(); 
        for (int i = 0; i < score; i++) {
            System.out.print("輸入成員姓名: ");
            String name = scanner.nextLine();
            System.out.print("輸入 " + name + " 的國文成績: ");
            double chineseScore = scanner.nextDouble();
            System.out.print("輸入 " + name + " 的英文成績: ");
            double englishScore = scanner.nextDouble();
            System.out.print("輸入 " + name + " 的數學成績: ");
            double mathScore = scanner.nextDouble();
            scanner.nextLine(); 
            members.add(new Member(name, chineseScore, englishScore, mathScore));
        }
        Collections.sort(members, new Comparator<Member>() {
            @Override
            public int compare(Member m1, Member m2) {
                return Double.compare(m2.averageScore, m1.averageScore); 
            }
        });
        System.out.println("\n成員的成績與排名:");
        for (int i = 0; i < members.size(); i++) {
            Member member = members.get(i);
            System.out.println((i + 1) + ". " + member.name + " - 國文: " + member.chineseScore + 
                               " 英文: " + member.englishScore + " 數學: " + member.mathScore + 
                               " 平均分數: " + String.format("%.2f", member.averageScore));
        }
    }
}
