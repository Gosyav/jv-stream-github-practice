package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate c) {
        if (c.getAge() < 35) {
            return false;
        }

        if (!c.isAllowedToVote()) {
            return false;
        }

        if (!"Ukrainian".equals(c.getNationality())) {
            return false;
        }

        String[] years = c.getPeriodsInUkr().split("-");
        int from = Integer.parseInt(years[0]);
        int to = Integer.parseInt(years[1]);

        return (to - from + 1) >= 10;
    }
}
