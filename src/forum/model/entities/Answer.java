package forum.model.entities;

import java.io.Serializable;
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
public class Answer implements Serializable, DatabaseEntity {

	public Answer() { }
	
	private static final long serialVersionUID = 8983526945864245917L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne(
		fetch = FetchType.EAGER,
		targetEntity = User.class)
	@JoinColumn(name = "id_user")
	private User answerAuthor;
	
	@ManyToOne(
		fetch = FetchType.EAGER,
		targetEntity = Topic.class)
	@JoinColumn(name = "id_topic")
	private Topic answerTopic;
	
	@Column(name = "post_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;
	
	@Column(name = "content")
	private String content;

	public Integer getId() {
		return id;
	}
	public User getAnswerAuthor() {
		return answerAuthor;
	}
	public Topic getAnswerTopic() {
		return answerTopic;
	}
	public Date getPostDate() {
		return postDate;
	}
	public String getContent() {
		return content;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAnswerAuthor(User answerAuthor) {
		this.answerAuthor = answerAuthor;
	}
	public void setAnswerTopic(Topic answerTopic) {
		this.answerTopic = answerTopic;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
