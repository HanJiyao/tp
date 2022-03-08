package seedu.contax.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.contax.ui.ListContentType;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;
    private final ListContentType uiContentType;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, ListContentType contentType, boolean showHelp, boolean exit) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.uiContentType = requireNonNull(contentType);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value. The contents the list shows defaults to {@code UNCHANGED}.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, ListContentType.UNCHANGED, false, false);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser} and the
     * {@code contentType} to display in the content list.
     */
    public CommandResult(String feedbackToUser, ListContentType contentType) {
        this(feedbackToUser, contentType, false, false);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser}, {@code showHelp} and
     * {@code exit}. The contents the list shows defaults to {@code UNCHANGED}.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit) {
        this(feedbackToUser, ListContentType.UNCHANGED, showHelp, exit);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public ListContentType getUiContentType() {
        return uiContentType;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && uiContentType.equals(otherCommandResult.uiContentType)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, uiContentType, showHelp, exit);
    }

}
