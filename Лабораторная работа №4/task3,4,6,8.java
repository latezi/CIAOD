import java.io.*;

public class main extends stackk {

    public static void main(String arg[]) throws IOException {

        /*    "Ханойские башни"
        stackk AStack = new stackk();
        stackk BStack = new stackk();
        stackk CStack = new stackk();

        int n = 6;
        int k = 1;
        int m = 3;

        for (int i = n; i > 0; i--) {
            AStack.addElement(String.valueOf(i));
        }

        CStack = piramidki(AStack, BStack, CStack, n, k,m);

        System.out.print("C Стак - ");
        while (!CStack.isEmpty()) {
            String el = CStack.deleteElement();
            System.out.print(el + " ");
        }

// "Проверка скобок" 4
        stackk Stack = new stackk();
        try(FileReader reader = new FileReader("notes.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);

                if (c == 40) {
                    Stack.addElement(Character.toString(c));
                }
                if (c== 41) {
                    if (Stack.isEmpty()) {
                        Stack.addElement("y");
                        break;
                    }
                    if ("(".equals(Stack.readLast()) ) Stack.deleteElement();
                    else break;
                }
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        System.out.println("Баланс соблюдён? "+ Stack.isEmpty());

         */

    /*6 задание
        stackk Stack = new stackk();
        stackk Numbers = new stackk();
        stackk Letters = new stackk();
        stackk Symbols = new stackk();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("sort.txt"));
            int c;
            while ((c = reader.read()) != -1) {
                if (c==32) continue;
                if (c == 48 ||c ==49 ||c ==50 ||c ==51 ||c ==52 ||c ==53|| c ==54 ||c ==55 ||c ==56 ||c ==57) {
                    Numbers.addElement(Character.toString(c));
                    continue;
                }
                if (Character.isLetter(c)) {
                    Letters.addElement(Character.toString(c));
                    continue;
                }
                Symbols.addElement(Character.toString(c));
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        while (!Symbols.isEmpty()) {
            Stack.addElement(Symbols.deleteElement());
        }
        while (!Letters.isEmpty()) {
            Stack.addElement(Letters.deleteElement());
        }
        while (!Numbers.isEmpty()) {
            Stack.addElement(Numbers.deleteElement());
        }
        try(FileWriter writer = new FileWriter("writesort.txt", false))
        {
            while (!Stack.isEmpty()) {
                String text = Stack.deleteElement();
                writer.write(text);
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
*/


/*8 задание
        stackk Stack = new stackk();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("notes.txt"));
            String line = reader.readLine();
            while (line!= null) {
                Stack.addElement(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileWriter writer = new FileWriter("writepere.txt", false))
        {
            // запись всей строки
            while (!Stack.isEmpty()) {
                String text = Stack.deleteElement();
                writer.write(text);
                writer.append('\n');
            }
            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
*/
//9 задание попытка
   /*     int z = 0;
        int s = 0;
        stackk Stack = new stackk();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("log.txt"));
            int c;
            while ((c = reader.read()) != -1) {
                Stack.addElement(Character.toString(c));
                System.out.print(Stack.readLast());
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        */

    }





    public static stackk piramidki(stackk AStack, stackk BStack, stackk CStack, int n, int k, int m) {

        if (n == 1) {
            if (k == 1 && m == 3) CStack.addElement(AStack.deleteElement());
            if (k == 1 && m == 2) BStack.addElement(AStack.deleteElement());
            if (k == 2 && m == 3) CStack.addElement(BStack.deleteElement());
            if (k == 2 && m == 1) AStack.addElement(BStack.deleteElement());
            if (k == 3 && m == 1) AStack.addElement(CStack.deleteElement());
            if (k == 3 && m == 2) BStack.addElement(CStack.deleteElement());
            return CStack;
        } else {
            int tmp = 6 - m - k;
            piramidki(AStack, BStack, CStack, n - 1, k, tmp);
            {
                if (k == 1 && m == 3) CStack.addElement(AStack.deleteElement());
                if (k == 1 && m == 2) BStack.addElement(AStack.deleteElement());
                if (k == 2 && m == 3) CStack.addElement(BStack.deleteElement());
                if (k == 2 && m == 1) AStack.addElement(BStack.deleteElement());
                if (k == 3 && m == 1) AStack.addElement(CStack.deleteElement());
                if (k == 3 && m == 2) BStack.addElement(CStack.deleteElement());
            }
            piramidki(AStack, BStack, CStack, n - 1, tmp, m);

        }
        return CStack;
    }

}
/*try(FileWriter writer = new FileWriter("notes.txt", false))
        {
            // запись всей строки
            String text = "Hello Gold!";
            writer.write(text);

            writer.flush();
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }

        try(FileReader reader = new FileReader("notes.txt"))
        {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){

                System.out.print((char)c);
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }*/
