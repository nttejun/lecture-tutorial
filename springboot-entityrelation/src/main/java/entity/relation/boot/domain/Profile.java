package entity.relation.boot.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
// 양방향 참조 문제를 방지하는 exclude 설정
@ToString(exclude = "member")
@Entity
@Table(name = "tbl_profile")
@EqualsAndHashCode(of = "fname")
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fno;

    private String fname;

    private boolean current;

    @ManyToOne
    private Member member;
}
