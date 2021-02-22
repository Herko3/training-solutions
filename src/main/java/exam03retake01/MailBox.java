package exam03retake01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MailBox {

    private List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return mails;
    }

    public List<Mail> findByCriteria(String criteria) {
        List<Mail> result = new ArrayList<>();

        if (criteria.startsWith("from:")) {
            return mails.stream()
                    .filter(mail -> mail.fromFilter(criteria.substring(5)))
                    .collect(Collectors.toList());
//            return criteriaWithFrom(criteria.substring(5));
        }

        if (criteria.startsWith("to:")) {
            return criteriaWithTo(criteria.substring(3));
        }

        return mails.stream()
                .filter(m -> m.messageOrSubjectFilter(criteria))
                .collect(Collectors.toList());

//        for (Mail mail : mails) {
//            if (mail.getSubject().contains(criteria) || mail.getMessage().contains(criteria)) {
//                result.add(mail);
//            }
//        }
//        return result;
    }

    private List<Mail> criteriaWithFrom(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getFrom().getName().equals(criteria) || mail.getFrom().getEmail().equals(criteria)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> criteriaWithTo(String criteria) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            for (Contact contact : mail.getTo()) {
                if (contact.getName().equals(criteria) || contact.getEmail().equals(criteria)) {
                    result.add(mail);
                }
            }
        }
        return result;
    }
}
