package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dto.Board;

public class BoardDaoImpl implements BoardDao {

    static private BoardDao instance = new BoardDaoImpl();
    private List<Board> boardList = new ArrayList<Board>();
    private int num = 0;

    private BoardDaoImpl() {
        // TODO Auto-generated constructor stub
    }

    static public BoardDao getInstance() {
        return instance;
    }

    @Override
    public void insert(Board board) {
        num++;
        board.setNum(num);
        boardList.add(board);
    }

    @Override
    public List<Board> selectAll() {
        // TODO Auto-generated method stub
        if (boardList.size() == 0) {
            return null;
        }
        Collections.sort(boardList, (a, b) -> ((Board) a).getDate().compareTo(((Board) b).getDate()));
        boardList.sort((Board a, Board b) -> a.getDate().compareTo(b.getDate()));
        return boardList;
    }

    @Override
    public Board select(int num) {
        for (Board board : boardList) {
            if (board.getNum() == num) {
                return board;
            }
        }
        return null;
    }

    @Override
    public void update(Board board) {
        int index = boardList.size();
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getNum() == board.getNum()) {
                index = i;
                break;
            }
        }
        Board temp = boardList.get(index);
        temp.setTitle(board.getTitle());
        temp.setContent(board.getContent());
        temp.setWriter(board.getWriter());
        boardList.set(index, temp);
    }

    @Override
    public void remove(int num) {
        for (int i = 0; i < boardList.size(); i++) {
            if (boardList.get(i).getNum() == num) {
                boardList.remove(i);
                break;
            }
        }
        
        
    }

}
