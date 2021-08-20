# Changelog

## [v.1.0-alpha] - 2021/8/20:
### Added:
- `ChessPiece`: Data structure that holds a `PieceType` and a `PieceColor` and has static functions `asLetter(ChessPiece chessPiece)` and `getDescriptionOf(ChessPiece chessPiece)`.
- `Coordinates`, `Coordinate` and `Point`: Utilities that help with transforming coordinates from their raw variant (i.e: '[4,4]') to a human readable form (i.e: 'E4') and vise-versa.
- `Chessboard`: Object that holds an array of `ChessPiece`'s which represents every tile on a real chessboard. A chess piece can be accesssed through the `getPieceByIndex(int i)`, `getPieceByXY(int x, int y)` or `getPieceByCoordinate(Coordinate coordinate)` methods.
- `ConsoleChessRenderer` which inhertits from `ChessRenderer`: Print's the chessboard along with coordinates to the console by the `printBoard(boolean WhitePerspective)` method.
- Testing for the `ChessBoard` and `Coordinates` class.
- Two checker pieces when the game is ran in a window

## [v.0.0-alpha] - 2021/8/17:
### Added:
- Changelog file.
