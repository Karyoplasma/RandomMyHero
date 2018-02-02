import requests
import bs4

def getHeroList():
    '''Get a list of heroes from gamepedia and write to heroList.txt'''
    res = requests.get('https://dota2.gamepedia.com/Heroes')
    res.raise_for_status()
    print('Fetching hero list...')
    soup = bs4.BeautifulSoup(res.text, 'html.parser')
    masterTable = soup.select('table')
    heroTables = masterTable[0].findAll('tr')

    strength = "Strength="
    strHeroes = heroTables[1].findAll('span')
    strength += ','.join(hero.text for hero in strHeroes)

    agility = "Agility="
    agiHeroes = heroTables[3].findAll('span')
    agility += ','.join(hero.text for hero in agiHeroes)

    intelligence = "Intelligence="
    intHeroes = heroTables[5].findAll('span')
    intelligence += ','.join(hero.text for hero in intHeroes)

    print('Writing hero list to file...')

    with open("heroList.txt", 'w') as f:
        f.write(strength)
        f.write('\n')
        f.write(agility)
        f.write('\n')
        f.write(intelligence)
        f.write('\n')

    print('Done.')

if __name__ == '__main__':
    getHeroList()
