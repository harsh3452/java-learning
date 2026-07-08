package LinkedList;

public class Runner {
    public static void main(String[] args){
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(12);
        list.insert(33);
        list.insert(34);
        list.insertAt(1,99);
        list.show();
    }
}
