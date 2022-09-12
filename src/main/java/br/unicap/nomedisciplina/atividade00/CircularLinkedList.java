package br.unicap.nomedisciplina.atividade00;

public class CircularLinkedList {
    private CircularListNode sentinel;

    public CircularLinkedList(){
        this.sentinel = new CircularListNode(null, null, null);
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
    }

    public CircularListNode getSent() {
        return this.sentinel;
    }

    public CircularListNode getHead() {
        return this.sentinel.getNext();
    }

    public CircularListNode getTail() {
        return this.sentinel.getPrevious();
    }

    public CircularListNode getSuccessor(CircularListNode currentNode) throws Exception {
        CircularListNode testNode = getHead();

        if(isEmpty()){
            throw new RuntimeException();
        }
        while(testNode != currentNode && testNode != sentinel){
            testNode = testNode.getNext();
        }
        if(testNode.getNext() == sentinel){
            return getHead();
        }
        return testNode.getNext();
    }

    public void addFirst(Integer value) {
        CircularListNode newHead = new CircularListNode(value, getHead(), this.sentinel);
        CircularListNode currentHead = getHead();

        if(isEmpty()){
            this.sentinel.setNext(newHead);
            sentinel.setPrevious(newHead);
        }else{
            currentHead.setPrevious(newHead);
            sentinel.setNext(newHead);
        }
    }
    
    public void addLast(Integer value) {
        CircularListNode newTail = new CircularListNode(value, sentinel, getTail());
        CircularListNode currentTail = getTail();
        
        if(isEmpty()){
            addFirst(value);
        }else{
            currentTail.setNext(newTail);
            sentinel.setPrevious(newTail);
        }

    }

    public boolean isEmpty() {
        return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
    }

    public int size() {
        int size=0;
        CircularListNode sizeTest = getHead();

        while(sizeTest!= sentinel){
            size++;
            sizeTest = sizeTest.getNext();
        }
        
        
        return size;
    }


    public void reverse() {
        CircularListNode tempNode = getHead();
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
        
        while(tempNode != sentinel){
            addFirst(tempNode.getValue());
            tempNode = tempNode.getNext();
        }
    }

    public boolean isOrdered(boolean ascending) {
        CircularListNode orderedTest = getHead();
        Integer previousValue;

        
        while(orderedTest.getNext() != sentinel){
            previousValue = orderedTest.getValue();
            orderedTest = orderedTest.getNext();
            
            if(previousValue > orderedTest.getValue() & ascending ){
                return false;
            }
            if(previousValue < orderedTest.getValue() & !ascending ){
                return false;
            }
            
        }
        
        return true;
    }

    public CircularListNode search(Integer value) {
        CircularListNode searchNode = getHead();

        while(searchNode != sentinel){
            if(searchNode.getValue() == value){
                return searchNode;
            }
            searchNode = searchNode.getNext();
        }
        
        return null;
    }

    public void delete(CircularListNode nodeDelete) {
        CircularListNode nextNode = nodeDelete.getNext();
        CircularListNode previous = nodeDelete.getPrevious();
        nextNode.setPrevious(previous);
        previous.setNext(nextNode);
    }

    public boolean isEquals(CircularLinkedList secondList) {
        CircularListNode secondHead = secondList.getHead();
        CircularListNode originalHead = getHead();

        while(originalHead != sentinel){
            if(originalHead.getValue() != secondHead.getValue()){
                return false;
            }

            originalHead = originalHead.getNext();
            secondHead = secondHead.getNext();
        }

        return true;
    }

    public CircularLinkedList copy() {
        CircularLinkedList newList = new CircularLinkedList();
        CircularListNode controller = getHead();

        while(controller !=sentinel){
            newList.addLast(controller.getValue());
            controller = controller.getNext();
        }
        
        return newList;
    }

    public int get(int index, CircularListNode node) throws Exception {
        CircularListNode testNode = node;
        int position = 0;
        
        if(isEmpty()){
            throw new RuntimeException();
        }
        while(position != index){
            if(testNode.getNext() == sentinel){
                testNode = testNode.getNext();
            }
            testNode = testNode.getNext();
            
            position++;
        }
        return testNode.getValue();
    }
}
