package web.factoryBrowser;

public class FactoryBrowser {

    public static IBrowser make(String type) {
        IBrowser browser;

        switch (type.toLowerCase()) {
            case "chrome":
                browser = new Chrome();
                break;
            case "firefox":
                browser = new FireFox();
                break;
            default:
                browser = new Edge();
                break;
        }

        return browser;

    }

}
