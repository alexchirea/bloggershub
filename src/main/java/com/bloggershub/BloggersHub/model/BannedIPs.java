package com.bloggershub.BloggersHub.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="bannedips")
public class BannedIPs {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String ip;
}
