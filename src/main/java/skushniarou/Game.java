package skushniarou;

import jakarta.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="board")
    private String board;
    @Column(name="currentPlayer")
    private String currentPlayer;
    @Column(name="status")
    private String status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBoard() { return board; }
    public void setBoard(String board) { this.board = board; }
    public String getCurrentPlayer() { return currentPlayer; }
    public void setCurrentPlayer(String currentPlayer) { this.currentPlayer = currentPlayer; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
