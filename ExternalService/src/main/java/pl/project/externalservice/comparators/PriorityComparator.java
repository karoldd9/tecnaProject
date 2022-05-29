package pl.project.externalservice.comparators;

import pl.project.externalservice.entities.FeignTask;

import java.util.Comparator;

public class PriorityComparator implements Comparator<FeignTask> {
    @Override
    public int compare(FeignTask o1, FeignTask o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
