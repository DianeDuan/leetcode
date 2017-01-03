package provided.vo;

public class DoublyLinkedListNode {
    public DoublyLinkedListNode previous;
    public DoublyLinkedListNode next;
    public int key;
    public int value;

    public DoublyLinkedListNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
