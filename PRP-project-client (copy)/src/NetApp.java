import client.NetClient;
import server.NetServer;

public class NetApp {

public static void main(String[] args) throws Exception {
    if ( args.length < 2) return;
    int portNumber = Integer.parseInt(args[1]);

    if(args[0].equalsIgnoreCase("server")){
        NetServer server = new NetServer(portNumber);
        System.out.println("Server is running");
        server.run();
        server.close();
    } else if(args[0].equalsIgnoreCase("client")) {
        String serverAdress = args[2];
        NetClient client = new NetClient(serverAdress, portNumber);
        System.out.println(client.getResponse());
        client.close();
    }
}


}
