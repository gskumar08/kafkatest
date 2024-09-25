package com.customer.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ListenerPayload {
    private String name;
    private String description;
    private String type;
    private String user;
    private String eventId;
    private String component;
    private Object componentSpecificProps;
    private boolean secure;
    private String protocol;
    private String host;
    private Integer port;
    private Object authenticationInfo;
    private Object componentSpecificConnProps;
    private List<String> ipAddresses;
}
