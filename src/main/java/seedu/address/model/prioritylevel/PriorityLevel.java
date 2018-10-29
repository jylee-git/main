package seedu.address.model.prioritylevel;

import static seedu.address.commons.util.AppUtil.checkArgument;
import static seedu.address.model.prioritylevel.PriorityLevelEnum.BASIC;
import static seedu.address.model.prioritylevel.PriorityLevelEnum.IT_UNIT;

import seedu.address.model.person.Person;

//@@author jylee-git
/**
 * Represents the priority level access given to the person.
 * The lower the number, the higher the priority.
 * Refer to {@code PriorityLevelEnum} for more details.
 */
public class PriorityLevel {
    public static final String MESSAGE_PRIORITY_CONSTRAINTS = "Priority level should be between "
            + IT_UNIT + " (" + IT_UNIT.getPriorityLevelCode() + " - highest) and "
            + BASIC + " (" + BASIC.getPriorityLevelCode() + " - lowest).";

    public static final String INSUFFICIENT_PRIORITY_LEVEL = "You must have a priority level of at least %s to perform "
            + "this operation.";

    public static final String NOTOF_CERTAIN_PRIORITYLEVEL = "You need to be holding a priority level of %s to perform"
            + "this operation.";

    public final int priorityLevelCode;

    public PriorityLevel(int priorityLevelCode) {
        checkArgument(PriorityLevelEnum.isValidPriorityLevel(priorityLevelCode), MESSAGE_PRIORITY_CONSTRAINTS);
        this.priorityLevelCode = priorityLevelCode;
    }

    /**
     * Returns if and only if the priority level of the person is equal to the {@code requiredPriority}
     */
    public static boolean isPriorityLevelEqualTo (Person personToCheck, PriorityLevelEnum requiredPriority) {
        return (requiredPriority.getPriorityLevelCode() == personToCheck.getPriorityLevel().priorityLevelCode);
    }

    /**
     * Returns if the priority level of the person meets the min level of {@code minimumPriorityLevel}
     */
    public static boolean isPriorityLevelAtLeastOf (PriorityLevel currPriorityLevel,
                                                    PriorityLevelEnum minimumPriorityLevel) {
        if (currPriorityLevel.priorityLevelCode <= minimumPriorityLevel.getPriorityLevelCode()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof PriorityLevel // instanceof handles nulls
                && priorityLevelCode == ((PriorityLevel) other).priorityLevelCode); // state check
    }

    @Override
    public String toString() {
        return PriorityLevelEnum.values()[priorityLevelCode].toString();
    }
}
