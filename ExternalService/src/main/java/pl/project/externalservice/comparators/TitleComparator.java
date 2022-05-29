package pl.project.externalservice.comparators;

import pl.project.externalservice.entities.FeignTask;

import java.util.Comparator;

public class TitleComparator implements Comparator<FeignTask> {
    @Override
    public int compare(FeignTask o1, FeignTask o2) {
        return o1.getTitle().compareTo(o2.getTitle());
    }
}
