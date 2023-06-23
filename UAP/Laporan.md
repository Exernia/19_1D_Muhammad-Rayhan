<strong>Laporan UAP Algortima dan Struktur Data</strong><br><br>
<strong>Nama: Muhammad Rayhan</strong><br>
<strong>Kelas: 1D</strong><br>
<strong>NIM: 2241720213</strong><br>
<strong>No. Presensi: 19</strong><br><br>

<strong>Kelas DLL</strong>
```
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
```

<br><strong>Kelas Node2P</strong>
```
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Imam
 */
public class Node2P {
    int data;
    Node2P next;
    Node2P prev;

    public Node2P(int data) {
        this.data = data;
        next = prev = null;
    }
    
}
```

<br><strong>Kelas DLLMain</strong>
```
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Imam`
 */
public class DLLMain {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.addLast(10);
        dll.addLast(100);
        dll.addLast(34);
        dll.addLast(20);
        dll.addLast(200);
        dll.addLast(75);
        System.out.println("Tampilan data awal DLL:");
        dll.print();

        // cek fungsi toArray()
        int[] arr = dll.toArray();
        System.out.println("Tampilan data array hasil dari fungsi toArray():");
        for (int x : arr) {
            System.out.print(x + ", ");
        }

        // cek fungsi sublist()
        DLL subList = dll.sublist(1, 3);
        System.out.println("\nTampilan data dari list hasil dari fungsi sublist(1, 3):");
        subList.print();

        // cek fungsi addAll()
        DLL dll2 = new DLL();
        dll2.addLast(212);
        dll2.addLast(212);
        dll2.addLast(212);
        dll.addAll(dll2);
        System.out.println("Tampilan data dari list hasil dari fungsi addAll():");
        dll.print();

        // cek fungsi containAll
        DLL dll3 = new DLL();
        dll3.addLast(100);
        dll3.addLast(34);
        dll3.addLast(212);
        System.out.println("Tampilan data dari fungsi constainsAll():");
        System.out.println("" + dll.containsAll(dll3));

        // cek fungsi removeAll()
        dll.removeAll(dll3);
        System.out.println("Tampilan data dari fungsi removeAll():");
        dll.print();
    }
}
```

<br><strong>Hasil Percobaan</strong>
<img src="Hasil%20Percobaan.png">