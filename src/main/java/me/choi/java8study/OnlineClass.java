package me.choi.java8study;

import java.util.Optional;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:06 오후
 */
public class OnlineClass {
    private Integer id;
    private String title;
    private boolean closed;
    private Progress progress;

    public OnlineClass(Integer id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public Optional<Progress> getProgress() {
        return Optional.ofNullable(progress);
    }

    public void setProgress(Optional<Progress> progress) {
        if (progress != null) {
            progress.ifPresent(p -> this.progress = p);
        }
    }
}
