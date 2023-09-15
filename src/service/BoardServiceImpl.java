package service;

import java.util.List;

import dao.BoardDao;
import dao.BoardDaoImpl;
import dto.Board;

public class BoardServiceImpl implements BoardService {

    static private BoardService instance = new BoardServiceImpl();
    private BoardDao dao = BoardDaoImpl.getInstance();

    private BoardServiceImpl() {
        // TODO Auto-generated constructor stub
    }

    static public BoardService getInstance() {
        return instance;
    }

    @Override
    public void insert(Board board) {
        dao.insert(board);
    }

    @Override
    public List<Board> selectAll() {
        // TODO Auto-generated method stub
        return dao.selectAll();
    }

    @Override
    public Board select(int num) {
        // TODO Auto-generated method stub
        return dao.select(num);
    }

    @Override
    public void update(Board board) {
        // TODO Auto-generated method stub
        dao.update(board);
    }

    @Override
    public void remove(int num) {
        // TODO Auto-generated method stub
        dao.remove(num);
    }

}
