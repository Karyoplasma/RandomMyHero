import os, requests, bs4

def getHeroList():
    res = requests.get('https://dota2.gamepedia.com/Heroes')
    res.raise_for_status()
    print('Fetching hero list...')
    soup = bs4.BeautifulSoup(res.text, 'html.parser')
    masterTable = soup.select('table')
    heroTables = masterTable[0].findAll('tr')
    strength = "Strength="
    strHeroes = heroTables[1].findAll('span')
    for x in range(0,len(strHeroes)):
        strength += strHeroes[x].text
        if x != len(strHeroes) - 1:
            strength += ','
    agility = "Agility="
    agiHeroes = heroTables[3].findAll('span')
    for x in range(0,len(agiHeroes)):
        agility += agiHeroes[x].text
        if x != len(agiHeroes) - 1:
            agility += ','
    intelligence = "Intelligence="
    intHeroes = heroTables[5].findAll('span')
    for x in range(0,len(intHeroes)):
        intelligence += intHeroes[x].text
        if x != len(intHeroes) - 1:
            intelligence += ','
    print('Writing hero list to file...')
    file = open("heroList.txt", 'w')
    file.write(strength)
    file.write('\n')
    file.write(agility)
    file.write('\n')
    file.write(intelligence)
    file.write('\n')
    file.close()
    print('Done.')

    
getHeroList()
