package com.company;

public class Main {

    public static class Node{
        char data;
        Node next;
        public Node(char data){
            this.data = data;
            this.next = null;
        }
    }

    public static Node addNode(Node head, char c){
        Node newNode = new Node(c);
        if (head == null){
            return newNode;
        }
        Node current = head;
        while (current.next != null){
            current= current.next;
        }
        current.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node head = addNode(null,'g');
        head = addNode(head,'e');
        head = addNode(head,'e');
        head = addNode(head,'k');
        head = addNode(head,'e');
        head = addNode(head,'e');
        head = addNode(head,'g');
        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(Node head){
        if ((head == null)||(head.next==null)){
            return true;
        }

        //Find Mid
        Node slow = head;
        Node fast = head;
        while ((fast.next!=null)&&(fast.next.next!=null)){
            fast = fast.next.next;
            slow = slow.next;
        }


        //Disconnect from mid (works for both odd and even)
        Node secondHead = slow.next;
        slow.next = null;

        //Reverse the list
        Node list2 = reverseList(secondHead);
        Node list1 = head;

        //compare both list
        while (list2!=null){
            if (list1.data!=list2.data){
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }

        return true;
    }

    public static Node reverseList(Node head){
        Node current = head;
        Node result = null;
        Node next;
        while (current!=null){
            next = current.next;
            current.next = result;
            result = current;
            current = next;
        }
        return result;
    }











}
