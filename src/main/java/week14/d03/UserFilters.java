package week14.d03;

import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class UserFilters {


    public UserFilter createFilter(List<Predicate<User>> predicates) {
        return users -> {
            Iterator<User> iterator = users.iterator();
            while (iterator.hasNext()) {
                User user = iterator.next();
                boolean shouldRemove = false;
                for (Predicate<User> predicate : predicates) {
                    if(!predicate.test(user)){
                        shouldRemove = true;
                    }
                }
                if(shouldRemove){
                    iterator.remove();
                }
            }
            return users;
        };
    }
}
