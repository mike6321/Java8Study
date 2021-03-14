package me.choi.java8study;

import java.time.Duration;

/**
 * Project : java8study
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 6:06 오후
 */
public class Progress {
    private Duration studyDuration;

    private boolean finished;

    public Duration getStudyDuration() {
        return studyDuration;
    }

    public void setStudyDuration(Duration studyDuration) {
        this.studyDuration = studyDuration;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }
}
