package denisenko.hw9;

import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<View<T>> {

    private HashMap<String, List<T>> mailBox = new HashMap<>();

    public MailService() {
    }

    public MailService(HashMap<String, List<T>> mailBox) {
        this.mailBox = mailBox;
    }

    public HashMap<String, List<T>> getMailBox() {
        return mailBox;
    }

    @Override
    public void accept(View<T> tView) {

        List<T> list = mailBox.get(tView.getTo());
        list.add(tView.getContext());
        mailBox.put(tView.getTo(), list);
    }
}
