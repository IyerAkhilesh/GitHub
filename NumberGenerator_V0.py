from random import random

# username = input("Enter a username here mayn ")
# password = input("Enter a bloody password for god's sake! ")
password_dictionary = \
{
  "0": 152,
  "1": 153,
  "2": 154,
  "3": 155,
  "4": 156,
  "5": 157,
  "6": 158,
  "7": 159,
  "8": 160,
  "9": 161,
  "s": 100,
  "m": 101,
  "a": 102,
  "j": 103,
  "c": 104,
  "d": 105,
  "b": 106,
  "t": 107,
  "r": 108,
  "p": 109,
  "k": 110,
  "l": 111,
  "g": 112,
  "h": 113,
  "n": 114,
  "e": 115,
  "f": 116,
  "w": 117,
  "i": 118,
  "v": 119,
  "o": 120,
  "y": 121,
  "z": 122,
  "u": 123,
  "x": 124,
  "q": 125,
  "S": 126,
  "M": 127,
  "A": 128,
  "J": 129,
  "C": 130,
  "D": 131,
  "B": 132,
  "T": 133,
  "R": 134,
  "P": 135,
  "K": 136,
  "L": 137,
  "G": 138,
  "H": 139,
  "N": 140,
  "E": 141,
  "F": 142,
  "W": 143,
  "I": 144,
  "V": 145,
  "O": 146,
  "Y": 147,
  "Z": 148,
  "U": 149,
  "X": 150,
  "Q": 151,
  "!": 162,
  "@": 163,
  "#": 164,
  "$": 165,
  "%": 166,
  "^": 167,
  "&": 168,
  "*": 169,
  "(": 170,
  ")": 171,
}

def username_processor(username_argument):
    ascii_array = []
    for character_counter in range(0, len(username_argument)):
        ascii_array.append(ord(username_argument[character_counter]))
    # print(ascii_array)

    binary_ascii_array = []
    for array_counter in range(0, len(ascii_array)):
        binary_ascii_array.append('{0:07b}'.format(ascii_array[array_counter]))
    # print(binary_ascii_array)

    xored_array = ""
    for binary_counter in range(0, len(binary_ascii_array)):
        b = int(binary_ascii_array[binary_counter][0]) ^ int(binary_ascii_array[binary_counter][1]) ^ int(binary_ascii_array[binary_counter][2]) ^ int(binary_ascii_array[binary_counter][3])
        xored_array += "".join(str(b))
        b = int(binary_ascii_array[binary_counter][4]) ^ int(binary_ascii_array[binary_counter][5]) ^ int(binary_ascii_array[binary_counter][6])
        xored_array += "".join(str(b))
    # print(xored_array, int(xored_array, 2))
    return int(xored_array, 2)

# static_xored_array = username_processor(username)
def factorizer(composite_number):
    factors = []
    for counter in range(2, composite_number):
        if composite_number % counter == 0:
            factors.append(counter)

    number_of_factors = len(factors)
    # if option == 0:
    #     print("Best factors via mean sampling: ", factors[int(number_of_factors/2) - 1], factors[int(number_of_factors/2)])
    # elif option == 1:
    #     print("Best factors via quartile sampling: ", factors[int(number_of_factors/4)], factors[3*int(number_of_factors/4)])
    modulus = int(number_of_factors*random())
    # factor_one = str(factors[modulus])
    # factor_two = str(factors[number_of_factors - modulus - 1])
    factor_one = factors[int(number_of_factors/2) - 1]
    factor_two = factors[int(number_of_factors/2)]
    factors_string = "" + str(factor_one) + "," + str(factor_two)
    # print(factors_string)
    return factors_string
    # print("Factors ", factors)
# factorizer(int(static_xored_array, 2), 2)

def password_to_number(argument_password):
    masking_sum = 0
    for counter in range(0, len(argument_password)):
        # print(" sum after ", counter, " is ", sum)
        masking_sum = masking_sum + password_dictionary.get(argument_password[counter])
    # print("Number generated is Sa: ", masking_sum)
    return masking_sum
# password_to_number(password)