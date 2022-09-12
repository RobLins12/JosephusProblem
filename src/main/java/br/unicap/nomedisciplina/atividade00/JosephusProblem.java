package br.unicap.nomedisciplina.atividade00;

public class JosephusProblem {

    public static Integer[] solve(int m, int n) {
        Integer listReturned [] = new Integer [n];
        CircularLinkedList list = new CircularLinkedList();
        for(int i = 0; i < n; i++){
            list.addLast(i);
        }
        CircularListNode currentNode = list.getHead();
        try {
            for (int index = 0; index < n; index++) {
                listReturned[index] = list.get(m-1, currentNode);
                for (int i = 0; i < m; i++) {
                    currentNode = list.getSuccessor(currentNode);
                }
                if (currentNode.getPrevious() == list.getSent()) {
                    list.delete(list.getTail());
                }else{
                    list.delete(currentNode.getPrevious());
                }
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listReturned;
    }
}
