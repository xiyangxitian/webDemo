package com.suanfa.model;

/**
 * 单链表
 */
public class Node<K, V> {
    private final K key;
    private V value;
    private Node<K, V> next;

    public Node(K key, V value, Node<K, V> next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Node<K, V> getNext() {
        return next;
    }

    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    /**
     * 逆序单链表（递归）
     *
     * @param head 单链表
     */
    public static Node<Integer, Integer> reverse2(Node<Integer, Integer> head) {
        //当为空或者本节点为末尾节点的时候
        if (head == null || head.getNext() == null) {
            return head;
        }
        Node<Integer, Integer> reversedHead = reverse2(head.getNext());
        //获取先前的下一个节点，让该节点指向自身
        head.getNext().setNext(head);
        //破坏以前自己指向下一个节点
        head.setNext(null);
        //层层传递给最上面的
        return reversedHead;
    }

}
