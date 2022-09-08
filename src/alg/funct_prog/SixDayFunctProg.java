package alg.funct_prog;

import java.util.Comparator;
import java.util.Objects;

public class SixDayFunctProg {
//    laptops.sort(Comparator
//            .comparing(Laptop::getNumberOfCores, Comparator.reverseOrder())
//            .thenComparingDouble(Laptop::getDisplaySize));
}
//class Account {
//    private final String owner;
//    private final long balance;
//    private final boolean locked;
//
//    Account(String owner, long balance, boolean locked) {
//        this.owner = owner;
//        this.balance = balance;
//        this.locked = locked;
//    }
//
//    public static Comparator<Account> getComparatorByLockedBalanceAndOwner() {
//        return Comparator.comparing(Account::isLocked)
//                .thenComparing(Account::getBalance, Comparator.reverseOrder()).thenComparing(Account::getOwner);
//
//    }
//
//    public String getOwner() {
//        return owner;
//    }
//
//    public long getBalance() {
//        return balance;
//    }
//
//    public boolean isLocked() {
//        return locked;
//    }
//
//    @Override
//    public String toString() {
//        return owner + " " + balance + " " + locked;
//    }
//}
class LongRange {
    private final long left;
    private final long right;

    public static Comparator<LongRange> getComparator() {
        // write your code here
//        return Comparator.comparing(LongRange::difference).thenComparing(LongRange::getLeft);
        return Comparator
                .comparing((LongRange range) -> Math.abs(range.right - range.left))
                .thenComparingLong(LongRange::getLeft);
    }

    public LongRange(long left, long right) {
        this.left = left;
        this.right = right;
    }
    public int difference(){
        return (int) Math.abs(this.left-this.right);
    }

    public long getLeft() {
        return left;
    }

    public long getRight() {
        return right;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        LongRange longRange = (LongRange) other;
        return left == longRange.left &&
                right == longRange.right;
    }

    @Override
    public int hashCode() {
        return Objects.hash(left, right);
    }

    @Override
    public String toString() {
        return String.format("%d %d", left, right);

    }
}