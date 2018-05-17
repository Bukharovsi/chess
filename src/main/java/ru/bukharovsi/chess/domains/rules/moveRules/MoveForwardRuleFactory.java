package ru.bukharovsi.chess.domains.rules.moveRules;

import ru.bukharovsi.chess.domains.Colour;

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

    public static MoveRule createOneStepDForwardDiagonal(Colour chessmanColour) {
        if (chessmanColour.isWhite()) {
            return new MoveOneStepDiagonalUpRule();
        } else { //black
            return new MoveOneStepDiagonalDownRule();
        }
    }
}
