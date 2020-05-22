package ru.list.surkovr.linkedLists.singleLinkedListImpl;


public class Node {
    Node next = null;
    int data;

    public Node(int d) {
        data = d;
    }

    public void appendToTail(int d) {
        Node end = new Node(d);
        Node n = this;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    public Node deleteNode(Node head, int d) {
        Node n = head;
        if (n.data == d) {
            return head.next;   /* moved head */
        }
        while (n.next != null) {
            if (n.next.data == d) {
                n.next = n.next.next;
                return head;    /* head didn’t change */
            }
            n = n.next;
        }
        return null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Nodes: {");
        sb.append(data).append(", ");
        if (next == null) return sb.append("}").toString();
        Node n = next;
        while (n != null) {
            if (n.getNext() == null) {
                sb.append(n.data).append("}");
                break;
            }
            sb.append(n.data).append(", ");
            n = n.getNext();
        }
        return sb.toString();
    }
}
