package pl.project.externalservice.comparators;

import pl.project.externalservice.entities.FeignTask;

import java.util.Comparator;

public class DescriptionComparator implements Comparator<FeignTask> {
    @Override
    public int compare(FeignTask o1, FeignTask o2) {
        return o1.getDescription().compareTo(o2.getDescription());
    }
}
