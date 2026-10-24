class TextEditor {
    
    class Node {
        char val;
        Node next;
        Node prev;

        public Node(char val) {
            this.val = val;
        }

        public Node(char val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head, tail, cursor;

    public TextEditor() {
        head = new Node('\0');
        tail = new Node('\0');

        head.next = tail;
        tail.prev = head;

        cursor = head;    
    }
    
    public void addText(String text) {
        Node curr = cursor;

        char[] textArray = text.toCharArray();
        int n = textArray.length;

        while(n-- > 0) {
            Node newNode = new Node(textArray[textArray.length - n - 1]);
            newNode.next= cursor.next;
            cursor.next = newNode;
            newNode.prev = cursor;

            newNode.next.prev = newNode;
            cursor = cursor.next;
        }
        return;
    }
    
    public int deleteText(int k) {
        int count = 0;

        while (k-- > 0 && cursor != head) {
            cursor = cursor.prev;

            cursor.next = cursor.next.next;
            cursor.next.prev = cursor;
            count++;
        }
        return count;
    }
    
    public String cursorLeft(int k) {
        while (k-- > 0 && cursor != head) {
            cursor = cursor.prev;
        }
        return getText();
    }
    
    public String cursorRight(int k) {
        while (k-- > 0 && cursor.next != tail) {
            cursor = cursor.next;
        }
        return getText();
    }

    private String getText() {
        StringBuilder sb = new StringBuilder();

        Node temp = cursor;
        int count = 0;

        while (temp != head && count < 10) {
            System.out.println(temp.val);
            sb.append(temp.val);
            temp = temp.prev;
            count++;
        }

        return sb.reverse().toString();
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */