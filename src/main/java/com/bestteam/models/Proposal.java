package com.bestteam.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;

import com.bestteam.helpers.ProposalStatus;
import com.bestteam.helpers.NRPArea;
import com.bestteam.exceptions.WordCountOverLimitException;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.validation.constraints.NotNull;

@Entity
@Table(name="Proposal")
public class Proposal {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private ProposalStatus status;

    @NotNull
    @Column(name="primary_attribution")
    private Long primaryAttribution;

    @NotNull
    @Column(name="project_id")
    private Long projectId;

    @Column(name="title")
    private String title;

    @Column(name="duration")
    private Long duration;

    @Column(name="nrp_area")
    @Enumerated(EnumType.STRING)
    private NRPArea nrpArea;

    @Column(name="legal_remit_alignment")
    private String legalRemitAlignment;

    @Column(name="ethical_issues")
    private String ethicalIssues;

    @Column(name="applicant_location_statement")
    private String applicantLocationStatement;

    /* @Column(name="co_applicants_list")
    private String coApplicantsList;

    @Column(name="collaborators_list")
    private String collaboratorsList; */

    @Column(name="scientific_abstract")
    private String scientificAbstract;

    @Column(name="lay_abstract")
    private String layAbstract;

    @Column(name="file_location")
    private String fileLocation;

    @Column(name="declaration")
    private boolean declaration;

    @OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name="proposal_id")
    private Set<ProposalReviews> proposalReviews = new LinkedHashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ProposalStatus getStatus() {
		return status;
	}

	public void setStatus(ProposalStatus status) {
		this.status = status;
	}

	public Long getPrimaryAttribution() {
		return primaryAttribution;
	}

	public void setPrimaryAttribution(Long primaryAttribution) {
		this.primaryAttribution = primaryAttribution;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
        if (title.split("\\s+").length>30){
            throw new WordCountOverLimitException("Title", id.toString());
        }
		this.title = title;
	}

	public Long getDuration() {
		return duration;
	}

	public void setDuration(Long duration) {
		this.duration = duration;
	}

	public NRPArea getNrpArea() {
		return nrpArea;
	}

	public void setNrpArea(NRPArea nrpArea) {
		this.nrpArea = nrpArea;
	}

	public String getLegalRemitAlignment() {
		return legalRemitAlignment;
	}

	public void setLegalRemitAlignment(String legalRemitAlignment) {
        if (legalRemitAlignment.split("\\s+").length>250){
            throw new WordCountOverLimitException("Legal Remit Alignment", id.toString());
        }
		this.legalRemitAlignment = legalRemitAlignment;
	}

	public String getEthicalIssues() {
		return ethicalIssues;
	}

	public void setEthicalIssues(String ethicalIssues) {
		this.ethicalIssues = ethicalIssues;
	}

	public String getApplicantLocationStatement() {
		return applicantLocationStatement;
	}

	public void setApplicantLocationStatement(String applicantLocationStatement) {
		this.applicantLocationStatement = applicantLocationStatement;
	}

	/* public String getCoApplicantsList() {
		return coApplicantsList;
	}

	public void setCoApplicantsList(String coApplicantsList) {
		this.coApplicantsList = coApplicantsList;
	}

	public String getCollaboratorsList() {
		return collaboratorsList;
	}

	public void setCollaboratorsList(String collaboratorsList) {
		this.collaboratorsList = collaboratorsList;
	} */

	public String getScientificAbstract() {
		return scientificAbstract;
	}

	public void setScientificAbstract(String scientificAbstract) {
        if (scientificAbstract.split("\\s+").length>200){
            throw new WordCountOverLimitException("Scientific Abstract", id.toString());
        }
		this.scientificAbstract = scientificAbstract;
	}

	public String getLayAbstract() {
		return layAbstract;
	}

	public void setLayAbstract(String layAbstract) {
        if (layAbstract.split("\\s+").length>100){
            throw new WordCountOverLimitException("Lay Abstract", id.toString());
        }
		this.layAbstract = layAbstract;
	}

	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation = fileLocation;
	}

    public boolean isDeclaration() {
        return declaration;
    }

    public boolean getDeclaration() {
    	return declaration;
    }

	public void setDeclaration(boolean declaration) {
		this.declaration = declaration;
	}

    public Set<ProposalReviews> getProposalReviews() {
    	return proposalReviews;
    }

	public void setProposalReviews(Set<ProposalReviews> proposalReviews) {
		this.proposalReviews = proposalReviews;
	}

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", status='" + getStatus() + "'" +
            ", primaryAttribution='" + getPrimaryAttribution() + "'" +
            ", projectId='" + getProjectId() + "'" +
            ", title='" + getTitle() + "'" +
            ", duration='" + getDuration() + "'" +
            ", nrpArea='" + getNrpArea() + "'" +
            ", legalRemitAlignment='" + getLegalRemitAlignment() + "'" +
            ", ethicalIssues='" + getEthicalIssues() + "'" +
            ", applicantLocationStatement='" + getApplicantLocationStatement() + "'" +
            /* ", coApplicantsList='" + getCoApplicantsList() + "'" +
            ", collaboratorsList='" + getCollaboratorsList() + "'" + */
            ", scientificAbstract='" + getScientificAbstract() + "'" +
            ", layAbtract='" + getLayAbstract() + "'" +
            ", fileLocation='" + getFileLocation() + "'" +
            ", declaration='" + getDeclaration() + "'" +
            "}";
    }
}
