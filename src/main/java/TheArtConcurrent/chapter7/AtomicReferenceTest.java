package TheArtConcurrent.chapter7;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {
    public static AtomicReference<User> au = new AtomicReference<>();

    public static void main(String[] args) {
        User user = new User("yang",18);
        au.set(user);
        User user1 = new User("yangshenghua",22);
        au.compareAndSet(user,user1);
        System.out.println(au.get().getName());
        System.out.println(au.get().getOld());
    }
    static class User {
        private String name;
        private int old;

        public User(String name, int old) {
            this.name = name;
            this.old = old;
        }
        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }
}
