package denisenko.hw9;

import java.util.*;


public class Mail {


    public static void main(String[] args) {

        // Random variables
        String randomFrom = "Sasha";
        String randomTo = "Dima";
        int randomSalary = 100;

        // Creating a list of three email messages.
        MailMessage firstMessage = new MailMessage(
                "Robert Howard",
                "H.P. Lovecraft",
                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"
        );


        assert firstMessage.getFrom().equals("Robert Howard") : "Wrong firstMessage from address";
        assert firstMessage.getTo().equals("H.P. Lovecraft") : "Wrong firstMessage to address";
        assert firstMessage.getContext().endsWith("Howard!") : "Wrong firstMessage content ending";

        MailMessage secondMessage = new MailMessage(
                "Jonathan Nolan",
                "Christopher Nolan",
                "Brother, why everyone praises you so much only when I wrote almost all the scripts. It's not fair!"
        );

        MailMessage thirdMessage = new MailMessage(
                "Stephen Hawking",
                "Christopher Nolan",
                "I did not understand Interstellar."
        );

        List<MailMessage> messages = Arrays.asList(
                firstMessage, secondMessage, thirdMessage
        );

        // Creating a mail service.
        MailService<String> mailService = new MailService<>();

        // Processing the list of letters by mail service
        messages.stream().forEachOrdered(mailService);

        // Receiving and checking the mailbox dictionary,
        // where the recipient can get a list of messages that were sent to him
        Map<String, List<String>> mailBox = mailService.getMailBox();

        assert mailBox.get("H.P. Lovecraft").equals(

                "This \"The Shadow over Innsmouth\" story is real masterpiece, Howard!"

        ) : "wrong mailService mailbox content (1)";

        assert mailBox.get("Christopher Nolan").equals(
                Arrays.asList(
                        "Brother, why everyone praises you so much only when I wrote almost all the scripts. It's not fair!",
                        "I did not understand Interstellar."
                )
        ) : "wrong mailService mailbox content (2)";

        assert mailBox.get(randomTo).equals(Collections.<String>emptyList()) : "wrong mailService mailbox content (3)";


        // Create a list of three salaries.
        Salary salary1 = new Salary("Facebook", "Mark Zuckerberg", 1);
        Salary salary2 = new Salary("FC Barcelona", "Lionel Messi", Integer.MAX_VALUE);
        Salary salary3 = new Salary(randomFrom, randomTo, randomSalary);

        // Creating a mail service that processes salaries.
        MailService<Integer> salaryService = new MailService<>();

        //Processing a list of salaries by the postal service
        Arrays.asList(salary1, salary2, salary3).forEach(salaryService);

        // Receiving and checking the mailbox dictionary,
        // where the recipient can get a list of salaries that were sent to him.
        Map<String, List<Integer>> salaries = salaryService.getMailBox();
        assert salaries.get(salary1.getTo()).equals(Arrays.asList(1)) : "wrong salaries mailbox content (1)";
        assert salaries.get(salary2.getTo()).equals(Arrays.asList(Integer.MAX_VALUE)) : "wrong salaries mailbox content (2)";
        assert salaries.get(randomTo).equals(Arrays.asList(randomSalary)) : "wrong salaries mailbox content (3)";

    }
}
