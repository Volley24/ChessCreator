# ChessCreator
A chess variant creator made with Java and libGDX.

This app is a WIP and currently only has basic chess rules implemented.

So far, the game has a few features:
- Unit tests with converting coordinates (from human readable to chess position index)
- A `ChessBoard` class that holds chess pieces inside of a uni-dimensional array, aswell as utility methods for moving pieces.
  - A `ChessGame` class that has a `ChessBoard` object and other variables to control gameplay, such as whose turn it currently is.
- Able to print a `ChessBoard` via a `ConsoleChessRenderer` which displays the chess board from either white's or black's persepctive onto the console. [Example](console_chess.png)
- Able to display a `ChessBoard` inside a graphical window, allowing for zooming in and out, clicking on pieces to move them, and changing the color perspective.
- Able to move pieces according to their type by clicking on them then clicking on the desired square to land on, but not able capture other pieces. [Image](movable_pieces.png)
  - A yellow circle appears over the currently selected piece when left-clicking, and clicking on another square will check if that is a valid move, and if so, move the piece to that square.   
  - A green circle appears when right-clicking on any pieces or square, and multiple can be present at the same time. Left-clicking will remove all of these circles.
  - Pawns can move one space forwards
  - Bishops can move diagonally
  - Rooks can move vertically and horizontally
  - Queens can move vertically, horizontally and diagonally
  - Knights move in an 'L' shape
  - Kings can only move to an adjacent square.
- Pieces may not 'jump' over other pieces, except the knight
  - The bishop cannot jump over a pawn, but is blocked by it.
  - There is however a bug allowing a pawn to jump over other pieces on it's first move due to the two-space move rule on the first pawn move.
- Able to setup the board from FEN (a chess notation used to import games based on a string)
  - Example: 8/5k2/3p4/1p1Pp2p/pP2Pp1P/P4P1K/8/8 b [Image](fen_import.png)
  - However, the chess application only uses the first two parts of the FEN string, the pieces position and the next color to move. Other details such as moves until draw and total moves is a WIP.
