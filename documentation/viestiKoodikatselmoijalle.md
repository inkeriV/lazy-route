### Koodikatselmoija

##### Taustatietoa (päivitetty 17.8.)
Kävin vanhan koulutusohjelman mukaisen OTM:n jo pari lukuvuotta sitten, ja mitä olen kuullut, se oli nyt viime keväänä aika erilainen. 
Kuulemani perusteella tuntuu siltä, että uudemmasta kurssista olisi ollut paljon hyötyä tässä, joten jos minulta puuttuu jotain tosi oleellista tai koodi on aivan kuraa niin mielellään kerro.
Suurin ongelma mulla on nyt testien kanssa, koska oma taso on siltä aiemmalta OTM-kurssilta sellasta assertEquals(22, opiskelija.getIka())-luokkaa (-.-) ja nyt suurin osa metodeista on voideja ja suoraansanottuna en ymmärrä miten niitä pitäisi testata.
Tähän iltaan asti minulla oli vielä lähes kaikki staattista, ja vasta nyt tajusin tehdä verkostakin olion, jolloin testien tekemisen pitäisi kai olla helpompaa.
Mutta laitan asiasta tänään viestiä ohjaajalle, joten ei tarvi ruveta opettamaan ellei halua. Tämä vain syy miksei testejä ole :')
Päivitän tätä viestiä myös sen mukaan, mitä saan ensiviikon aikana tehtyä (ja onko katselmointi jo tehty), joten loppuviikosta toivottavasti tätä ongelmaa ei enää ole.

##### Testaus verkko
Tässä yksi isompi verkko ohjelman testaamiseen, ettei itse tarvitse ruveta näpyttelemään. 

```
mvn compile exec:java -Dexec.mainClass=lazyroute.Verkko
```


10x10 verkko, näyttää tältä

```
1 - 2 - 2 - 2 - 2 - 2 - 9 - 9 - 9 - 7
|   |	|   |	|   |   |   |   |   |
3 - 3 - 3 - 4 - 3 - 4 - 3 - 2 - 1 - 2
|   |   |   |   |   |   |   |   |   |
5 - 5 - 5 - 5 - 6 - 6 - 6 - 7 - 3 - 1
|   |   |   |   |   |   |   |   |   |
3 - 4 - 4 - 4 - 4 - 4 - 2 - 2 - 1 - 1
|   |   |   |   |   |   |   |   |   |
7 - 7 - 7 - 7 - 3 - 3 - 2 - 1 - 5 - 3
|   |   |   |   |   |   |   |   |   |
1 - 2 - 2 - 2 - 2 - 2 - 9 - 9 - 9 - 7
|   |   |   |   |   |   |   |   |   |
3 - 3 - 3 - 4 - 3 - 4 - 3 - 2 - 1 - 2
|   |   |   |   |   |   |   |   |   |
5 - 5 - 5 - 5 - 6 - 6 - 6 - 6 - 3 - 1
|   |   |   |   |   |   |   |   |   |
3 - 4 - 4 - 4 - 4 - 4 - 2 - 2 - 1 - 1
|   |   |   |   |   |   |   |   |   |
7 - 7 - 7 - 7 - 3 - 3 - 2 - 1 - 5 - 3
```

