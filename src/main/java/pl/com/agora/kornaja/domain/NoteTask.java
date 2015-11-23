package pl.com.agora.kornaja.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by kornaja.
 */
@Entity
@DiscriminatorValue(value = "note")
public class NoteTask extends Task {

    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
