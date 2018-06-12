package forum.model.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "answer")
public class AnswerEntity implements Serializable, IdEntity, Comparable<AnswerEntity> {

	public AnswerEntity() { }
	
	private static final long serialVersionUID = 8983526945864245917L;
	
	@Override
	public int compareTo(AnswerEntity answer) {
		if (this.postDate.equals(answer.postDate))
			return 0;
		else if (this.postDate.after(answer.postDate))
			return 1;
		else
			return -1;
	}
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(
		fetch = FetchType.EAGER,
		targetEntity = UserEntity.class)
	@JoinColumn(name = "id_user")
	private UserEntity answerAuthor;
	
	@ManyToOne(
		fetch = FetchType.EAGER,
		targetEntity = ThreadEntity.class)
	@JoinColumn(name = "id_thread")
	private ThreadEntity answerThread;
	
	@Column(name = "post_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;
	
	@Column(name = "content")
	private String content;

	public Integer getId() {
		return id;
	}
	public UserEntity getAnswerAuthor() {
		return answerAuthor;
	}
	public ThreadEntity getAnswerThread() {
		return answerThread;
	}
	public String getPostDate() {
		DateFormat formatter = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		return formatter.format(postDate);
	}
	public String getContent() {
		return content;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAnswerAuthor(UserEntity answerAuthor) {
		this.answerAuthor = answerAuthor;
	}
	public void setAnswerThread(ThreadEntity answerThread) {
		this.answerThread = answerThread;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
