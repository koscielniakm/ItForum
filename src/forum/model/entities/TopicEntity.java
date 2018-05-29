package forum.model.entities;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "topic")
public class TopicEntity implements Serializable, IdEntity {
	
	public TopicEntity() { }

	private static final long serialVersionUID = -3390766510231376270L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(
		fetch = FetchType.EAGER,
		targetEntity = UserEntity.class)
	@JoinColumn(name = "id_user")
	private UserEntity author;
	
	@OneToMany(
		mappedBy = "answerTopic",
		cascade = CascadeType.ALL,
		fetch = FetchType.EAGER)
	private Set<AnswerEntity> answers;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "post_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date postDate;

	public Integer getId() {
		return id;
	}
	public UserEntity getAuthor() {
		return author;
	}
	public Set<AnswerEntity> getAnswers() {
		return answers;
	}
	public String getTitle() {
		return title;
	}
	public String getContent() {
		return content;
	}
	public String getPostDate() {
		DateFormat formatter = new SimpleDateFormat("HH:mm dd-MM-yyyy");
		return formatter.format(postDate);
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setAuthor(UserEntity author) {
		this.author = author;
	}
	public void setAnswers(Set<AnswerEntity> answers) {
		this.answers = answers;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}

}
