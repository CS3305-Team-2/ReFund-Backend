package com.bestteam.helpers;

public enum CollaborationGoal {

    ACCESS_TO_SOFTWARE_DATA_MATERIAL_EQUIPMENT("Access to software/data/material/equipment"),
    TRAINING_AND_CAREER_DEVELOPMENT("Training and career development"),
    JOIN_PUBLICATION("Joint publication"),
    STARTUP_DEVELOPMENT("Startup development"),
    LICENSE_DEVELOPMENT("License development"),
    BUILDING_NETWORK_AND_RELATIONSHIPS("Building networks and relationships");

    private String content;

    CollaborationGoal(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return content;
    }
}
