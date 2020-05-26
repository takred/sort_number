package takred;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> getRandomNumbersList(int sizeList) {
        List<Integer> numbersList = new ArrayList<>();
        for (int i = 0; i < sizeList; i++) {
            numbersList.add(java.util.concurrent.ThreadLocalRandom.current().nextInt(0, 100));
        }
        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(i + 1 + " = " + numbersList.get(i));
        }
        return numbersList;
    }

    public static List<Integer> getSortNumbersLists(List<Integer> numbersList) {
        List<Integer> sortNumbersList = new ArrayList<>();
        int currentElement;
        for (int i = 0; i < numbersList.size(); i++) {
            currentElement = Integer.MAX_VALUE;
            if (i != 0) {
                for (int j = 0; j < numbersList.size(); j++) {
                    Integer numberByIndex = numbersList.get(j);
                    Integer lastSortElement = sortNumbersList.get(sortNumbersList.size() - 1);
                    if (numberByIndex > lastSortElement
                            && numberByIndex < currentElement) {
                        currentElement = numberByIndex;
                    }
                }
                sortNumbersList.add(currentElement);
            } else {
                int absoluteMinimum = Integer.MIN_VALUE;
                for (int j = 0; j < numbersList.size(); j++) {
                    Integer numberByIndex = numbersList.get(j);
                    if (numberByIndex > absoluteMinimum
                            && numberByIndex < currentElement) {
                        currentElement = numberByIndex;
                    }
                }
                sortNumbersList.add(currentElement);
            }
        }
        return sortNumbersList;
    }

    public static List<Integer> getSortNumbersList(List<Integer> numberLit) {
        int element;
        boolean indicator = true;
        while (indicator) {
            indicator = false;
            for (int i = 0; i < numberLit.size() - 1; i++) {
                Integer currentNumber = numberLit.get(i);
                Integer nextNumber = numberLit.get(i + 1);
                if (currentNumber > nextNumber) {
                    element = currentNumber;
                    numberLit.set(i, nextNumber);
                    numberLit.set(i + 1, element);
                    indicator = true;
                }
            }
        }
        return numberLit;
    }

    public static void main(String[] args) {
        List<Integer> numbersList = new ArrayList<>(getRandomNumbersList(20));
        numbersList = new ArrayList<>(getSortNumbersList(numbersList));

        for (int i = 0; i < numbersList.size(); i++) {
            System.out.println(i + 1 + " = " + numbersList.get(i));
        }
    }
}
