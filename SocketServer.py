import socket

HOST = "127.0.0.1"
PORT = 9095
ACK_COUNTER = 0

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:     #automatically closes sock at the end of the block
    sock.bind((HOST, PORT))
    sock.listen(5)
    connection, address = sock.accept()
    with connection:                                                #automatically closes connection at the end of the block
        print("Connected to: ", address)
        while True:
            clientMessage = connection.recv(1024)
            if clientMessage:
                print(repr(clientMessage)[2:len(repr(clientMessage)) - 1])
                ACK_COUNTER += 1
                connection.sendall(bytes("ACK-" + str(ACK_COUNTER), "UTF-8"))
            else:
                break
    connection.close()
sock.close()