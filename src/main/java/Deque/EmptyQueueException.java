package Deque;

public class EmptyQueueException extends Throwable {
    public EmptyQueueException()
    {
        this(null);
    } // end default constructor

    public EmptyQueueException(String message)
    {
        super();
    } // end constructor
}
