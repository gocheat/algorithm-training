package com.gocheat.list;


public class LinkedList {

    Node header;
    LinkedList() {
        header = new Node();
    }

    static class Node {
        int data;
        Node next;

        Node() {
            this.data = -1;
        }
        Node(int data) {
            this.data = data;
        }
    }

    void append(int data) {
        Node end = new Node(data);
        Node n = header;
        while (n.next != null) {
            n = n.next;
        }
        n.next = end;
    }

    void delete(int data) {
        Node n = header;
        while (n.next != null) {
            if (n.next.data == data) {
                n.next = n.next.next;
            } else {
                n = n.next;
            }
        }
    }

    void retrievel() {
        Node n = header.next;
        while (n.next != null) {
            System.out.print(n.data + " -> ");
            n = n.next;
        }
        System.out.println(n.data + " -> end");
    }

    // 링크드 리스트 중복 제거
    void removeDups() {
        Node n = header;
        while (n.next != null) {
            Node r = n ;
            while (r.next != null) {
                if (n.data == r.next.data) {
                    r.next = r.next.next;
                }else{
                    r = r.next;
                }
            }
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.append(1);
        list.append(2);
        list.append(3);
        list.append(4);
        list.append(3);
        list.append(4);
        list.append(5);
        list.append(1);
        list.retrievel();
        list.removeDups();
        list.retrievel();
    }
}

