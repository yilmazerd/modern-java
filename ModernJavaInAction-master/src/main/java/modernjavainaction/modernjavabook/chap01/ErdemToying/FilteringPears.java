package modernjavainaction.modernjavabook.chap01.ErdemToying;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilteringPears {

    public static void main(String[] args) {

        Pear p1 = new Pear.Builder().withSize(10).withWeight(10).build();
        System.out.println(p1);
        List<Pear> pearList = getPearList();

    }

    public static List<Pear> getPearList() {
        List<Pear> pearList = new ArrayList<Pear>();
        pearList.add(new Pear(10,100));
        pearList.add(new Pear(15,120));
        return pearList;
    }

    public static boolean isHeavyPear(Pear pear) {
        return pear.getWeight() > 150;
    }

    public static boolean isSmallPear(Pear pear) {
        return pear.getSize() < 50;
    }

    public static List<Pear> filterPearsMultiple(List<Pear> pears, List<Predicate<Pear>> predicateList) {
        List<Pear> result = pears.stream().collect(Collectors.toList());

        for (Predicate p : predicateList) {
            result = filterPears(result,p);
        }

        return result;
    }

    public static List<Pear> filterPears(List<Pear> pears, Predicate<Pear> p) {
        List<Pear> result = new ArrayList<>();
        for (Pear pear : pears) {
            if (p.test(pear)) {
                result.add(pear);
            }
        }
        return result;
    }

    public static class Pear {

        private int weight;
        private int size;

        public Pear(int weight, int size) {
            this.weight = weight;
            this.size = size;
        }

        public int getWeight() {
            return this.weight;
        }

        public int getSize() {
            return this.size;
        }

        @Override
        public String toString() {
            return "This pear is: " + weight + " in weight" + " and " + size + " in size";
        }

        public static class Builder {
            private int weight;
            private int size;

            public Builder withWeight(int weight) {
                this.weight = weight;
                return this;
            }

            public Builder withSize(int size) {
                this.size = size;
                return this;
            }

            public Pear build() {
                return new Pear(this.weight, this.size);
            }

        }

    };

}
