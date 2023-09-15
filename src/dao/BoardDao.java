package dao;

import java.util.List;

import dto.Board;

public interface BoardDao {

    // C
    void insert(Board board);

    // R
    List<Board> selectAll();

    Board select(int num);

    // U
    void update(Board board);

    // D
    void remove(int num);

}
