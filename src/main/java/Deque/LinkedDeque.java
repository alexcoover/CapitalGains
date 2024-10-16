package Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements DequeInterface<T> {
    private Node firstNode; // References node at front of queue
    private Node lastNode;  // References node at back of queue

    public LinkedDeque()
    {
        firstNode = null;
        lastNode = null;
    } // end default constructor

    public void addToFront(T newEntry){
        Node newNode = new Node(newEntry, null);

        if (isEmpty())
            firstNode = newNode;
        else {
            newNode.setNextNode(firstNode);
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;

    }
    public void addToBack(T newEntry){
        Node newNode = new Node(newEntry);

        if (isEmpty())
            firstNode = newNode;
        else {
            lastNode.setNextNode(newNode);
            newNode.setPreviousNode(lastNode);
        }
        lastNode = newNode;

    }

    public T removeFront() throws EmptyQueueException {
        T front = getFront();  // Might throw EmptyQueueException
        // Assertion: firstNode != null
        firstNode.setData(null);
        firstNode = firstNode.getNextNode();

        if (firstNode == null)
            lastNode = null;

        return front;
    } // end removeFront


    public T removeBack() throws EmptyQueueException {
        T back = getBack();  // Might throw EmptyQueueException
        lastNode.setData(null);
        lastNode = lastNode.getPreviousNode();

        if (firstNode == null)
            lastNode = null;

        return back;
    } // end removeBack

    public boolean isEmpty(){
        return (firstNode == null) && (lastNode == null);
    }

    public T getFront() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return firstNode.getData();
    }
    public T getBack() throws EmptyQueueException {
        if (isEmpty())
            throw new EmptyQueueException();
        else
            return lastNode.getData();
    }
    public void clear(){
        firstNode = null;
        lastNode = null;
    }
    public Iterator<T> iterator(){
        return new IteratorForLinkedList();
    } // end iterator
    public Iterator<T> getIterator(){
        return iterator();
    }


    private class IteratorForLinkedList implements Iterator<T>
    {
        private Node nextNode;

        private IteratorForLinkedList()
        {
            nextNode = firstNode;
        } // end default constructor

        public T next()
        {
            T result;
            if (hasNext())
            {
                result = nextNode.getData();
                nextNode = nextNode.getNextNode(); // Advance iterator
            }
            else
                throw new NoSuchElementException("Illegal call to next(); " +
                        "iterator is after end of list.");
            return result; // Return next entry in iteration
        } // end next

        public boolean hasNext()
        {
            return nextNode != null;
        } // end hasNext

        public void remove()
        {
            throw new UnsupportedOperationException("remove() is not supported " +
                    "by this iterator");
        } // end remove
    } // end IteratorForLinkedList


    private class Node
    {
        private T    data; // Entry in queue
        private Node next; // Link to next node
        private Node previous; // Link to previous node

        private Node(T dataPortion)
        {
            data = dataPortion;
            next = null;
            previous = null;
        } // end constructor

        private Node(T dataPortion, Node linkPortion)
        {
            data = dataPortion;
            next = linkPortion;
        } // end constructor

        private T getData()
        {
            return data;
        } // end getData

        private void setData(T newData)
        {
            data = newData;
        } // end setData

        private Node getNextNode()
        {
            return next;
        } // end getNextNode

        private void setNextNode(Node nextNode)
        {
            next = nextNode;
        } // end setNextNode

        private Node getPreviousNode()
        {
            return previous;
        } // end getNextNode

        private void setPreviousNode(Node previousNode)
        {
            previous = previousNode;
        } // end setNextNode
    } // end Node
}


