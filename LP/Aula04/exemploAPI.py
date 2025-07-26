import requests

link = 'https://0fae6ab5-504e-4513-95fa-b73787f71249-00-341u61l2mf3u7.spock.replit.dev/total'

requisicao = requests.get(link)

#print(requisicao)
#print(requisicao.json())

dicionario = requisicao.json()
print(dicionario)



