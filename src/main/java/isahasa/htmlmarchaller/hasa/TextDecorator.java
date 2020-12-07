package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public abstract class TextDecorator implements TextSource {

    protected TextSource textSource;

    public TextDecorator(TextSource textSource) {
        this.textSource = textSource;
    }
}
