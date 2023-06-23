public class DLL {
    Node2P head;

    public DLL() {
        head = null;
    }

    // soal 1
    int[] toArray() {
        int[] array = new int[size()];
        Node2P sementara = head;
        int indeks = 0;
        while (sementara != null) {
            array[indeks++] = sementara.data;
            sementara = sementara.next;
        }
        return array;
    }

    // soal 2
    DLL sublist(int start, int end) {
        DLL sublist = new DLL();
        if (start < 0 || end >= size() || start > end) {
            System.out.println("Rentang subList tidak sesuai!");
            return sublist;
        }

        Node2P sementara = head;
        int indeks = 0;
        while (indeks <= end) {
            if (indeks >= start) {
                sublist.addLast(sementara.data);
            }
            sementara = sementara.next;
            indeks++;
        }

        return sublist;
    }

    // soal 3
    void addAll(DLL list) {
        Node2P sementara = list.head;
        while (sementara != null) {
            addLast(sementara.data);
            sementara = sementara.next;
        }
    }

    // soal 4
    boolean containsAll(DLL list) {
        Node2P sementara = list.head;
        while (sementara != null) {
            if (!contains(sementara.data)) {
                return false;
            }
            sementara = sementara.next;
        }
        return true;
    }

    // soal 5
    void removeAll(DLL list) {
        Node2P sementara = list.head;
        while (sementara != null) {
            if (list.contains(sementara.data)) {
                deleteByData(sementara.data);
            }
            sementara = sementara.next;
        }
    }

    boolean contains(int data) {
        Node2P sementara = head;
        while (sementara != null) {
            if (sementara.data == data) {
                return true;
            }
            sementara = sementara.next;
        }
        return false;
    }

    int get(int idx) {
        if (idx < 0 || idx >= size()) {
            System.out.println("Idx invalid!");
            return -1;
        } else {
            Node2P sementara = head;
            for (int i = 0; i < idx; i++) {
                sementara = sementara.next;
            }
            return sementara.data;
        }
    }

    void deleteByData(int data) {
        Node2P sementara = head;
        while (sementara != null) {
            if (sementara.data == data) {
                if (sementara.prev == null) {
                    deleteFirst();
                } else if (sementara.next == null) {
                    deleteLast();
                } else {
                    sementara.prev.next = sementara.next;
                    sementara.next.prev = sementara.prev;
                }
            }
            sementara = sementara.next;
        }
    }

    boolean isEmpty() {
        return head == null ? true : false;
    }

    int size() {
        int n = 0;
        Node2P sementara = head;
        while (sementara != null) {
            n++;
            sementara = sementara.next;
        }
        return n;
    }

    void addLast(int in) {
        Node2P newNode = new Node2P(in);
        if (isEmpty()) {
            head = newNode;
        } else {
            Node2P sementara = head;
            while (sementara.next != null) {
                sementara = sementara.next;
            }
            sementara.next = newNode;
            newNode.prev = sementara;
        }
    }

    void deleteFirst() {
        if (isEmpty()) {
            System.out.println("Data kosong! operasi deleteFirst gagal!");
        } else if (size() == 1) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
    }

    void deleteLast() {
        if (isEmpty()) {
            System.out.println("Data kosong! Operasi deleteLast gagal!");
        } else if (size() == 1) {
            head = null;
        } else {
            Node2P sementara = head;
            while (sementara.next != null) {
                sementara = sementara.next;
            }
            sementara.prev.next = null;
            sementara.prev = null;
            sementara = null;
        }
    }

    void print() {
        if (isEmpty()) {
            System.out.println("Data kosong! Operasi print gagal");
        } else {
            Node2P sementara = head;
            while (sementara != null) {
                System.out.print("" + sementara.data);
                if (sementara.next != null)
                    System.out.print("-");
                sementara = sementara.next;
            }
            System.out.println("");
        }
    }
}
