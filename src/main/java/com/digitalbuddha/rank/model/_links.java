
package com.digitalbuddha.rank.model;

public class _links{
   	private Comments comments;
   	private Commits commits;
   	private Html html;
   	private Issue issue;
   	private Review_comment review_comment;
   	private Review_comments review_comments;
   	private Self self;
   	private Statuses statuses;

 	public Comments getComments(){
		return this.comments;
	}
	public void setComments(Comments comments){
		this.comments = comments;
	}
 	public Commits getCommits(){
		return this.commits;
	}
	public void setCommits(Commits commits){
		this.commits = commits;
	}
 	public Html getHtml(){
		return this.html;
	}
	public void setHtml(Html html){
		this.html = html;
	}
 	public Issue getIssue(){
		return this.issue;
	}
	public void setIssue(Issue issue){
		this.issue = issue;
	}
 	public Review_comment getReview_comment(){
		return this.review_comment;
	}
	public void setReview_comment(Review_comment review_comment){
		this.review_comment = review_comment;
	}
 	public Review_comments getReview_comments(){
		return this.review_comments;
	}
	public void setReview_comments(Review_comments review_comments){
		this.review_comments = review_comments;
	}
 	public Self getSelf(){
		return this.self;
	}
	public void setSelf(Self self){
		this.self = self;
	}
 	public Statuses getStatuses(){
		return this.statuses;
	}
	public void setStatuses(Statuses statuses){
		this.statuses = statuses;
	}
}
