import java.util.Scanner;

public class main {
    public static void main (String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String s = sc.nextLine();

        System.out.println("Введите подстроку:");
        String pattern = sc.nextLine();

        System.out.println("Использовать чувствительность регистра?");
        String o = sc.nextLine();
        if (o.equalsIgnoreCase("Да")) {
            String poln = pattern + "#" + s;
            int[] p = prefixFunction(poln);
            int otv1 = 0;
            for (; p[otv1] != pattern.length(); otv1++)
                if (otv1 == poln.length()-1) {
                    System.out.println("Нет совпадений");
                    break;
                }
            if (p[otv1] == pattern.length()) {
                otv1 = otv1 - 2 * pattern.length();
                int otv2 = s.indexOf(pattern);
                System.out.println("Индекс первого входа " + otv1 + " И в java " + otv2);
            }
        }else {
                String ss = s.toLowerCase();
                String sss = pattern.toLowerCase();
                String poln = sss + "#" + ss;
                int[] p = prefixFunction(poln);
                int otv1 = 0;
                for (; p[otv1] != pattern.length(); otv1++)
                    if (otv1 == poln.length()-1) {
                        System.out.println("Нет совпадений");
                        break;
                    }
                if (p[otv1] == pattern.length()) {
                    otv1 = otv1 - 2 * pattern.length();
                    int otv2 = ss.indexOf(sss);
                    System.out.println("Индекс первого входа " + otv1 + " И в java " + otv2);
                }
            }

        }
    public static int[] prefixFunction(String s) {
        int[] p = new int[s.length()];
        int k = 0;
        for(int i = 1; i < s.length();i++) {
            while (k>0 && s.charAt(k) != s.charAt(i))
                k=p[k-1];
            if (s.charAt(k) == s.charAt(i))
                k++;
            p[i] = k;
        }
        return p;
    }
}