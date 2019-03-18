package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Valentyn.Moliakov
 */
public class _929UniqueEmailAddress {

    public int numUniqueEmails(String[] emails) {
        Set<String> validMails = new HashSet<>();
        for (String email : emails) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while(email.charAt(i) != '@') {
                if (email.charAt(i) == '.') {
                    i++;
                } else if (email.charAt(i) == '+') {
                    i = email.indexOf('@');
                    break;
                } else {
                    sb.append(email.charAt(i++));
                }
            }
            sb.append(email.substring(i));
            validMails.add(sb.toString());
        }
        return validMails.size();
    }
}
