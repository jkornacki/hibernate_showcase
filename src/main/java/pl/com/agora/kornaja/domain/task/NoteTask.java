package pl.com.agora.kornaja.domain.task;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by P on 2015-11-23.
 */
@Entity
@DiscriminatorValue("note")
public class NoteTask extends Task {

    @Column(length = 10000)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
