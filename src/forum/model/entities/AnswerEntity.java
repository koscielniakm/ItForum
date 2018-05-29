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
public class AnswerEntity implements Serializable, IdEntity {

	public AnswerEntity() { }
	
	private static final long serialVersionUID = 8983526945864245917L;
	
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
		targetEntity = TopicEntity.class)
	@JoinColumn(name = "id_topic")
	private TopicEntity answerTopic;
	
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
	public TopicEntity getAnswerTopic() {
		return answerTopic;
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
	public void setAnswerTopic(TopicEntity answerTopic) {
		this.answerTopic = answerTopic;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
