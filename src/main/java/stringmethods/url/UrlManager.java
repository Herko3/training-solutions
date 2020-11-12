package stringmethods.url;

public class UrlManager {

    private String protocol;
    private Integer port;
    private String host;
    private String path;
    private String query;

    public UrlManager(String url){
        if(!url.contains("://")){
            throw new IllegalArgumentException("Invalid url");
        }
        url=url.toLowerCase();
        protocol = url.substring(0,url.indexOf("://"));
        if(url.substring(protocol.length()+3).length()<=protocol.length()){
            throw new IllegalArgumentException("Invalid url");
        }
        hostPathPortQuery(url);
    }

    public boolean hasProperty(String key){
        if(key == null || key.trim().equals("")){
            throw new IllegalArgumentException();
        }
        String[] querys = query.split("&");
        for (String item : querys){
            if (item.contains(key)){
                String[] match = item.split("=");
                if(match[0].equals(key)) {
                    return true;
                }
                continue;
            }
        }
        return false;
    }

    public String getProperty(String key){
        if(key == null || key.trim().equals("")){
            throw new IllegalArgumentException();
        }
        String[] querys = query.split("&");
        for (String item : querys){
            if (item.contains(key)){
                String[] match = item.split("=");
                if(match[0].equals(key)) {
                    return match[1];
                }
                continue;
            }
        }
    return null;
    }

    public String getProtocol() {
        return protocol;
    }

    public Integer getPort() {
        return port;
    }

    public String getHost() {
        return host;
    }

    public String getPath() {
        return path;
    }

    private void hostPathPortQuery(String url){
        String help = url.substring(protocol.length()+3);
        if(help.contains(":")){
            host = help.substring(0,help.indexOf(":"));
            if(help.substring(host.length()+1).contains("/")){
                port = Integer.parseInt(help.substring(host.length() + 1,help.indexOf("/")));
            } else {
                port = Integer.parseInt(help.substring(host.length() + 1));
            }
        } else {
            host = help.substring(0,help.indexOf("/"));
        }

        if(help.contains("?")){
            path = help.substring(help.indexOf("/",host.length()),help.indexOf("?"));
            query = help.substring(help.indexOf("?")+1);
        } else {
            path = "";
            query = "";
        }
    }
}
