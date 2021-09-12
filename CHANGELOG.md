# Changelog

## [v.2.0-alpha] - 2021/8/20:
Logic and Graphical Update!
### Added:
- Antialiasing with a sample rate of 3, so circles do not look pixelated.
- Piece movement for every chess piece! (Pawn, Knight, Bishop, Rook, Queen and King)
- A graphical chess board that can be zoomed in and out with `MINUS` and `EQUALS` keys,
 and with square that can be selected with right click and left click.

### Changed:
- Changed `Coordinates` to `CoordinateConverter` to avoid creating objects.
- 

### Fixed:
- `A`
- Two checker pieces when the game is ran in a window

## [v.1.0-alpha] - 2021/8/20:
### Added:
- `ChessPiece`: Data structure that holds a `PieceType` and a `PieceColor` and has static functions `asLetter(ChessPiece chessPiece)` and `getDescriptionOf(ChessPiece chessPiece)`.
- `Coordinates`, `Coordinate` and `Point`: Utilities that help with transforming coordinates from their raw variant (i.e: '[4,4]') to a human readable form (i.e: 'E4') and vise-versa.
- `Chessboard`: Object that holds an array of `ChessPiece`'s which represents every tile on a real chessboard. A chess piece can be accesssed through the `getPieceByIndex(int i)`, `getPieceByXY(int x, int y)` or `getPieceByCoordinate(Coordinate coordinate)` methods.
- `ConsoleChessRenderer` which inherits from `ChessRenderer`: Print's the chessboard along with coordinates to the console by the `printBoard(boolean WhitePerspective)` method.
- Testing for the `ChessBoard` and `Coordinates` class.
- Two checker pieces when the game is ran in a window

## [v.0.0-alpha] - 2021/8/17:
### Added:
- Changelog file.
