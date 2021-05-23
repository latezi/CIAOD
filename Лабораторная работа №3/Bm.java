import java.util.HashMap;
import java.util.Scanner;

public class Bm {



    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строку:");
        String source = sc.nextLine();

        System.out.println("Введите подстроку:");
        String template = sc.nextLine();

        int[] p = function(template);

        HashMap<Character, Integer> table = new HashMap<>();
        for (int i = 0; i< template.length(); i++){
            if (table.containsKey(template.charAt(i)))
                continue;
            table.put(template.charAt(i),p[i]);
        }

        int k = ishetOtvet(template,source,table);

        if (k>=0)   System.out.print("Вот индекс " + k);
        else System.out.print("Такой подстроки здесь нет");

    }
    public static int ishetOtvet (String template, String source, HashMap<Character, Integer> table) {
        int j = template.length() - 1;
        while (j<source.length()) {
            for (int i = template.length() - 1; i>=0; i--, j--) {
                if (template.charAt(i) != source.charAt(j)) {
                    if (table.containsKey(source.charAt(j))) {
                        j += table.get(source.charAt(j));
                    } else {
                        j += template.length();
                    }
                    break;
                }
                if (i == 0) return j;
            }
        }
        return -1;
    }
    public static int[] function (String template) {
        int[] d = new int[template.length()];
        int k = 0;
        int j=0;
        int l = template.length() - 1;
        for (int i = template.length(); i > 0; i--) {
            d[i - 1] = k;
            while (j < k) {
                if (template.charAt(i - 1) == template.charAt(l - j)) {
                    d[i - 1] = d[l - j];
                    break;
                }
                j++;
            }
            j = 0;
            k++;
        }
        return d;
    }
}
