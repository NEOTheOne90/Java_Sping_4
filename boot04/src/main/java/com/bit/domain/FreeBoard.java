package com.bit.domain;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@Entity @Table(name = "tbl_freeboards")
@ToString(exclude = "replies") //replies 생략 출력
public class FreeBoard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String writer;
	private String content;
	
	@CreationTimestamp
	private Timestamp regdate;
	@UpdateTimestamp
	private Timestamp updatedate;
	
	//mappedBy = "board" : FreeBoardReply 클래스에 변수 'board'에 fk 설정
	@OneToMany(mappedBy = "board", cascade = CascadeType.ALL)
	private List<FreeBoardReply> replies;
	
}



