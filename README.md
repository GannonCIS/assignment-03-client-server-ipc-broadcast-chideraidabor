# CIS330-FA20-ClientServerIPC

The thread implementation is already done.
You just need to complete the code and methods that are related to client-server communication
I have placed "TODO" comments to the places where you need to code

How you will test:
* Run three server programs on three different ports
* Run  9 client programs, 3 for each server
* Your program will do the following:
** Login valid users using user name and password
** Login will take place in client end
** Display appropriate error messages if worng username, or wrong password is given
** Once state == atLoggedIn which means client logged in, then client will see a list of options
** Client needs to press the corresponding number to see the connected clients except self, to send a broad-casted
message to all other clients and to get the list of clients joined in last 2 minutes
