package skushniarou;

import jakarta.persistence.*;

@Entity
@Table(name = "game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="board")
    private String board;
    @Column(name="currentPlayer")
    private String currentPlayer;
    @Enumerated(EnumType.STRING)
    @Column(name="status")
    private Status status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getBoard() { return board; }
    public void setBoard(String board) { this.board = board; }
    public String getCurrentPlayer() { return currentPlayer; }
    public void setCurrentPlayer(String currentPlayer) { this.currentPlayer = currentPlayer; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }
}
