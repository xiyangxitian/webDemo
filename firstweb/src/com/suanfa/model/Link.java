package com.suanfa.model;

/**
 * 链表
 *
 * @param <T>
 */
public class Link<T> {

    public Entry head;//头节点

    public Link(T t) { // 初始化链表时创建一个头节点
        head = new Entry(t);
    }

    class Entry { // 节点类
        T data;//数据域
        Entry next;//地址域

        public Entry(T value) {
            data = value;
            next = null;
        }

    }

    /**
     *
     * @return
     */
    public Entry reserver(){
        Entry newhead = null;//逆置后的新头结点
        Entry prev = head;//前驱结点
        Entry entry = prev.next;
        prev.next = null;
        while(entry.next != null){
            Entry entry1 = entry.next;
            entry.next = prev;
            prev = entry;
            entry = entry1;
        }
        entry.next = prev;
        //这时entry就是原来链表的最后一个结点，也就是新链表的头结点
        newhead = entry;
        return newhead;
    }

    /**
     *  单链表的逆序
     * @return
     */
    public Entry reserver1(Entry head){
        Entry newHead;
        if(head.next==null){
            return head;
        }
        newHead = reserver1(head.next);
        head.next.next = head;
        head.next = null;
        System.out.println(newHead.data);
        return newHead;
    }



    /**
     * 头插法
     *
     * @param val
     */
    public void insertHead(T val) {
        //有这么一个节点
        Entry cur = new Entry(val);
        /*
         * 第一种
         */
        cur.next = head.next;
        head.next = cur;
    }

    /**
     * 尾插法
     *
     * @param val
     */
    public void insertTail(T val) {
        Entry tmp;
        Entry cur = new Entry(val);
        tmp = head;
        /*
         * 遍历链表到最后一个结点
         */
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp.next = cur;
        cur.next = null;
    }

    /**
     * 将数据插入到指定位置
     *
     * @param pos
     * @param val
     * @return
     */
    public boolean insertPos(int pos, T val) {
        if (pos < 0 || pos > getLength()) {
            return false;
        } else {
            Entry cur = head;
            //找到插入的地方
            for (int i = 0; i <= pos - 1; i++) {
                cur = cur.next;
            }
            Entry entry = new Entry(val);
            //进行插入
            entry.next = cur.next;
            cur.next = entry;
            return true;
        }
    }

    /**
     * 得到单链表的长度
     */
    public int getLength() {
        int len = 0;//长度标志量
        Entry tmp;
        tmp = head.next;
        while (tmp != null) {//遍历整个链表得到链表长度
            len++;
            tmp = tmp.next;
        }
        return len;
    }

    /**
     * 打印链表数据
     */
    public void show() {
        Entry tmp;
        tmp = head;
        //遍历打印链表
        while (tmp.next != null) {
            System.out.println("data :" + tmp.next.data);
            tmp = tmp.next;
        }
    }

    /**
     * 求倒数第k个节点
     *
     * @param len
     * @param k
     */
    public void lastK(int len, int k) {
        Entry tmp;
        tmp = head;
        if (k < 0 || k > len) {
            System.out.println("超出链表长度");
        } else {
            for (int i = 0; i <= len - k; i++) {   //len就是链表长度，len-k也就是倒数第k个节点
                tmp = tmp.next;
            }
        }
        System.out.println(tmp.data);
    }

    /**
     * 求倒数第k个节点
     *
     * @param k
     * @return
     */
    public T newLast(int k) {
        if (k < 0 || k > getLength()) {
            return null;
        }
        Entry cur1, cur2;
        cur1 = head;
        cur2 = head;
        while (k - 1 > 0) {
            if (cur2.next != null) {
                cur2 = cur2.next;
                k--;
            } else {
                return null;
            }
        }
        while (cur2.next != null) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1.data;
    }


}
