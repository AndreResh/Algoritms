package alg;

import java.util.*;

public class Stepic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<BackPack> list = new ArrayList<>();
        String[] main = scanner.nextLine().split(" ");

        String[] s;
        for (int i = 0; i < Integer.parseInt(main[0]); i++) {
            s = scanner.nextLine().split(" ");
            list.add(new BackPack(Double.parseDouble(s[0]), Double.parseDouble(s[1])));
        }
        list.sort(new Comparator<BackPack>() {
            @Override
            public int compare(BackPack o1, BackPack o2) {
                return (int) (o2.getCost() - o1.getCost());
            }
        });
        System.out.println(list);
        double currentCost = 0;
        int size = Integer.parseInt(main[1]);
        int i = 0;
        while (i<list.size()-1) {
            BackPack backPack = list.get(i);
            size -= backPack.getSize();
            if (size == 0) {
                currentCost += backPack.getCost();
                break;
            } else if (size < 0) {
                size += backPack.getSize();
            } else {
                currentCost += backPack.getCost();
                i++;
            }
        }
        System.out.println(String.format("%.3f", currentCost));
    }
}

class BackPack {
    private final double cost;
    private final double size;

    public BackPack(double cost, double size) {
        this.cost = cost;
        this.size = size;
    }

    public double getCost() {
        return cost;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "BackPack{" +
                "cost=" + cost +
                ", size=" + size +
                '}';
    }
}
