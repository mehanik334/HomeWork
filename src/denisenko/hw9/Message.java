package denisenko.hw9;

public class Message<T> {

    private String from;
    private String to;
    private T context;

    public Message(String from, String to, T context) {
        this.from = from;
        this.to = to;
        this.context = context;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public T getContext() {
        return context;
    }
}
