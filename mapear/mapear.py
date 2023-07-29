import re

padrao = r"\[(.*?)\]"

arquivo = "tabelas.txt"




with open(arquivo) as file:

    for linha in file:

        linha=linha.split()

        nome=linha[2].replace("[","").replace("]","")

        tipo=re.findall(padrao,linha[3])

        match tipo:

            case ['int']:

                tipo="Integer"

            case ['varchar']:

                tipo= "String"

        print(f"private {tipo} {nome}\n")