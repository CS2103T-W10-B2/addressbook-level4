package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.UnFavoriteCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses input arguments and creates a new FavoriteCommand object
 */
public class UnFavoriteCommandParser implements Parser<UnFavoriteCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the FavoriteCommand
     * and returns an FavoriteCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public UnFavoriteCommand parse(String args) throws ParseException {
        try {
            List<Index> indexList = ParserUtil.parseMultipleIndexes(args);
            return new UnFavoriteCommand(indexList);
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, UnFavoriteCommand.MESSAGE_USAGE));
        }
    }
}