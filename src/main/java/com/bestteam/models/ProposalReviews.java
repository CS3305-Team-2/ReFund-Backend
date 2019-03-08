package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

import javax.validation.constraints.NotNull;

import com.bestteam.exceptions.ScoreNotInRangeException;

@Entity
@Table(name="ProposalReviews")
public class ProposalReviews {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="proposal_id")
    private Long proposalId;

    @Column(name="score")
    private Long score;

    @Column(name="comments")
    private String comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProposalId() {
        return proposalId;
    }

    public void setProposalId(Long proposalId) {
        this.proposalId = proposalId;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        if (score<=100 && score>=0){
            this.score = score;
        } else {
            throw new ScoreNotInRangeException(score.toString());
        }
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", proposalId='" + getProposalId() + "'" +
            ", score='" + getScore() + "'" +
            ", comments='" + getComments() + "'" +
            "}";
    }
}
