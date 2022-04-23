# ChessCreator
A chess variant creator made with Java and libGDX.

This app is a WIP and currently only has basic chess rules implemented.

So far, the game has a few features:
- Unit tests with converting coordinates (from human readable to chess position index)
- Console printer than prints out the board [Image](console_chess.png)
- Able to zoom in and out on the board and rotate it to change the perspective
- Able to move pieces according to their type, but not able capture other pieces. [Image](movable_pieces.png)
  - Pawns can move one space forwards
  - Bishops can move diagonally
  - Rooks can move vertically and horizontally
  - Queens can move vertically, horizontally and diagonally
  - Knights move in an 'L' shape
  - Kings can only move to an adjacent square.
- Pieces may not 'jump' over other pieces, except the knight
  - The bishop cannot jump over a pawn, but is blocked by it.\
  - There is however a bug allowing a pawn to jump over other pieces on it's first move due to the two-space move rule on the first pawn move.
- Able to setup the board from FEN (a chess notation used to import games based on a string)
  - Example: 8/5k2/3p4/1p1Pp2p/pP2Pp1P/P4P1K/8/8 b [Image](fen_import.png)
  - However, the chess application only uses the first two parts of the FEN string, the pieces position and the next color to move. Other details such as moves until draw and total moves is a WIP.
-