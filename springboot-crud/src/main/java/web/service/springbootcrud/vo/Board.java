package web.service.springbootcrud.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.sql.Timestamp;

@Getter
@Setter
@ToString
@Table(name="TBM_BOARD")
@Entity
public class Board {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    private Long bno;

    private String title;
    private String writer;
    private String content;

    @CreationTimestamp
    private Timestamp regDate;

    @UpdateTimestamp
    private Timestamp uptDate;

}
