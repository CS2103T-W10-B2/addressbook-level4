package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Set;

import seedu.address.logic.commands.SortByDefaultCommand;
import seedu.address.logic.commands.SortByNameCommand;
import seedu.address.logic.commands.SortByRecentCommand;
import seedu.address.logic.commands.SortCommand;
import seedu.address.logic.parser.exceptions.ParseException;

//@@author marvinchin
/**
 * Parses input arguments and creates a new {@code SortCommand}.
 */
public class SortCommandParser implements Parser<SortCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the SortCommand
     * and returns an SortCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public SortCommand parse(String args) throws ParseException {
        OptionBearingArgument opArgs = new OptionBearingArgument(args);
        Set<String> options = opArgs.getOptions();

        if (!opArgs.getFilteredArgs().isEmpty() || options.size() > 1) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }

        if (options.contains(SortByNameCommand.COMMAND_OPTION)) {
            return new SortByNameCommand();
        } else if (options.contains(SortByRecentCommand.COMMAND_OPTION)) {
            return new SortByRecentCommand();
        } else if (options.size() == 0) {
            // no options, so return sort by default command
            return new SortByDefaultCommand();
        } else {
            // invalid option, throw exception
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, SortCommand.MESSAGE_USAGE));
        }
    }
}
