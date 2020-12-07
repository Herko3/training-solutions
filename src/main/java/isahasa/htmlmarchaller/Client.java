package isahasa.htmlmarchaller;

public class Client {

    private Channel channel;

    public Client(Channel channel) {
        this.channel = channel;
    }

    public int writeToChannel(TextSource source){
        return channel.writeByte(source.getPlainText().getBytes());
    }

}
