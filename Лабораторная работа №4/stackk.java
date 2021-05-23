
public class stackk {

    public String[] Stack;
    public int top;

    public stackk() {
        Stack = new String[550];
        top = -1;
    }

    public void addElement(String element) {
        Stack[++top] = element;
    }

    public boolean isEmpty() {
        if (top==-1) return true;
        else return false;
    }

    public String deleteElement() {
        String last = Stack[top];
        Stack[top--] = null;
        return last;
    }

    public String readLast() {
        String last = Stack[top];
        return last;
    }

}
