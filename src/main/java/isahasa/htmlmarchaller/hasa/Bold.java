package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Bold extends TextDecorator{

    public Bold(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<b>" + textSource.getPlainText() + "</b>";
    }
}
