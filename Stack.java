public class Stack {
    
    private static int top;
    private static int capacity;
    private static Customer[] stack;

    Stack(int size) {
        top = -1;
        capacity = size;
        stack = new Customer[capacity];
    }
    // push an element into stack
    static void stackpush (Customer item){
        // check if the stack is full
        if (top == capacity -1){
            System.out.printf("\n Stack is full\n");
            return;
        }
        // Insert element at the Top
        stack [++top] = item;
    }

    // Pop an element from the stack
    static Customer stackPop(){
        // check if stack is empty
        if (top == -1){
            System.out.printf("\n Stack is empty\n");
            return null;
        }
        // remove element 
        return stack[top--];

    }

    // print stack element
    static void stackDisplay(){
        if (top == -1){
            System.out.printf("Stack is Empty\n");
            return;
        }
        // Traverse top to bottom and print 
    for (int i = top; i >=0; i--){
        System.out.printf("%,", stack[i].toString());
    }
    System.out.println();  
    }

    // print top of stack 
    static void stackTop(){
        if (top == -1 ){
            System.out.printf("\n Top Element of the Stack : %\n", stack[top].toString());
        }
    }

}
