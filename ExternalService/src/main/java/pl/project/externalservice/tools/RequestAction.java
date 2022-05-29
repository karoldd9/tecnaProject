package pl.project.externalservice.tools;

import pl.project.externalservice.comparators.IdComparator;
import pl.project.externalservice.comparators.TitleComparator;
import pl.project.externalservice.comparators.DescriptionComparator;
import pl.project.externalservice.comparators.PriorityComparator;
import pl.project.externalservice.entities.FeignTask;

import java.util.List;

public class RequestAction {

    public static final int ID=1, TITLE=2, DESCRIPTION=3, PRIORITY=4;

    public static boolean filterFeignTasks(int filterValue, String requestValue, FeignTask feignTask) {

        return switch (filterValue) {
            case ID -> String.valueOf(feignTask.getId()).toUpperCase().equals(requestValue);
            case TITLE -> feignTask.getTitle().toUpperCase().equals(requestValue);
            case DESCRIPTION -> feignTask.getDescription().toUpperCase().equals(requestValue);
            case PRIORITY -> String.valueOf(feignTask.getPriority()).toUpperCase().equals(requestValue);
            default -> false;
        };
    }

    public static void sortFeignTasks(List<FeignTask> feignTasks, int sortedValue) {

        switch (sortedValue) {
            case ID:
                feignTasks.sort(new IdComparator());
                break;
            case PRIORITY:
                feignTasks.sort(new PriorityComparator());
                break;
            case DESCRIPTION:
                feignTasks.sort(new DescriptionComparator());
                break;
            case TITLE:
                feignTasks.sort(new TitleComparator());
                break;
        }
    }
}
