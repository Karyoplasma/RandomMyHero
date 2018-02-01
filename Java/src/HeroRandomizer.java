import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Observable;
import java.util.Random;

public class HeroRandomizer extends Observable{
	
	private List<String> intHeroes, strHeroes, agiHeroes, allHeroes;
	private Random random;
	
	public HeroRandomizer(RandomMyHero obs) {
		this.addObserver(obs);
		this.strHeroes = new ArrayList<String>();
		this.agiHeroes = new ArrayList<String>();
		this.intHeroes = new ArrayList<String>();
		this.allHeroes = new ArrayList<String>();
		this.random = new Random();
		this.readHeroList();
	}
	
	private void readHeroList() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(new File("heroList.txt")));
			String in;
			while ((in = reader.readLine()) != null) {
				String[] inSplit = in.split("=");
				String[] heroList = inSplit[1].split(",");
				if (this.strHeroes.isEmpty()) {
					for (String hero : heroList) {
						this.strHeroes.add(hero);
					}
				} else {
					if (this.agiHeroes.isEmpty()) {
						for (String hero : heroList) {
							this.agiHeroes.add(hero);
						}
					} else {
						for (String hero : heroList) {
							this.intHeroes.add(hero);
						}
					}
				}
			}
			reader.close();
			this.allHeroes.addAll(strHeroes);
			this.allHeroes.addAll(agiHeroes);
			this.allHeroes.addAll(intHeroes);
			Collections.shuffle(strHeroes);
			Collections.shuffle(agiHeroes);
			Collections.shuffle(intHeroes);
			Collections.shuffle(allHeroes);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			updateHero("Hero list not found!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			updateHero("Error reading hero list!");
		}	
	}
	
	public void randomHero(int mode) {
		if (mode == 0) {
			updateHero(this.randomAll());
			return;
		}
		if (mode == 1) {
			updateHero(this.randomStr());
			return;
		}
		if (mode == 2) {
			updateHero(this.randomAgi());
			return;
		}
		if (mode == 3) {
			updateHero(this.randomInt());
			return;
		}
	}
	
	private String randomInt() {
		return this.intHeroes.get(random.nextInt(this.intHeroes.size()));
	}

	private String randomAgi() {
		return this.agiHeroes.get(random.nextInt(this.agiHeroes.size()));
	}

	private String randomStr() {
		return this.strHeroes.get(random.nextInt(this.strHeroes.size()));
	}

	private String randomAll() {
		return this.allHeroes.get(random.nextInt(this.allHeroes.size()));
	}

	private void updateHero(String hero) {
		this.setChanged();
		this.notifyObservers(hero);
	}
}
