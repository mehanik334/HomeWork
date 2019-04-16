package denisenko.hw9;

import java.util.Objects;

public class MailMessage extends Message<String> {

    private String coding;

    public MailMessage(String from, String to, String context) {
        super(from, to, context);
    }

    public MailMessage(String from, String to, String context, String coding) {
        super(from, to, context);
        this.coding = coding;
    }

    public String getCoding() {
        return coding;
    }

    public void setCoding(String coding) {
        this.coding = coding;
    }
}
