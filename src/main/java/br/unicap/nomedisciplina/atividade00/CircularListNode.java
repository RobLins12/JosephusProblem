package br.unicap.nomedisciplina.atividade00;

public class CircularListNode {
    CircularListNode previous;
    CircularListNode next;
    Integer value;

    public CircularListNode(Integer value, CircularListNode next, CircularListNode previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public void setPrevious(CircularListNode previous) {
        this.previous = previous;
    }

    public void setNext(CircularListNode next) {
        this.next = next;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public CircularListNode getPrevious() {
        return previous;
    }

    public CircularListNode getNext() {
        return next;
    }
}
