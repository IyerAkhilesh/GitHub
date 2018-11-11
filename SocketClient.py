import socket
import ZKP_Serverless.python_files.NumberGenerator_V0 as csprng

HOST = "127.0.0.1"
PORT = 9095

with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as sock:
    sock.connect((HOST, PORT))
    username = input("Enter your username: ")
    password = input("Enter your password")

    user_number = csprng.username_processor(username)
    print(user_number)
    user_number_factors = csprng.factorizer(user_number)
    # print(user_number_factors)
    user_number_factors_one, user_number_factors_two = user_number_factors[0: user_number_factors.find(',')], user_number_factors[user_number_factors.find(',')+1:len(user_number_factors)]
    # print(user_number_factors_one, user_number_factors_two)
    pass_number = str(csprng.password_to_number(password))
    print(pass_number)

    print("Sending n1")
    sock.sendall(bytes(user_number_factors_one, "UTF-8"))
    serverMessage = sock.recv(1024)
    print("Received message: ", repr(serverMessage)[2:len(repr(serverMessage)) - 1])

    print("Sending n2")
    sock.sendall(bytes(user_number_factors_two, "UTF-8"))
    serverMessageTwo = sock.recv(1024)
    print("Received message: ", repr(serverMessageTwo)[2:len(repr(serverMessage)) - 1])

    print("Sending Sa")
    sock.sendall(bytes(pass_number, "UTF-8"))
    serverMessageThree = sock.recv(1024)
    print("Received message: ", repr(serverMessageThree)[2:len(repr(serverMessage)) - 1])

