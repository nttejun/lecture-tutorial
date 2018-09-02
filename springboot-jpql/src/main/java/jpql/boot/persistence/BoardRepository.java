package jpql.boot.persistence;

import jpql.boot.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface BoardRepository extends CrudRepository <Board, Long> {

    List<Board> findBoardByTitle(String title);

    Collection<Board>findByWriter(String writer);

    Collection<Board>findByWriterContaining(String writer);

    Collection<Board> findByWriterContainingOrTitleContaining(String writer, String title);

    Collection<Board> findByTitleContainingAndBnoGreaterThan(String title, long bno);

    Collection<Board> findByBnoGreaterThanOrderByBnoDesc(long bno);

    List<Board> findByBnoGreaterThanOrderByBnoDesc(long bno, Pageable pageable);

    Page<Board> findByBnoGreaterThan(long l, Pageable paging);

    @Query("SELECT b FROM Board b WHERE b.title LIKE %?1% AND b.bno > 0 ORDER BY b.bno DESC")
    List<Board> findByTitle(String title);

    @Query("SELECT b FROM Board b WHERE b.content LIKE %:content% AND b.bno > 0 ORDER BY b.bno DESC")
    List<Board> findByContent(@Param("content") String content);

/*
    Repository Entity 타입을 자동으로 사용
    @Query("SELECT b FROM #{#entityName} b WHERE b.writer LIKE %?1% AND b.bno > 0 ORDER BY b.bno DESC")
    List<Board> findByWriter(String writer);
*/

}
