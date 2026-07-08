package LinkedList;

public class SinglyLinkedList {
    Node head;

    public void insert(int element){
        Node node = new Node();
        node.data = element;
        node.next= null;
        if(head == null){
            head = node;
        } else {
            Node n = head;
            while(n.next != null){
                n=n.next;
            }
            n.next = node;
        }
    }

    public void insertAtStart(int element){
        Node newNode = new Node();
        newNode.data = element;
        newNode.next = head;
        head = newNode;
    }
    public void insertAt(int index, int element){
        Node newNode = new Node();
        newNode.data = element;
        if(index == 0){
            insertAtStart(element);
        }
        else {
            Node temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public void show(){
        Node n = head;
        while(n.next!=null){
            System.out.println(n.data);
            n = n.next;

        }
        System.out.println(n.data);
    }
}
