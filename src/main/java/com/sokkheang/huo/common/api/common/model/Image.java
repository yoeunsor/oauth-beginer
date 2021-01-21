package com.sokkheang.huo.common.api.common.model;

public class Image {
    private int id;
    private String name;
    private String uri;
    private String type;
    private long size;
    private String createby;
    private String createdatetime;
    private String lastchangeby;
    private String lastchangedatetime;
    private String statuscode;

    public Image() {
    }

    public Image(int id, String name, String uri, String type, long size, String createby, String createdatetime, String lastchangeby, String lastchangedatetime, String statuscode) {
        this.id = id;
        this.name = name;
        this.uri = uri;
        this.type = type;
        this.size = size;
        this.createby = createby;
        this.createdatetime = createdatetime;
        this.lastchangeby = lastchangeby;
        this.lastchangedatetime = lastchangedatetime;
        this.statuscode = statuscode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getCreateby() {
        return createby;
    }

    public void setCreateby(String createby) {
        this.createby = createby;
    }

    public String getCreatedatetime() {
        return createdatetime;
    }

    public void setCreatedatetime(String createdatetime) {
        this.createdatetime = createdatetime;
    }

    public String getLastchangeby() {
        return lastchangeby;
    }

    public void setLastchangeby(String lastchangeby) {
        this.lastchangeby = lastchangeby;
    }

    public String getLastchangedatetime() {
        return lastchangedatetime;
    }

    public void setLastchangedatetime(String lastchangedatetime) {
        this.lastchangedatetime = lastchangedatetime;
    }

    public String getStatuscode() {
        return statuscode;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uri='" + uri + '\'' +
                ", type='" + type + '\'' +
                ", size=" + size +
                ", createby='" + createby + '\'' +
                ", createdatetime='" + createdatetime + '\'' +
                ", lastchangeby='" + lastchangeby + '\'' +
                ", lastchangedatetime='" + lastchangedatetime + '\'' +
                ", statuscode='" + statuscode + '\'' +
                '}';
    }
}
