package jpql.boot.persistence;

import jpql.boot.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.List;

public interface BoardRepository extends CrudRepository <Board, Long> {

    public List<Board> findBoardByTitle(String title);
    public Collection<Board>findByWriter(String writer);

}
