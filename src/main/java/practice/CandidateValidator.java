package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate c) {
        if (c.getAge() < MIN_AGE) {
            return false;
        }

        if (!c.isAllowedToVote()) {
            return false;
        }

        if (!NATIONALITY.equals(c.getNationality())) {
            return false;
        }

        String[] years = c.getPeriodsInUkr().split("-");
        if (years.length != 2) {
            return false;
        }

        try {
            int from = Integer.parseInt(years[0].trim());
            int to = Integer.parseInt(years[1].trim());

            return (to - from) >= MIN_YEARS;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
