package io.tdd.sys.yeongSu.domain.board;

import io.tdd.sys.yeongSu.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Slf4j
@NoArgsConstructor
@AllArgsConstructor(staticName = "of")
public class Board extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String description;
    Boolean isShow;
    String writer;
    String modifier;

    public void updateIsShow(Boolean isShow, String modifier) {
        this.isShow = isShow;
        this.modifier = modifier;
    }

    public void updateDescription(String description, String modifier) {
        this.description = description;
        this.modifier = modifier;
    }

}
