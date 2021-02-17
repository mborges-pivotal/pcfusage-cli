package com.borgescloud.pcfusage.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Foundation {

    private int id;
    private String name;

    private int workspaceId;
    private String workspaceName;

    private int totalOrgs;
    private int totalApps;
    private int totalAppsInstance;
    private int totalAppsMemory;    

    @JsonProperty("foundation")
    private void unpackNameFromNestedObject(Map<String, Object> foundation) {
        name = (String)foundation.get("name");
        id = (Integer)foundation.get("id");

        Map<String, Object> workspace = (Map<String, Object>) foundation.get("workspace");
        workspaceId = (Integer)workspace.get("id");
        workspaceName = (String)workspace.get("name");
    }    
}
