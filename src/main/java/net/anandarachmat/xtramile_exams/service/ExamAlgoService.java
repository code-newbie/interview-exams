package net.anandarachmat.xtramile_exams.service;

import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
public class ExamAlgoService {

    private Date startTest;

    public ExamAlgoService(Date startTest) {
        this.startTest = startTest;

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // IO.println("Starting test at " + formatter.format(this.startTest));
        log.debug("Starting test at " + formatter.format(this.startTest));
    }


    public String calculateTwoLargestValue(List<Integer> listInputNo) {
        Objects.requireNonNull(listInputNo, "list Input No");
        if (listInputNo.size() < 2) throw new IllegalArgumentException("Need at least 2 numbers");

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;

        for (var x : listInputNo) {
            if (x == null) continue;
            if (x >= max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }

        if (max2 == Integer.MIN_VALUE)
            throw new IllegalArgumentException("Need at least 2 non-null numbers");
        return String.valueOf(max1 + max2);
    }


    public List<String> findUniqueNumbers(List<Integer> listInputNo) {
        // IO.println("Original list: " + listInputNo);
        log.debug("Original list: " + listInputNo);

        // Convert the List to a HashSet to get unique values
        Set<Integer> uniqueSet = new HashSet<>(listInputNo);
        // IO.println("Unique values as Set: " + uniqueSet);
        log.debug("Unique values as Set: " + uniqueSet);

        // (Optional) Convert the Set back to a List if needed
        List<Integer> listWithUniqueValues = new ArrayList<>(uniqueSet);

        return listWithUniqueValues.stream()
                .filter(Objects::nonNull)
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.toList());
    }
}
