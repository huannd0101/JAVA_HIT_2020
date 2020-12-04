package BTL;

import java.util.Comparator;

public class SortAccountsByUserName implements Comparator<Account>{
    @Override
    public int compare(Account o1, Account o2) {
        return o1.getUserName().compareTo(o2.getUserName());
    }
}
