
import java.io.*;
import java.net.*;
public class Server1 extends ServerSocket
{
private static final int SERVER_PORT = 10000;
public Server1() throws IOException
{
super(SERVER_PORT);
try
{
while (true)
{
Socket socket = accept();
new CreateServerThread(socket);
}
}
catch (IOException e)
{}
finally
{
close();
}
}
//--- CreateServerThread
class CreateServerThread extends Thread
{
private Socket client;
private BufferedReader in;
private PrintWriter out;
public CreateServerThread(Socket s) throws IOException
{
client = s;
in = new BufferedReader(new InputStreamReader(client.getInputStream(), "GB2312"));
out = new PrintWriter(client.getOutputStream(), true);
out.println("--- Welcome ---");
start();
}
public void run()
{
try
{
String line = in.readLine();
while (!line.equals("bye"))
{
String msg = createMessage(line);
out.println(msg);
line = in.readLine();
}
out.println("--- See you, bye! ---");
client.close();
}
catch (IOException e)
{}
}
private String createMessage(String line)
{
	return line;
}
}
@SuppressWarnings("resource")
public static void main(String[] args) throws IOException
{
new Server1();
}
}
