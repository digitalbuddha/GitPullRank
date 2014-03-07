package com.digitalbuddha.rank.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = "milestone")

public class Pull{
   	private _links _links;
   	private Number additions;
   	private Assignee assignee;
   	private Base base;
   	private String body;
   	private Number changed_files;
   	private String closed_at;
   	private Number comments;
   	private String comments_url;
   	private Number commits;
   	private String commits_url;
   	private String created_at;
   	private Number deletions;
   	private String diff_url;
   	private Head head;
   	private String html_url;
   	private Number id;
   	private String issue_url;
   	private String merge_commit_sha;
   	private boolean mergeable;
   	private String mergeable_state;
   	private boolean merged;
   	private String merged_at;
   	private String merged_by;
   	private String milestone;
   	private Number number;
   	private String patch_url;
   	private String review_comment_url;
   	private Number review_comments;
   	private String review_comments_url;
   	private String state;
   	private String statuses_url;
   	private String title;
   	private String updated_at;
   	private String url;
   	private User user;

 	public _links get_links(){
		return this._links;
	}
	public void set_links(_links _links){
		this._links = _links;
	}
 	public Number getAdditions(){
		return this.additions;
	}
	public void setAdditions(Number additions){
		this.additions = additions;
	}
 	public Assignee getAssignee(){
		return this.assignee;
	}
	public void setAssignee(Assignee assignee){
		this.assignee = assignee;
	}
 	public Base getBase(){
		return this.base;
	}
	public void setBase(Base base){
		this.base = base;
	}
 	public String getBody(){
		return this.body;
	}
	public void setBody(String body){
		this.body = body;
	}
 	public Number getChanged_files(){
		return this.changed_files;
	}
	public void setChanged_files(Number changed_files){
		this.changed_files = changed_files;
	}
 	public String getClosed_at(){
		return this.closed_at;
	}
	public void setClosed_at(String closed_at){
		this.closed_at = closed_at;
	}
 	public Number getComments(){
		return this.comments;
	}
	public void setComments(Number comments){
		this.comments = comments;
	}
 	public String getComments_url(){
		return this.comments_url;
	}
	public void setComments_url(String comments_url){
		this.comments_url = comments_url;
	}
 	public Number getCommits(){
		return this.commits;
	}
	public void setCommits(Number commits){
		this.commits = commits;
	}
 	public String getCommits_url(){
		return this.commits_url;
	}
	public void setCommits_url(String commits_url){
		this.commits_url = commits_url;
	}
 	public String getCreated_at(){
		return this.created_at;
	}
	public void setCreated_at(String created_at){
		this.created_at = created_at;
	}
 	public Number getDeletions(){
		return this.deletions;
	}
	public void setDeletions(Number deletions){
		this.deletions = deletions;
	}
 	public String getDiff_url(){
		return this.diff_url;
	}
	public void setDiff_url(String diff_url){
		this.diff_url = diff_url;
	}
 	public Head getHead(){
		return this.head;
	}
	public void setHead(Head head){
		this.head = head;
	}
 	public String getHtml_url(){
		return this.html_url;
	}
	public void setHtml_url(String html_url){
		this.html_url = html_url;
	}
 	public Number getId(){
		return this.id;
	}
	public void setId(Number id){
		this.id = id;
	}
 	public String getIssue_url(){
		return this.issue_url;
	}
	public void setIssue_url(String issue_url){
		this.issue_url = issue_url;
	}
 	public String getMerge_commit_sha(){
		return this.merge_commit_sha;
	}
	public void setMerge_commit_sha(String merge_commit_sha){
		this.merge_commit_sha = merge_commit_sha;
	}
 	public boolean getMergeable(){
		return this.mergeable;
	}
	public void setMergeable(boolean mergeable){
		this.mergeable = mergeable;
	}
 	public String getMergeable_state(){
		return this.mergeable_state;
	}
	public void setMergeable_state(String mergeable_state){
		this.mergeable_state = mergeable_state;
	}
 	public boolean getMerged(){
		return this.merged;
	}
	public void setMerged(boolean merged){
		this.merged = merged;
	}
 	public String getMerged_at(){
		return this.merged_at;
	}
	public void setMerged_at(String merged_at){
		this.merged_at = merged_at;
	}
 	public String getMerged_by(){
		return this.merged_by;
	}
	public void setMerged_by(String merged_by){
		this.merged_by = merged_by;
	}
 	public String getMilestone(){
		return this.milestone;
	}
	public void setMilestone(String milestone){
		this.milestone = milestone;
	}
 	public Number getNumber(){
		return this.number;
	}
	public void setNumber(Number number){
		this.number = number;
	}
 	public String getPatch_url(){
		return this.patch_url;
	}
	public void setPatch_url(String patch_url){
		this.patch_url = patch_url;
	}
 	public String getReview_comment_url(){
		return this.review_comment_url;
	}
	public void setReview_comment_url(String review_comment_url){
		this.review_comment_url = review_comment_url;
	}
 	public Number getReview_comments(){
		return this.review_comments;
	}
	public void setReview_comments(Number review_comments){
		this.review_comments = review_comments;
	}
 	public String getReview_comments_url(){
		return this.review_comments_url;
	}
	public void setReview_comments_url(String review_comments_url){
		this.review_comments_url = review_comments_url;
	}
 	public String getState(){
		return this.state;
	}
	public void setState(String state){
		this.state = state;
	}
 	public String getStatuses_url(){
		return this.statuses_url;
	}
	public void setStatuses_url(String statuses_url){
		this.statuses_url = statuses_url;
	}
 	public String getTitle(){
		return this.title;
	}
	public void setTitle(String title){
		this.title = title;
	}
 	public String getUpdated_at(){
		return this.updated_at;
	}
	public void setUpdated_at(String updated_at){
		this.updated_at = updated_at;
	}
 	public String getUrl(){
		return this.url;
	}
	public void setUrl(String url){
		this.url = url;
	}
 	public User getUser(){
		return this.user;
	}
	public void setUser(User user){
		this.user = user;
	}
}
