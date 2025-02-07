package skushniarou;

import java.sql.*;
import java.util.Optional;

public class GameService {
    private static final String URL = "jdbc:sqlite:tictactoe.db";

    public Game createNewGame() {
        String sql = "INSERT INTO games (board, currentPlayer, status) VALUES ('---------', 'X', 'IN_PROGRESS')";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                Game game = new Game();
                game.setId(rs.getLong(1));
                game.setBoard("---------");
                game.setCurrentPlayer("X");
                game.setStatus("IN_PROGRESS");
                return game;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Optional<Game> getGame(Long id) {
        String sql = "SELECT * FROM games WHERE id = ?";
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Game game = new Game();
                game.setId(rs.getLong("id"));
                game.setBoard(rs.getString("board"));
                game.setCurrentPlayer(rs.getString("currentPlayer"));
                game.setStatus(rs.getString("status"));
                return Optional.of(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}

