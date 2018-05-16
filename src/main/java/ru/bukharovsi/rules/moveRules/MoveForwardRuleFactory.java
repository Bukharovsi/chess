package ru.bukharovsi.rules.moveRules;

import ru.bukharovsi.Colour;

/**
 * White pawns go up, but black pawns go down.
 * And for whites go straight means - UP
 * for blacks go straight means DOWN
 */
public class MoveForwardRuleFactory {

    public static MoveRule createOneStepMoveRule(Colour chessmanColour) {
        if (chessmanColour.isWhite()) {
            return new MoveUpOneStepRule();
        } else { // black
            return new MoveDownOneStepRule();
        }
    }

    public static MoveRule createTwoStepMoveRule(Colour chessmanColour) {
        if (chessmanColour.isWhite()) {
            return new MoveUpTwoStepsRule();
        } else { //black
            return new MoveDownTwoStepsRule();
        }
    }
}
